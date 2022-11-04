package tk.hildebrandt.ddd.plain.todo;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component
public class TodoTestdataService {

   private TodoRepository todoRepository;

   public TodoTestdataService(TodoRepository todoRepository) {
      this.todoRepository = todoRepository;
   }

   @Transactional
   public TodoItem createOpenTodoItem() {
      return createOpenTodoItem(new TodoItemId());
   }

   @Transactional
   public TodoItem createOpenTodoItem(TodoItemId todoItemId) {
      return todoRepository.save(new TodoItem(todoItemId, new Description("Test"), State.OPEN));
   }
}

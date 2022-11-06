package tk.hildebrandt.ddd.modulith.todo;

import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

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

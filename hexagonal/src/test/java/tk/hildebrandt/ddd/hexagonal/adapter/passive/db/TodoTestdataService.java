package tk.hildebrandt.ddd.hexagonal.adapter.passive.db;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import tk.hildebrandt.ddd.hexagonal.domain.Description;
import tk.hildebrandt.ddd.hexagonal.domain.State;
import tk.hildebrandt.ddd.hexagonal.domain.TodoItem;
import tk.hildebrandt.ddd.hexagonal.domain.TodoItemId;
import tk.hildebrandt.ddd.hexagonal.ports.passive.TodoRepository;

@Component
public class TodoTestdataService {

   private final TodoRepository todoRepository;

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

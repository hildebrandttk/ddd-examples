package tk.hildebrandt.ddd.onion.core;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Component;

import tk.hildebrandt.ddd.onion.infra.jpa.TodoJpaRepository;

@Component
public class TodoTestdataService {

   private final TodoJpaRepository todoRepository;

   public TodoTestdataService(TodoJpaRepository todoRepository) {
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

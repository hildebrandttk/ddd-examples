package tk.hildebrandt.ddd.hexagonal.service;

import java.util.UUID;

import tk.hildebrandt.ddd.hexagonal.domain.TodoItemId;

public class FinishCommand {
   private final UUID todoItemId;

   private FinishCommand(UUID todoItemId) {
      this.todoItemId = todoItemId;
   }

   public static FinishCommand createFinishCommand(UUID todoItemId) {
      return new FinishCommand(todoItemId);
   }

   public UUID getTodoItemId() {
      return todoItemId;
   }
}

package tk.hildebrandt.ddd.hexagonal.service;

import java.util.UUID;

public class StartProcessCommand {
   private final UUID todoItemId;

   private StartProcessCommand(UUID todoItemId) {
      this.todoItemId = todoItemId;
   }

   public static StartProcessCommand createStartProcessCommand(UUID todoItemId) {
      return new StartProcessCommand(todoItemId);
   }

   public UUID getTodoItemId() {
      return todoItemId;
   }
}

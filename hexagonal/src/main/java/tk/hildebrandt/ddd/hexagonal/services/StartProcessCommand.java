package tk.hildebrandt.ddd.hexagonal.services;

import tk.hildebrandt.ddd.hexagonal.domain.TodoItemId;

public class StartProcessCommand {
   private final TodoItemId todoItemId;

   private StartProcessCommand(TodoItemId todoItemId) {

      this.todoItemId = todoItemId;
   }

   public static StartProcessCommand createStartProcessCommand(TodoItemId todoItemId) {
      return new StartProcessCommand(todoItemId);
   }

   public TodoItemId getTodoItemId() {
      return todoItemId;
   }
}

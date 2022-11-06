package tk.hildebrandt.ddd.onion.core;

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

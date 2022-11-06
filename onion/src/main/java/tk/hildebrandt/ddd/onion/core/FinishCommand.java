package tk.hildebrandt.ddd.onion.core;

public class FinishCommand {
   private final TodoItemId todoItemId;

   private FinishCommand(TodoItemId todoItemId) {

      this.todoItemId = todoItemId;
   }

   public static FinishCommand createFinishCommand(TodoItemId todoItemId) {
      return new FinishCommand(todoItemId);
   }

   public TodoItemId getTodoItemId() {
      return todoItemId;
   }
}

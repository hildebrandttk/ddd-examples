package tk.hildebrandt.ddd.modulith.todo;

import org.springframework.context.ApplicationEvent;

public class ProcessStatedEvent extends ApplicationEvent {
   private final TodoItem todoItem;

   ProcessStatedEvent(TodoItem todoItem) {
      super(todoItem);
      this.todoItem = todoItem;
   }

   public TodoItem getTodoItem() {
      return todoItem;
   }
}

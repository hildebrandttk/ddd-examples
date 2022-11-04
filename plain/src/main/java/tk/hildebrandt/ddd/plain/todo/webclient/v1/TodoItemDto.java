
package tk.hildebrandt.ddd.plain.todo.webclient.v1;

import java.util.Objects;

public class TodoItemDto {

   private final String todoItemId;
   private final String state;

   private final String description;

   TodoItemDto(String todoItemId, String state, String description) {
      this.todoItemId = todoItemId;
      this.state = state;
      this.description = description;
   }

   public String getTodoItemId() {
      return todoItemId;
   }

   public String getState() {
      return state;
   }

   public String getDescription() {
      return description;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      TodoItemDto that = (TodoItemDto) o;
      return Objects.equals(todoItemId, that.todoItemId) && Objects.equals(state, that.state) && Objects.equals(description, that.description);
   }

   @Override
   public int hashCode() {
      return Objects.hash(todoItemId, state, description);
   }

   @Override
   public String toString() {
      return "TodoItemDto{" +
         "todoItemId='" + todoItemId + '\'' +
         ", state='" + state + '\'' +
         ", description='" + description + '\'' +
         '}';
   }
}

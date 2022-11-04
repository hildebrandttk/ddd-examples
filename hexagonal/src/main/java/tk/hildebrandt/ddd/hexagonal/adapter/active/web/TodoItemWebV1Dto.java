
package tk.hildebrandt.ddd.hexagonal.adapter.active.web;

import java.util.Objects;

public class TodoItemWebV1Dto {

   private final String todoItemId;
   private final String description;
   private final String state;

   TodoItemWebV1Dto(String todoItemId, String description, String state) {
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
      TodoItemWebV1Dto that = (TodoItemWebV1Dto) o;
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

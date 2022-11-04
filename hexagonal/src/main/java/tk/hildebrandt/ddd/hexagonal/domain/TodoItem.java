package tk.hildebrandt.ddd.hexagonal.domain;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class TodoItem {
   @EmbeddedId
   private TodoItemId todoItemId;

   private String description;

   @Enumerated(EnumType.STRING)
   private State state;

   //for jpa
   protected TodoItem() {
   }

   public TodoItem(TodoItemId todoItemId, Description description, State state) {
      this.todoItemId = todoItemId;
      this.description = description.getValue();
      this.state = state;
   }

   public void finish() {
      state = State.FINISHED;
   }

   public void startProcess() {
      state = State.IN_PROGRESS;
   }

   public TodoItemId getTodoItemId() {
      return todoItemId;
   }

   public Description getDescription() {
      return new Description(description);
   }

   public State getState() {
      return state;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      TodoItem todoItem = (TodoItem) o;
      return Objects.equals(todoItemId, todoItem.todoItemId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(todoItemId);
   }
}

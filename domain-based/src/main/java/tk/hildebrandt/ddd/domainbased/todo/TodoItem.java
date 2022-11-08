package tk.hildebrandt.ddd.domainbased.todo;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class TodoItem {
   @EmbeddedId
   private TodoItemId todoItemId;

   private Description description;

   @Enumerated(EnumType.STRING)
   private State state;

   private DueDate dueDate;

   //for jpa
   protected TodoItem() {
   }

   public TodoItem(TodoItemId todoItemId, Description description, State state) {
      this.todoItemId = todoItemId;
      this.description = description;
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
      return description;
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

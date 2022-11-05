package tk.hildebrandt.ddd.hexagonal.adapter.passive.db;

import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import tk.hildebrandt.ddd.hexagonal.domain.Description;
import tk.hildebrandt.ddd.hexagonal.domain.State;
import tk.hildebrandt.ddd.hexagonal.domain.TodoItemId;

@Entity
public class TodoItemJpaEntity {
   @Id
   @Column(columnDefinition = "uuid")
   private UUID todoItemId;

   private String description;

   private String state;

   //for jpa
   protected TodoItemJpaEntity() {
   }

   public TodoItemJpaEntity(UUID todoItemId, String description, String state) {
      this.todoItemId = todoItemId;
      this.description = description;
      this.state = state;
   }

   public UUID getTodoItemId() {
      return todoItemId;
   }

   public String getDescription() {
      return description;
   }

   public String getState() {
      return state;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      TodoItemJpaEntity todoItem = (TodoItemJpaEntity) o;
      return Objects.equals(todoItemId, todoItem.todoItemId);
   }

   @Override
   public int hashCode() {
      return Objects.hash(todoItemId);
   }
}

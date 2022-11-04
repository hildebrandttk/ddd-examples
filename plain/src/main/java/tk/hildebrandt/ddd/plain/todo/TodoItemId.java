package tk.hildebrandt.ddd.plain.todo;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TodoItemId implements Serializable {
   @Column(columnDefinition = "uuid")
   private UUID id;

   public TodoItemId() {
      this(UUID.randomUUID());
   }

   public TodoItemId(UUID id) {
      this.id = id;
   }

   public UUID getId() {
      return id;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      TodoItemId that = (TodoItemId) o;
      return Objects.equals(id, that.id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }
}

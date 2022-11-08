package tk.hildebrandt.ddd.modulith.user;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserId implements Serializable {
   @Column(columnDefinition = "uuid")
   private UUID id;

   public UserId() {
      this(UUID.randomUUID());
   }

   public UserId(UUID id) {
      this.id = id;
   }

   public UUID getId() {
      return id;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      UserId that = (UserId) o;
      return Objects.equals(id, that.id);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id);
   }
}

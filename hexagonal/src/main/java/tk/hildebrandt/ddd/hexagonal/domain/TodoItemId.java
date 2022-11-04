package tk.hildebrandt.ddd.hexagonal.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TodoItemId implements Serializable {
   public static final Pattern UUID_PATTERN = Pattern.compile("^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$");
   private final UUID id;

   public TodoItemId() {
      this(UUID.randomUUID());
   }

   public TodoItemId(UUID id) {
      this.id = id;
   }

   public TodoItemId(String id) {
      Matcher matcher = UUID_PATTERN.matcher(id);
      if(!matcher.matches()) {
         throw new IllegalArgumentException("id is no valid UUID");
      }
      this.id = UUID.fromString(id);
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

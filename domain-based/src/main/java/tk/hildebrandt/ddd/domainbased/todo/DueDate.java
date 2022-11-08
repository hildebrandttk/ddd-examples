package tk.hildebrandt.ddd.domainbased.todo;

import java.time.Instant;

public class DueDate {
   private Instant value;

   public DueDate(Instant value) {
      this.value = value;
   }

   public Instant getValue() {
      return value;
   }
}

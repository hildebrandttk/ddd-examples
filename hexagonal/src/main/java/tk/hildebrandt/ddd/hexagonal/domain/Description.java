package tk.hildebrandt.ddd.hexagonal.domain;

public class Description {
   private final String value;

   public Description(String value) {
      this.value = value;
   }

   public String getValue() {
      return value;
   }
}

package tk.hildebrandt.ddd.domainbased.todo;

public class Description {
   private final String value;

   public Description(String value) {
      this.value = value;
   }

   public String getValue() {
      return value;
   }
}

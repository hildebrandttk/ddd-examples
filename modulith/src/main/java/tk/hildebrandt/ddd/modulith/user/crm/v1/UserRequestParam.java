package tk.hildebrandt.ddd.modulith.user.crm.v1;

public class UserRequestParam {
   private String firstname;
   private String lastname;
   private String state;

   public String getFirstname() {
      return firstname;
   }

   public void setFirstname(String firstname) {
      this.firstname = firstname;
   }

   public String getLastname() {
      return lastname;
   }

   public UserRequestParam setLastname(String lastname) {
      this.lastname = lastname;
      return this;
   }

   public String getState() {
      return state;
   }

   public UserRequestParam setState(String state) {
      this.state = state;
      return this;
   }
}

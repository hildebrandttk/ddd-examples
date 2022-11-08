package tk.hildebrandt.ddd.modulith.user;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_reference")
public class User {
   @EmbeddedId
   private UserId userId;

   private Firstname firstname;
   private Lastname lastname;
   private UserState state;
//for jpa
   protected User() {
   }

   public User(UserId userId, Firstname firstname, Lastname lastname, UserState state) {
      this.userId = userId;
      this.firstname = firstname;
      this.lastname = lastname;
      this.state = state;
   }

   public UserId getUserId() {
      return userId;
   }

   public Firstname getFirstname() {
      return firstname;
   }

   public Lastname getLastname() {
      return lastname;
   }

   public UserState getState() {
      return state;
   }
}

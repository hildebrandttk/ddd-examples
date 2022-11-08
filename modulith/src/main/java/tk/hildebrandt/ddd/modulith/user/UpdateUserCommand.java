package tk.hildebrandt.ddd.modulith.user;

public class UpdateUserCommand {
   private final UserId userId;
   private final Firstname firstname;
   private final Lastname lastname;
   private final UserState state;

   public UpdateUserCommand(UserId userId, Firstname firstname, Lastname lastname, UserState state) {
      this.userId = userId;
      this.firstname = firstname;
      this.lastname = lastname;
      this.state = state;
   }

   public static UpdateUserCommand updateUserCommand(UserId userId, Firstname firstname, Lastname lastname, UserState state) {
      return new UpdateUserCommand(userId, firstname, lastname, state);
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

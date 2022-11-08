package tk.hildebrandt.ddd.modulith.user;

public record UpdateUserCommand(UserId userId, Firstname firstname, Lastname lastname, UserState state) {

   public static UpdateUserCommand updateUserCommand(UserId userId, Firstname firstname, Lastname lastname, UserState state) {
      return new UpdateUserCommand(userId, firstname, lastname, state);
   }
}

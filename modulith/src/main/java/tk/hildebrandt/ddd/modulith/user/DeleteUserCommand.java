package tk.hildebrandt.ddd.modulith.user;

public record DeleteUserCommand(UserId userId) {

   public static DeleteUserCommand deleteUserCommand(UserId userId) {
      return new DeleteUserCommand(userId);
   }
}

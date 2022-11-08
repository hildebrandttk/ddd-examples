package tk.hildebrandt.ddd.modulith.user;

public class DeleteUserCommand {
   private final UserId userId;

   public DeleteUserCommand(UserId userId) {
      this.userId = userId;
   }

   public static DeleteUserCommand deleteUserCommand(UserId userId) {
      return new DeleteUserCommand(userId);
   }

   public UserId getUserId() {
      return userId;
   }
}

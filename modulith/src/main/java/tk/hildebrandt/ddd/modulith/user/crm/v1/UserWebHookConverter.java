package tk.hildebrandt.ddd.modulith.user.crm.v1;

import java.util.UUID;

import org.springframework.stereotype.Component;

import tk.hildebrandt.ddd.modulith.user.DeleteUserCommand;
import tk.hildebrandt.ddd.modulith.user.Firstname;
import tk.hildebrandt.ddd.modulith.user.Lastname;
import tk.hildebrandt.ddd.modulith.user.UpdateUserCommand;
import tk.hildebrandt.ddd.modulith.user.UserId;
import tk.hildebrandt.ddd.modulith.user.UserState;

@Component
public class UserWebHookConverter {
   public UpdateUserCommand toUpdateCommand(String userId, UserRequestParam userUpdateRequestParam) {
      return UpdateUserCommand.updateUserCommand(new UserId(UUID.fromString(userId)), new Firstname(userUpdateRequestParam.getFirstname()), new Lastname(userUpdateRequestParam.getLastname()), UserState.valueOf(userUpdateRequestParam.getState()));
   }

   public DeleteUserCommand toDeleteCommand(String userId) {
      return DeleteUserCommand.deleteUserCommand(new UserId(UUID.fromString(userId)));
   }
}

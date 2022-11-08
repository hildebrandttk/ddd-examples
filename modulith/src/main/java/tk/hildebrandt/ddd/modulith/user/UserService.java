package tk.hildebrandt.ddd.modulith.user;

import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserService {
   public Optional<User> update(UpdateUserCommand updateUserCommand) {
      return null;
   }

   public void delete(DeleteUserCommand deleteUserCommand) {
   }
}

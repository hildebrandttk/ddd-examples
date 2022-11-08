package tk.hildebrandt.ddd.modulith.user;

import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

@Component
public class UserTestdataService {

   private final UserRepository userRepository;

   public UserTestdataService(UserRepository userRepository) {
      this.userRepository = userRepository;
   }

   @Transactional
   public User createValidActiveUser() {
      return userRepository.save(new User(new UserId(), new Firstname("Hans"), new Lastname("Wurst"), UserState.ACTIVE));
   }
}

package tk.hildebrandt.ddd.modulith.user.crm.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import tk.hildebrandt.ddd.common.validation.Uuid;
import tk.hildebrandt.ddd.modulith.user.UserService;

@RestController
public class WebHookController {

   private final UserService userService;

   private final UserWebHookConverter converter;

   public WebHookController(UserService userService, UserWebHookConverter converter) {
      this.userService = userService;
      this.converter = converter;
   }

   @PutMapping(path = "/user/crm/webhook/v1/{userId}", produces = APPLICATION_JSON_VALUE, consumes = {APPLICATION_JSON_VALUE})
   public ResponseEntity<?> updateUser(@Uuid @PathVariable("userId") String userId, @RequestBody UserRequestParam userUpdateRequestParam) {
      userService.update(converter.toUpdateCommand(userId, userUpdateRequestParam));

      return ResponseEntity.ok()
                           .build();
   }

   @DeleteMapping(path = "/user/crm/webhook/v1/{userId}")
   public ResponseEntity<?> deleteUser(@Uuid @PathVariable("userId") String userId) {
      userService.delete(converter.toDeleteCommand(userId));

      return ResponseEntity.ok()
                           .build();
   }
}

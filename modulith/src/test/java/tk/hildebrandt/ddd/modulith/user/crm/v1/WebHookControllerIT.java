package tk.hildebrandt.ddd.modulith.user.crm.v1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import tk.hildebrandt.ddd.modulith.configuration.TodoPersistenceConfiguration;
import tk.hildebrandt.ddd.modulith.user.User;
import tk.hildebrandt.ddd.modulith.user.UserTestdataService;

@SpringBootTest
@Import(TodoPersistenceConfiguration.class)
@AutoConfigureMockMvc
class WebHookControllerIT {
   @Autowired
   private MockMvc mockMvc;

   @Autowired
   private UserTestdataService userTestdataService;

   @Test
   void updateUserShouldUpdateState() throws Exception {
      User activeUser = userTestdataService.createValidActiveUser();

      mockMvc.perform(put("/user/crm/webhook/v1/{userId}", activeUser.getUserId().getId().toString())
                         .contentType(MediaType.APPLICATION_JSON)
                         .content("{\"state\": \"DELETED\"}"))
             .andExpect(status().isOk());
   }

}
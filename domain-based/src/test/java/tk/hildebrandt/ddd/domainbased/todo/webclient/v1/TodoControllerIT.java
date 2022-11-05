package tk.hildebrandt.ddd.domainbased.todo.webclient.v1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import tk.hildebrandt.ddd.domainbased.configuration.TodoPersistenceConfiguration;
import tk.hildebrandt.ddd.domainbased.todo.TodoItem;
import tk.hildebrandt.ddd.domainbased.todo.TodoItemId;
import tk.hildebrandt.ddd.domainbased.todo.TodoTestdataService;

@SpringBootTest
@Import(TodoPersistenceConfiguration.class)
@AutoConfigureMockMvc
class TodoControllerIT {
   @Autowired
   private MockMvc mockMvc;

   @Autowired
   private TodoTestdataService todoTestdataService;

   @Test
   void genericRequestShouldReturnListOfAllItems() throws Exception {
      TodoItem openTodoItem = todoTestdataService.createOpenTodoItem();

      mockMvc.perform(get("/todo"))
             .andExpect(content().json("{\"items\":[{\"todoItemId\":\"" + openTodoItem.getTodoItemId()
                                                                                      .getId()
                                                                                      .toString() + "\",\"state\":\"OPEN\",\"description\":\"Test\"}]}"));
   }

   @Test
   void startProcessRequestOnExistingItemShouldReturnItemInStateInProgress() throws Exception {
      TodoItem openTodoItem = todoTestdataService.createOpenTodoItem();

      mockMvc.perform(put("/todo/{todoItemId}/startProcess", openTodoItem.getTodoItemId().getId().toString()))
             .andExpect(content().json("{\"todoItemId\":\"" + openTodoItem.getTodoItemId()
                                                                                      .getId()
                                                                                      .toString() + "\",\"state\":\"IN_PROGRESS\",\"description\":\"Test\"}"));
   }

   @Test
   void startProcessRequestOnNotExistingItemShouldReturnNotFound() throws Exception {
      mockMvc.perform(put("/todo/{todoItemId}/startProcess", new TodoItemId().getId().toString()))
             .andExpect(status().isNotFound());
   }

   @Test
   void finishRequestOnExistingItemShouldReturnItemInStateFinished() throws Exception {
      TodoItem openTodoItem = todoTestdataService.createOpenTodoItem();

      mockMvc.perform(put("/todo/{todoItemId}/finish", openTodoItem.getTodoItemId().getId().toString()))
             .andExpect(content().json("{\"todoItemId\":\"" + openTodoItem.getTodoItemId()
                                                                                      .getId()
                                                                                      .toString() + "\",\"state\":\"FINISHED\",\"description\":\"Test\"}"));
   }

   @Test
   void finishRequestOnNotExistingItemShouldReturnNotFound() throws Exception {
      mockMvc.perform(put("/todo/{todoItemId}/finish", new TodoItemId().getId().toString()))
             .andExpect(status().isNotFound());
   }
}
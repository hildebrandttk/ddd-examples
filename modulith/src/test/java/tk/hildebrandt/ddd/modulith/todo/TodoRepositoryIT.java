package tk.hildebrandt.ddd.modulith.todo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.transaction.support.TransactionTemplate;
import static org.assertj.core.api.Assertions.assertThat;

import tk.hildebrandt.ddd.modulith.configuration.TodoPersistenceConfiguration;

//@SpringBootTest
//@Import(TodoPersistenceConfiguration.class)
@ApplicationModuleTest
class TodoRepositoryIT {

   @Autowired
   private TodoTestdataService todoTestdataService;

   @Autowired
   private TodoRepository todoRepository;

   @Autowired
   private TransactionTemplate transactionTemplate;

   @Test
   void shouldStoreTodoItem() {
      TodoItem savedItem = todoTestdataService.createOpenTodoItem();

      assertThat(savedItem).isNotNull();
   }

   @Test
   void shouldStoreAndLoadItemList() {

      TodoItemId todoItemId = new TodoItemId();

      TodoItem inserted = todoTestdataService.createOpenTodoItem(todoItemId);

      List<TodoItem> loadedItems = transactionTemplate.execute(status -> todoRepository.findAll());
      assertThat(loadedItems).contains(inserted);
   }

   @Test
   void shouldStoreAndLoadTodoItem() {
      TodoItemId todoItemId = new TodoItemId();
      todoTestdataService.createOpenTodoItem(todoItemId);

      Optional<TodoItem> loadedItem = transactionTemplate.execute(status -> todoRepository.findById(todoItemId));
      assertThat(loadedItem).isPresent();
   }
}
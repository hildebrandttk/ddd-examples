package tk.hildebrandt.ddd.onion.infra.jpa;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.support.TransactionTemplate;
import static org.assertj.core.api.Assertions.assertThat;

import tk.hildebrandt.ddd.onion.infra.configuration.TodoPersistenceConfiguration;
import tk.hildebrandt.ddd.onion.core.TodoItem;
import tk.hildebrandt.ddd.onion.core.TodoItemId;
import tk.hildebrandt.ddd.onion.core.TodoItemRepository;
import tk.hildebrandt.ddd.onion.core.TodoTestdataService;

@SpringBootTest
@Import(TodoPersistenceConfiguration.class)
class TodoJpaRepositoryIT {

   @Autowired
   private TodoTestdataService todoTestdataService;

   @Autowired
   private TodoItemRepository todoRepository;

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
package tk.hildebrandt.ddd.hexagonal.adapter.passive.db;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.support.TransactionTemplate;
import static org.assertj.core.api.Assertions.assertThat;

import tk.hildebrandt.ddd.hexagonal.configuration.TodoPersistenceConfiguration;

@SpringBootTest
@Import(TodoPersistenceConfiguration.class)
class TodoJpaRepositoryIT {

   @Autowired
   private TodoTestdataService todoTestdataService;

   @Autowired
   private TodoJpaRepository todoRepository;

   @Autowired
   private TransactionTemplate transactionTemplate;

   @Test
   void shouldStoreTodoItem() {
      TodoItemJpaEntity savedItem = transactionTemplate.execute(status -> todoRepository.save(new TodoItemJpaEntity(UUID.randomUUID(), "test1", "OPEN")));

      assertThat(savedItem).isNotNull();
   }

   @Test
   void shouldStoreAndLoadItemList() {

      UUID todoItemId = UUID.randomUUID();

      todoTestdataService.createOpenTodoItem(todoItemId);

      List<TodoItemJpaEntity> loadedItems = transactionTemplate.execute(status -> todoRepository.findAll());
      assertThat(loadedItems).extracting("todoItemId").contains(todoItemId);
   }

   @Test
   void shouldStoreAndLoadTodoItem() {
      UUID todoItemId = UUID.randomUUID();
      todoTestdataService.createOpenTodoItem(todoItemId);

      Optional<TodoItemJpaEntity> loadedItem = transactionTemplate.execute(status -> todoRepository.findById(todoItemId));
      assertThat(loadedItem).isPresent();
   }
}
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
import tk.hildebrandt.ddd.hexagonal.domain.Description;
import tk.hildebrandt.ddd.hexagonal.domain.State;
import tk.hildebrandt.ddd.hexagonal.domain.TodoItem;
import tk.hildebrandt.ddd.hexagonal.domain.TodoItemId;

@SpringBootTest
@Import(TodoPersistenceConfiguration.class)
class TodoDbRepositoryIT {
   @Autowired
   private TodoTestdataService todoTestdataService;

   @Autowired
   private TodoDbRepository dbRepository;

   @Autowired
   private TransactionTemplate transactionTemplate;

   @Test
   void shouldPersistDomainObject(){
      TodoItem itemToPersist = new TodoItem(new TodoItemId(), new Description("shouldPersistDomainObject"), State.OPEN, dueDate);
      TodoItem persistedItem = transactionTemplate.execute(status -> dbRepository.persist(itemToPersist));
      assertThat(persistedItem).isNotNull();
   }

   @Test
   void shouldFindAll(){
      TodoItem openTodoItem = todoTestdataService.createOpenTodoItem(UUID.randomUUID());
      List<TodoItem> allItems = transactionTemplate.execute(status -> dbRepository.findAll());
      assertThat(allItems).contains(openTodoItem);
   }

   @Test
   void shouldFindById(){
      TodoItem openTodoItem = todoTestdataService.createOpenTodoItem(UUID.randomUUID());
      Optional<TodoItem> optionalTodoItem = transactionTemplate.execute(status -> dbRepository.findById(openTodoItem.getTodoItemId()));
      assertThat(optionalTodoItem).contains(openTodoItem);
   }
}
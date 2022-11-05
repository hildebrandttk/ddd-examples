package tk.hildebrandt.ddd.hexagonal.adapter.passive.db;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import static jakarta.transaction.Transactional.TxType.REQUIRED;

import org.springframework.stereotype.Component;

import tk.hildebrandt.ddd.hexagonal.domain.TodoItem;
import tk.hildebrandt.ddd.hexagonal.domain.TodoItemId;
import tk.hildebrandt.ddd.hexagonal.port.passive.TodoReadPort;
import tk.hildebrandt.ddd.hexagonal.port.passive.TodoWritePort;

@Component
public class TodoDbRepository implements TodoWritePort, TodoReadPort {
   private final TodoJpaRepository jpaRepository;

   private final TodoItemJpaConverter jpaConverter;

   public TodoDbRepository(TodoJpaRepository jpaRepository, TodoItemJpaConverter jpaConverter) {
      this.jpaRepository = jpaRepository;
      this.jpaConverter = jpaConverter;
   }

   @Override
   @Transactional(REQUIRED)
   public List<TodoItem> findAll() {
      return jpaConverter.toDomain(jpaRepository.findAll());
   }

   @Override
   @Transactional(REQUIRED)
   public Optional<TodoItem> findById(TodoItemId todoItemId) {
      return jpaRepository.findById(todoItemId.getId()).map(jpaConverter::toDomain);
   }

   @Override
   @Transactional(REQUIRED)
   public TodoItem persist(TodoItem todoItem) {
      return jpaConverter.toDomain(jpaRepository.save(jpaConverter.toJpaEntity(todoItem)));

   }
}

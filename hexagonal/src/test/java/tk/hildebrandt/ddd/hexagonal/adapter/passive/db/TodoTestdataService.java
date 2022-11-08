package tk.hildebrandt.ddd.hexagonal.adapter.passive.db;

import java.util.UUID;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Component;

import tk.hildebrandt.ddd.hexagonal.domain.Description;
import tk.hildebrandt.ddd.hexagonal.domain.State;
import tk.hildebrandt.ddd.hexagonal.domain.TodoItem;
import tk.hildebrandt.ddd.hexagonal.domain.TodoItemId;

@Component
public class TodoTestdataService {

   private final TodoJpaRepository todoRepository;

   public TodoTestdataService(TodoJpaRepository todoRepository) {
      this.todoRepository = todoRepository;
   }

   @Transactional
   public TodoItem createOpenTodoItem() {
      return createOpenTodoItem(new TodoItemId());
   }

   @Transactional
   public TodoItem createOpenTodoItem(UUID todoItemId) {
      TodoItemJpaEntity jpaEntity = todoRepository.save(new TodoItemJpaEntity(todoItemId, "Test", State.OPEN.name()));
      return new TodoItem(new TodoItemId(jpaEntity.getTodoItemId()), new Description(jpaEntity.getDescription()), State.valueOf(jpaEntity.getState()), dueDate);
   }
   @Transactional
   public TodoItem createOpenTodoItem(TodoItemId todoItemId) {
      TodoItemJpaEntity jpaEntity = todoRepository.save(new TodoItemJpaEntity(todoItemId.getId(), "Test", State.OPEN.name()));
      return new TodoItem(new TodoItemId(jpaEntity.getTodoItemId()), new Description(jpaEntity.getDescription()), State.valueOf(jpaEntity.getState()), dueDate);
   }
}

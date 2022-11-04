package tk.hildebrandt.ddd.hexagonal.adapter.passive.db;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import tk.hildebrandt.ddd.hexagonal.domain.Description;
import tk.hildebrandt.ddd.hexagonal.domain.State;
import tk.hildebrandt.ddd.hexagonal.domain.TodoItem;
import tk.hildebrandt.ddd.hexagonal.domain.TodoItemId;

@Component
public class TodoItemJpaConverter {
   public TodoItemJpaEntity toJpaEntity(TodoItem todoItem) {
      return new TodoItemJpaEntity(todoItem.getTodoItemId().getId(), todoItem.getDescription().getValue(), todoItem.getState().name());
   }

   public TodoItem toDomain(TodoItemJpaEntity todoItemJpaEntity) {
      return new TodoItem(new TodoItemId(todoItemJpaEntity.getTodoItemId()), new Description(todoItemJpaEntity.getDescription()), State.valueOf(todoItemJpaEntity.getState()));
   }

   public List<TodoItem> toDomain(List<TodoItemJpaEntity> list) {
      return list.stream().map(this::toDomain).collect(Collectors.toList());
   }
}

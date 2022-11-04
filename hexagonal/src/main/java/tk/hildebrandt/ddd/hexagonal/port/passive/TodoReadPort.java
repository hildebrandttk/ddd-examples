package tk.hildebrandt.ddd.hexagonal.port.passive;

import java.util.List;
import java.util.Optional;

import tk.hildebrandt.ddd.hexagonal.domain.TodoItem;
import tk.hildebrandt.ddd.hexagonal.domain.TodoItemId;

public interface TodoReadPort {

   List<TodoItem> findAll();

   Optional<TodoItem> findById(TodoItemId todoItemId);
}

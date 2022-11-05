package tk.hildebrandt.ddd.onion.core;

import java.util.List;
import java.util.Optional;

public interface TodoItemRepository {
   List<TodoItem> findAll();

   Optional<TodoItem> findById(TodoItemId todoItemId);
}

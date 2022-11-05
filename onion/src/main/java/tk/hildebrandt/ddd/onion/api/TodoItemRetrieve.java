package tk.hildebrandt.ddd.onion.api;

import java.util.List;

import jakarta.transaction.Transactional;

import tk.hildebrandt.ddd.onion.core.TodoItem;

public interface TodoItemRetrieve {
   @Transactional
   List<TodoItem> list();
}

package tk.hildebrandt.ddd.onion.infra.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import tk.hildebrandt.ddd.onion.core.TodoItem;
import tk.hildebrandt.ddd.onion.core.TodoItemId;
import tk.hildebrandt.ddd.onion.core.TodoItemRepository;

public interface TodoJpaRepository extends JpaRepository<TodoItem, TodoItemId>, TodoItemRepository {

}

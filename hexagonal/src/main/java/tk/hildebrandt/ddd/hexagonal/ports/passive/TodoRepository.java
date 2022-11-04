package tk.hildebrandt.ddd.hexagonal.ports.passive;

import org.springframework.data.jpa.repository.JpaRepository;

import tk.hildebrandt.ddd.hexagonal.domain.TodoItem;
import tk.hildebrandt.ddd.hexagonal.domain.TodoItemId;

public interface TodoRepository extends JpaRepository<TodoItem, TodoItemId> {

}

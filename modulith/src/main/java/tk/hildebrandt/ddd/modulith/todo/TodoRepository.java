package tk.hildebrandt.ddd.modulith.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TodoRepository extends JpaRepository<TodoItem, TodoItemId> {

}

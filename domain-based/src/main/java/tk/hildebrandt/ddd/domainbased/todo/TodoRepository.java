package tk.hildebrandt.ddd.domainbased.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TodoRepository extends JpaRepository<TodoItem, TodoItemId> {

}

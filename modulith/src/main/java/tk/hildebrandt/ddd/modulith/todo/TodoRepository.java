package tk.hildebrandt.ddd.modulith.todo;

import org.springframework.data.jpa.repository.JpaRepository;

interface TodoRepository extends JpaRepository<TodoItem, TodoItemId> {

}

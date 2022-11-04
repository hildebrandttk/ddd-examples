package tk.hildebrandt.ddd.plain.todo;

import org.springframework.data.jpa.repository.JpaRepository;

interface TodoRepository extends JpaRepository<TodoItem, TodoItemId> {

}

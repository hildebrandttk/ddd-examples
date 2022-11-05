package tk.hildebrandt.ddd.domainbased.todo;

import org.springframework.data.jpa.repository.JpaRepository;

interface TodoRepository extends JpaRepository<TodoItem, TodoItemId> {

}

package tk.hildebrandt.ddd.modulith.todo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class TodoService {

   private final TodoRepository todoRepository;

   public TodoService(TodoRepository todoRepository) {
      this.todoRepository = todoRepository;
   }

   @Transactional
   public List<TodoItem> list() {
      return todoRepository.findAll();
   }

   @Transactional
   public Optional<TodoItem> startProcess(StartProcessCommand startProcessCommand) {
      Optional<TodoItem> todoItemMaybe = todoRepository.findById(startProcessCommand.getTodoItemId());
      todoItemMaybe.ifPresent(TodoItem::startProcess);
      return todoItemMaybe;
   }

   @Transactional
   public Optional<TodoItem> finish(FinishCommand finishCommand) {
      Optional<TodoItem> todoItemMaybe = todoRepository.findById(finishCommand.getTodoItemId());
      todoItemMaybe.ifPresent(TodoItem::finish);
      return todoItemMaybe;
   }
}

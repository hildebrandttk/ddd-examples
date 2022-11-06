package tk.hildebrandt.ddd.onion.core;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Component;

import tk.hildebrandt.ddd.onion.api.TodoItemLifeCycle;
import tk.hildebrandt.ddd.onion.api.TodoItemRetrieve;

@Component
public class TodoService implements TodoItemLifeCycle, TodoItemRetrieve {

   private final TodoItemRepository todoItemRepository;

   public TodoService(TodoItemRepository todoItemRepository) {
      this.todoItemRepository = todoItemRepository;
   }

   @Transactional
   public List<TodoItem> list() {
      return todoItemRepository.findAll();
   }

   @Transactional
   public Optional<TodoItem> startProcess(StartProcessCommand startProcessCommand) {
      Optional<TodoItem> todoItemMaybe = todoItemRepository.findById(startProcessCommand.getTodoItemId());
      todoItemMaybe.ifPresent(TodoItem::startProcess);
      return todoItemMaybe;
   }

   @Transactional
   public Optional<TodoItem> finish(FinishCommand finishCommand) {
      Optional<TodoItem> todoItemMaybe = todoItemRepository.findById(finishCommand.getTodoItemId());
      todoItemMaybe.ifPresent(TodoItem::finish);
      return todoItemMaybe;
   }
}

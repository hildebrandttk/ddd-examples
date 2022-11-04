package tk.hildebrandt.ddd.hexagonal.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import tk.hildebrandt.ddd.hexagonal.domain.TodoItem;
import tk.hildebrandt.ddd.hexagonal.ports.passive.TodoRepository;

@Component
public class TodoService {

   private TodoRepository todoRepository;

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

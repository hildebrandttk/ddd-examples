package tk.hildebrandt.ddd.hexagonal.service;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Component;

import tk.hildebrandt.ddd.hexagonal.domain.TodoItem;
import tk.hildebrandt.ddd.hexagonal.domain.TodoItemId;
import tk.hildebrandt.ddd.hexagonal.port.active.TodoItemLifeCyclePort;
import tk.hildebrandt.ddd.hexagonal.port.active.TodoItemRetrievePort;
import tk.hildebrandt.ddd.hexagonal.port.passive.TodoReadPort;
import tk.hildebrandt.ddd.hexagonal.port.passive.TodoWritePort;

@Component
public class TodoService implements TodoItemLifeCyclePort, TodoItemRetrievePort {

   private final TodoReadPort todoReadPort;
   private final TodoWritePort todoWritePort;
   private final TodoItemDtoConverter todoItemDtoConverter;

   public TodoService(TodoReadPort todoReadPort, TodoWritePort todoWritePort, TodoItemDtoConverter todoItemDtoConverter) {
      this.todoReadPort = todoReadPort;
      this.todoWritePort = todoWritePort;
      this.todoItemDtoConverter = todoItemDtoConverter;
   }

   @Override
   @Transactional
   public List<TodoItemDto> list() {
      return todoItemDtoConverter.toDto(todoReadPort.findAll());
   }

   @Override
   @Transactional
   public Optional<TodoItemDto> startProcess(StartProcessCommand startProcessCommand) {
      Optional<TodoItem> todoItemMaybe = todoReadPort.findById(new TodoItemId(startProcessCommand.getTodoItemId()));
      return todoItemMaybe.map(todoItem -> {
         todoItem.startProcess();
         return todoItemDtoConverter.toDto(todoWritePort.persist(todoItem));
      });
   }

   @Override
   @Transactional
   public Optional<TodoItemDto> finish(FinishCommand finishCommand) {
      Optional<TodoItem> todoItemMaybe = todoReadPort.findById(new TodoItemId(finishCommand.getTodoItemId()));
      return todoItemMaybe.map(todoItem -> {
         todoItem.finish();
         return todoItemDtoConverter.toDto(todoWritePort.persist(todoItem));
      });
   }
}

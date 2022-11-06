package tk.hildebrandt.ddd.onion.infra.api.rest;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import tk.hildebrandt.ddd.common.validation.Uuid;
import tk.hildebrandt.ddd.onion.api.TodoItemLifeCycle;
import tk.hildebrandt.ddd.onion.api.TodoItemRetrieve;
import tk.hildebrandt.ddd.onion.core.FinishCommand;
import tk.hildebrandt.ddd.onion.core.StartProcessCommand;
import tk.hildebrandt.ddd.onion.core.TodoItem;
import tk.hildebrandt.ddd.onion.core.TodoService;

@RestController
public class TodoController {

   private final TodoItemRetrieve todoItemRetrieve;
   private final TodoItemLifeCycle todoItemLifeCycle;

   private final ToDoItemV1Converter converter;

   public TodoController(TodoService todoItemRetrieve, TodoItemLifeCycle todoItemLifeCycle, ToDoItemV1Converter converter) {
      this.todoItemRetrieve = todoItemRetrieve;
      this.todoItemLifeCycle = todoItemLifeCycle;
      this.converter = converter;
   }

   @GetMapping(path = "/todo", produces = {APPLICATION_JSON_VALUE})
   public ResponseEntity<TodoItemListResponseDto> list() {
      return ResponseEntity.ok(converter.toListResponse(todoItemRetrieve.list()));
   }

   @PutMapping(path = "/todo/{todoItemId}/startProcess", produces = {APPLICATION_JSON_VALUE})
   public ResponseEntity<TodoItemDto> startProcess(@Uuid @PathVariable("todoItemId") String todoItemId) {
      Optional<TodoItem> todoItemMaybe = todoItemLifeCycle.startProcess(StartProcessCommand.createStartProcessCommand(converter.toId(todoItemId)));

      return todoItemMaybe.map(todoItem -> ResponseEntity.ok(converter.toDto(todoItem)))
                          .orElseGet(() -> ResponseEntity.notFound()
                                                         .build());
   }

   @PutMapping(path = "/todo/{todoItemId}/finish", produces = {APPLICATION_JSON_VALUE})
   public ResponseEntity<TodoItemDto> finish(@Uuid @PathVariable("todoItemId") String todoItemId) {
      Optional<TodoItem> todoItemMaybe = todoItemLifeCycle.finish(FinishCommand.createFinishCommand(converter.toId(todoItemId)));

      return todoItemMaybe.map(todoItem -> ResponseEntity.ok(converter.toDto(todoItem)))
                          .orElseGet(() -> ResponseEntity.notFound()
                                                         .build());
   }
}

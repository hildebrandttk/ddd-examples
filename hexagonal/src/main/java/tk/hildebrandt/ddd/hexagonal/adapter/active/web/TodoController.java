package tk.hildebrandt.ddd.hexagonal.adapter.active.web;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import tk.hildebrandt.ddd.common.validation.Uuid;
import tk.hildebrandt.ddd.hexagonal.port.active.TodoItemLifeCyclePort;
import tk.hildebrandt.ddd.hexagonal.port.active.TodoItemRetrievePort;
import tk.hildebrandt.ddd.hexagonal.service.FinishCommand;
import tk.hildebrandt.ddd.hexagonal.service.StartProcessCommand;
import tk.hildebrandt.ddd.hexagonal.service.TodoItemDto;
import tk.hildebrandt.ddd.hexagonal.service.TodoService;

@RestController
public class TodoController {

   private final TodoItemLifeCyclePort todoItemLifeCyclePort;

   private final TodoItemRetrievePort todoItemRetrievePort;

   private final ToDoItemWebV1Converter converter;

   public TodoController(TodoService todoItemLifeCyclePort, TodoItemRetrievePort todoItemRetrievePort, ToDoItemWebV1Converter converter) {
      this.todoItemLifeCyclePort = todoItemLifeCyclePort;
      this.todoItemRetrievePort = todoItemRetrievePort;
      this.converter = converter;
   }

   @GetMapping(path = "/todo", produces = {APPLICATION_JSON_VALUE})
   public ResponseEntity<TodoItemListResponseWebV1Dto> list() {
      return ResponseEntity.ok(converter.toListResponse(todoItemRetrievePort.list()));
   }

   @PutMapping(path = "/todo/{todoItemId}/startProcess", produces = {APPLICATION_JSON_VALUE})
   public ResponseEntity<TodoItemWebV1Dto> startProcess(@Uuid @PathVariable("todoItemId") String todoItemId) {
      Optional<TodoItemDto> todoItemMaybe = todoItemLifeCyclePort.startProcess(StartProcessCommand.createStartProcessCommand(UUID.fromString(todoItemId)));

      return todoItemMaybe.map(todoItem -> ResponseEntity.ok(converter.toDto(todoItem)))
                          .orElseGet(() -> ResponseEntity.notFound()
                                                         .build());
   }

   @PutMapping(path = "/todo/{todoItemId}/finish", produces = {APPLICATION_JSON_VALUE})
   public ResponseEntity<TodoItemWebV1Dto> finish(@Uuid @PathVariable("todoItemId") String todoItemId) {
      Optional<TodoItemDto> todoItemMaybe = todoItemLifeCyclePort.finish(FinishCommand.createFinishCommand(UUID.fromString(todoItemId)));

      return todoItemMaybe.map(todoItem -> ResponseEntity.ok(converter.toDto(todoItem)))
                          .orElseGet(() -> ResponseEntity.notFound()
                                                         .build());
   }
}

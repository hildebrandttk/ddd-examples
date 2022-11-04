package tk.hildebrandt.ddd.hexagonal.adapter.active.web;

import java.util.Optional;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import tk.hildebrandt.ddd.hexagonal.service.FinishCommand;
import tk.hildebrandt.ddd.hexagonal.service.StartProcessCommand;
import tk.hildebrandt.ddd.hexagonal.service.TodoItemDto;
import tk.hildebrandt.ddd.hexagonal.service.TodoService;
import tk.hildebrandt.ddd.hexagonal.validation.Uuid;

@RestController
public class TodoController {

   private final TodoService todoService;

   private final ToDoItemWebV1Converter converter;

   public TodoController(TodoService todoService, ToDoItemWebV1Converter converter) {
      this.todoService = todoService;
      this.converter = converter;
   }

   @GetMapping(path = "/todo", produces = {APPLICATION_JSON_VALUE})
   public ResponseEntity<TodoItemListResponseWebV1Dto> list() {
      return ResponseEntity.ok(converter.toListResponse(todoService.list()));
   }

   @PutMapping(path = "/todo/{todoItemId}/startProcess", produces = {APPLICATION_JSON_VALUE})
   public ResponseEntity<TodoItemWebV1Dto> startProcess(@Uuid @PathVariable("todoItemId") String todoItemId) {
      Optional<TodoItemDto> todoItemMaybe = todoService.startProcess(StartProcessCommand.createStartProcessCommand(UUID.fromString(todoItemId)));

      return todoItemMaybe.map(todoItem -> ResponseEntity.ok(converter.toDto(todoItem)))
                          .orElseGet(() -> ResponseEntity.notFound()
                                                         .build());
   }

   @PutMapping(path = "/todo/{todoItemId}/finish", produces = {APPLICATION_JSON_VALUE})
   public ResponseEntity<TodoItemWebV1Dto> finish(@Uuid @PathVariable("todoItemId") String todoItemId) {
      Optional<TodoItemDto> todoItemMaybe = todoService.finish(FinishCommand.createFinishCommand(UUID.fromString(todoItemId)));

      return todoItemMaybe.map(todoItem -> ResponseEntity.ok(converter.toDto(todoItem)))
                          .orElseGet(() -> ResponseEntity.notFound()
                                                         .build());
   }
}

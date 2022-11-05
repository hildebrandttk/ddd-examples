package tk.hildebrandt.ddd.domainbased.todo.webclient.v1;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import tk.hildebrandt.ddd.domainbased.todo.FinishCommand;
import tk.hildebrandt.ddd.domainbased.todo.StartProcessCommand;
import tk.hildebrandt.ddd.domainbased.todo.TodoItem;
import tk.hildebrandt.ddd.domainbased.todo.TodoService;
import tk.hildebrandt.ddd.domainbased.validation.Uuid;

@RestController
public class TodoController {

   private final TodoService todoService;

   private final ToDoItemV1Converter converter;

   public TodoController(TodoService todoService, ToDoItemV1Converter converter) {
      this.todoService = todoService;
      this.converter = converter;
   }

   @GetMapping(path = "/todo", produces = {APPLICATION_JSON_VALUE})
   public ResponseEntity<TodoItemListResponseDto> list() {
      return ResponseEntity.ok(converter.toListResponse(todoService.list()));
   }

   @PutMapping(path = "/todo/{todoItemId}/startProcess", produces = {APPLICATION_JSON_VALUE})
   public ResponseEntity<TodoItemDto> startProcess(@Uuid @PathVariable("todoItemId") String todoItemId) {
      Optional<TodoItem> todoItemMaybe = todoService.startProcess(StartProcessCommand.createStartProcessCommand(converter.toId(todoItemId)));

      return todoItemMaybe.map(todoItem -> ResponseEntity.ok(converter.toDto(todoItem)))
                          .orElseGet(() -> ResponseEntity.notFound()
                                                         .build());
   }

   @PutMapping(path = "/todo/{todoItemId}/finish", produces = {APPLICATION_JSON_VALUE})
   public ResponseEntity<TodoItemDto> finish(@Uuid @PathVariable("todoItemId") String todoItemId) {
      Optional<TodoItem> todoItemMaybe = todoService.finish(FinishCommand.createFinishCommand(converter.toId(todoItemId)));

      return todoItemMaybe.map(todoItem -> ResponseEntity.ok(converter.toDto(todoItem)))
                          .orElseGet(() -> ResponseEntity.notFound()
                                                         .build());
   }
}

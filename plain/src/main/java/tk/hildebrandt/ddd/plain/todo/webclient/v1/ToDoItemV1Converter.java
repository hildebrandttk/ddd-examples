package tk.hildebrandt.ddd.plain.todo.webclient.v1;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import tk.hildebrandt.ddd.plain.todo.Description;
import tk.hildebrandt.ddd.plain.todo.State;
import tk.hildebrandt.ddd.plain.todo.TodoItem;
import tk.hildebrandt.ddd.plain.todo.TodoItemId;

@Component
public class ToDoItemV1Converter {

   TodoItemListResponseDto toListResponse(List<TodoItem> domainItems) {
      return new TodoItemListResponseDto(
         domainItems.stream()
                    .map(this::toDto)
                    .collect(Collectors.toList()));
   }

   public TodoItemDto toDto(TodoItem todoItem) {
      return new TodoItemDto(toDto(todoItem.getTodoItemId()),
                             toDto(todoItem.getState()),
                             toDto(todoItem.getDescription()));
   }

   String toDto(State state) {
      if(state == null){
         return null;
      }
      return state.name();
   }

   String toDto(TodoItemId todoItemId) {
      if(todoItemId == null || todoItemId.getId() == null){
         return null;
      }
      return todoItemId.getId()
                       .toString();
   }

   String toDto(Description description) {
      if (description == null) {
         return null;
      }
      return description.getValue();
   }

   TodoItemId toId(String todoItemId) {
      if (todoItemId == null) {
         return null;
      }
      return new TodoItemId(UUID.fromString(todoItemId));
   }
}

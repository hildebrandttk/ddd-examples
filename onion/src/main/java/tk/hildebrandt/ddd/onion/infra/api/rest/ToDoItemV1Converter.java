package tk.hildebrandt.ddd.onion.infra.api.rest;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import tk.hildebrandt.ddd.onion.core.Description;
import tk.hildebrandt.ddd.onion.core.State;
import tk.hildebrandt.ddd.onion.core.TodoItem;
import tk.hildebrandt.ddd.onion.core.TodoItemId;

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
      return description.value();
   }

   TodoItemId toId(String todoItemId) {
      if (todoItemId == null) {
         return null;
      }
      return new TodoItemId(UUID.fromString(todoItemId));
   }
}

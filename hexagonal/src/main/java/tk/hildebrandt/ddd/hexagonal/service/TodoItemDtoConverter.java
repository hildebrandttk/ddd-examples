package tk.hildebrandt.ddd.hexagonal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import tk.hildebrandt.ddd.hexagonal.domain.Description;
import tk.hildebrandt.ddd.hexagonal.domain.State;
import tk.hildebrandt.ddd.hexagonal.domain.TodoItem;
import tk.hildebrandt.ddd.hexagonal.domain.TodoItemId;

@Component
public class TodoItemDtoConverter {
   public List<TodoItemDto> toDto(List<TodoItem> todoItems) {
      return todoItems.stream().map(this::toDto).collect(Collectors.toList());
   }

   public TodoItemDto toDto(TodoItem todoItem) {
      return new TodoItemDto(toDto(todoItem.getTodoItemId()), toDto(todoItem.getDescription()), toDto(todoItem.getState()));
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

}

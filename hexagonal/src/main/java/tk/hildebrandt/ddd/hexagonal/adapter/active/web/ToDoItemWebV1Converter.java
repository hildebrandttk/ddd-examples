package tk.hildebrandt.ddd.hexagonal.adapter.active.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import tk.hildebrandt.ddd.hexagonal.service.TodoItemDto;

@Component
public class ToDoItemWebV1Converter {

   TodoItemListResponseWebV1Dto toListResponse(List<TodoItemDto> domainItems) {
      return new TodoItemListResponseWebV1Dto(
         domainItems.stream()
                    .map(this::toDto)
                    .collect(Collectors.toList()));
   }

   public TodoItemWebV1Dto toDto(TodoItemDto todoItem) {
      return new TodoItemWebV1Dto(todoItem.getTodoItemId(),
                                  todoItem.getDescription(), todoItem.getState()
      );
   }
}

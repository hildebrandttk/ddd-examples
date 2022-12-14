package tk.hildebrandt.ddd.modulith.todo.webclient.v1;

import java.util.List;
import java.util.Objects;

public class TodoItemListResponseDto {

   private final List<TodoItemDto> items;

   TodoItemListResponseDto(List<TodoItemDto> items) {
      this.items = items;
   }

   public List<TodoItemDto> getItems() {
      return items;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) {
         return true;
      }
      if (o == null || getClass() != o.getClass()) {
         return false;
      }
      TodoItemListResponseDto that = (TodoItemListResponseDto) o;
      return Objects.equals(items, that.items);
   }

   @Override
   public int hashCode() {
      return Objects.hash(items);
   }

   @Override
   public String toString() {
      return "TodoItemListResponseDto{" +
         "items=" + items +
         '}';
   }
}

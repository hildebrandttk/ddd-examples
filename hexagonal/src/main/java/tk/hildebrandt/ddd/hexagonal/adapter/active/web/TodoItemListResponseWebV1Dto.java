package tk.hildebrandt.ddd.hexagonal.adapter.active.web;

import java.util.List;
import java.util.Objects;

public class TodoItemListResponseWebV1Dto {

   private final List<TodoItemWebV1Dto> items;

   TodoItemListResponseWebV1Dto(List<TodoItemWebV1Dto> items) {
      this.items = items;
   }

   public List<TodoItemWebV1Dto> getItems() {
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
      TodoItemListResponseWebV1Dto that = (TodoItemListResponseWebV1Dto) o;
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

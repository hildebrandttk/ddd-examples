package tk.hildebrandt.ddd.hexagonal.service;

import java.util.UUID;
import static java.util.Arrays.asList;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import tk.hildebrandt.ddd.hexagonal.domain.Description;
import tk.hildebrandt.ddd.hexagonal.domain.State;
import tk.hildebrandt.ddd.hexagonal.domain.TodoItem;
import tk.hildebrandt.ddd.hexagonal.domain.TodoItemId;

class ToDoItemV1ConverterTest {

   private final TodoItemDtoConverter converter = new TodoItemDtoConverter();

   @Test
   void shouldConvertEmptyDescriptionToNullString() {
      Assertions.assertThat(converter.toDto(new Description(null))).isNull();
   }

   @Test
   void shouldConvertNullDescriptionToNullString() {
      Assertions.assertThat(converter.toDto((Description) null)).isNull();
   }

   @Test
   void shouldConvertValidTodoItemIdToString() {
      Assertions.assertThat(converter.toDto(new TodoItemId("e210c0bb-4c68-4cf9-8aa3-3b40aa499db4"))).isEqualTo("e210c0bb-4c68-4cf9-8aa3-3b40aa499db4");
   }

   @Test
   void shouldConvertEmptyTodoItemIdToNullString() {
      Assertions.assertThat(converter.toDto(new TodoItemId((UUID) null))).isNull();
   }

   @Test
   void shouldConvertNullTodoItemIdToNullString() {
      Assertions.assertThat(converter.toDto((TodoItemId) null)).isNull();
   }

   @Test
   void shouldConvertStateToUppercaseString() {
      Assertions.assertThat(converter.toDto(State.FINISHED)).isEqualTo("FINISHED");
   }

   @Test
   void shouldConvertNullStateToNullString() {
      Assertions.assertThat(converter.toDto((State) null)).isNull();
   }

   @Test
   void shouldConvertTodoItemToTodoItemDto() {
      assertThat(converter.toDto(new TodoItem(new TodoItemId(UUID.fromString("e210c0bb-4c68-4cf9-8aa3-3b40aa499db4")), new Description("test123"), State.OPEN)))
         .isEqualTo(new TodoItemDto("e210c0bb-4c68-4cf9-8aa3-3b40aa499db4", "test123", "OPEN"));
   }

   @Test
   void shouldConvertTodoItemListToTodoItemLisResponseDto() {
      assertThat(converter.toDto(asList(new TodoItem(new TodoItemId(UUID.fromString("e210c0bb-4c68-4cf9-8aa3-3b40aa499db4")), new Description("test123"), State.OPEN),
                                                 new TodoItem(new TodoItemId(UUID.fromString("e210c0bb-4c68-4cf9-8aa3-3b40aa499db5")), new Description("test1234"), State.FINISHED))))
         .isEqualTo(asList(new TodoItemDto("e210c0bb-4c68-4cf9-8aa3-3b40aa499db4", "test123", "OPEN"),
                           new TodoItemDto("e210c0bb-4c68-4cf9-8aa3-3b40aa499db5", "test1234", "FINISHED")));
   }
}
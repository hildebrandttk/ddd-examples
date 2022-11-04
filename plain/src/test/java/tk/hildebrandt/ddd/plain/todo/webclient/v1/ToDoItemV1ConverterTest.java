package tk.hildebrandt.ddd.plain.todo.webclient.v1;

import java.util.UUID;

import static java.util.Arrays.asList;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import tk.hildebrandt.ddd.plain.todo.Description;
import tk.hildebrandt.ddd.plain.todo.State;
import tk.hildebrandt.ddd.plain.todo.TodoItem;
import tk.hildebrandt.ddd.plain.todo.TodoItemId;

class ToDoItemV1ConverterTest {

   private final ToDoItemV1Converter converter = new ToDoItemV1Converter();

   @Test
   void shouldConvertValidUuidStringToTodoItemId() {
      assertThat(converter.toId("e210c0bb-4c68-4cf9-8aa3-3b40aa499db4")).isEqualTo(new TodoItemId(UUID.fromString("e210c0bb-4c68-4cf9-8aa3-3b40aa499db4")));
   }

   @Test
   void shouldConvertNullStringToNullTodoItemId() {
      assertThat(converter.toId(null)).isNull();
   }

   @Test
   void shouldConvertEmptyDescriptionToNullString() {
      assertThat(converter.toDto(new Description(null))).isNull();
   }

   @Test
   void shouldConvertNullDescriptionToNullString() {
      assertThat(converter.toDto((Description) null)).isNull();
   }

   @Test
   void shouldConvertValidTodoItemIdToString() {
      assertThat(converter.toDto(new TodoItemId(UUID.fromString("e210c0bb-4c68-4cf9-8aa3-3b40aa499db4")))).isEqualTo("e210c0bb-4c68-4cf9-8aa3-3b40aa499db4");
   }

   @Test
   void shouldConvertEmptyTodoItemIdToNullString() {
      assertThat(converter.toDto(new TodoItemId(null))).isNull();
   }

   @Test
   void shouldConvertNullTodoItemIdToNullString() {
      assertThat(converter.toDto((TodoItemId) null)).isNull();
   }

   @Test
   void shouldConvertStateToUppercaseString() {
      assertThat(converter.toDto(State.FINISHED)).isEqualTo("FINISHED");
   }

   @Test
   void shouldConvertNullStateToNullString() {
      assertThat(converter.toDto((State) null)).isNull();
   }

   @Test
   void shouldConvertTodoItemToTodoItemDto() {
      assertThat(converter.toDto(new TodoItem(new TodoItemId(UUID.fromString("e210c0bb-4c68-4cf9-8aa3-3b40aa499db4")), new Description("test123"), State.OPEN)))
         .isEqualTo(new TodoItemDto("e210c0bb-4c68-4cf9-8aa3-3b40aa499db4", "OPEN", "test123"));
   }

   @Test
   void shouldConvertTodoItemListToTodoItemLisResponseDto() {
      assertThat(converter.toListResponse(asList(new TodoItem(new TodoItemId(UUID.fromString("e210c0bb-4c68-4cf9-8aa3-3b40aa499db4")), new Description("test123"), State.OPEN),
                                                 new TodoItem(new TodoItemId(UUID.fromString("e210c0bb-4c68-4cf9-8aa3-3b40aa499db5")), new Description("test1234"), State.FINISHED))))
         .isEqualTo(new TodoItemListResponseDto(asList(new TodoItemDto("e210c0bb-4c68-4cf9-8aa3-3b40aa499db4", "OPEN", "test123"),
                                                       new TodoItemDto("e210c0bb-4c68-4cf9-8aa3-3b40aa499db5", "FINISHED", "test1234"))));
   }
}
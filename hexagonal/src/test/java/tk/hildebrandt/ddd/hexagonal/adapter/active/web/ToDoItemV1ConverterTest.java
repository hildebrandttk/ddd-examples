package tk.hildebrandt.ddd.hexagonal.adapter.active.web;

import static java.util.Arrays.asList;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import tk.hildebrandt.ddd.hexagonal.domain.State;
import tk.hildebrandt.ddd.hexagonal.domain.TodoItemId;
import tk.hildebrandt.ddd.hexagonal.service.TodoItemDto;

class ToDoItemV1ConverterTest {

   private final ToDoItemWebV1Converter converter = new ToDoItemWebV1Converter();

   @Test
   void shouldConvertTodoItemToTodoItemDto() {
      Assertions.assertThat(converter.toDto(new TodoItemDto("e210c0bb-4c68-4cf9-8aa3-3b40aa499db4", "test123", State.OPEN.name())))
                .isEqualTo(new TodoItemWebV1Dto("e210c0bb-4c68-4cf9-8aa3-3b40aa499db4", "test123", "OPEN"));
   }

   @Test
   void shouldConvertTodoItemListToTodoItemLisResponseDto() {
      assertThat(converter.toListResponse(asList(new TodoItemDto("e210c0bb-4c68-4cf9-8aa3-3b40aa499db4", "test123", State.OPEN.name()),
                                                 new TodoItemDto("e210c0bb-4c68-4cf9-8aa3-3b40aa499db5", "test1234", State.FINISHED.name()))))
         .isEqualTo(new TodoItemListResponseWebV1Dto(asList(new TodoItemWebV1Dto("e210c0bb-4c68-4cf9-8aa3-3b40aa499db4", "test123", "OPEN"),
                                                            new TodoItemWebV1Dto("e210c0bb-4c68-4cf9-8aa3-3b40aa499db5", "test1234", "FINISHED"))));
   }
}
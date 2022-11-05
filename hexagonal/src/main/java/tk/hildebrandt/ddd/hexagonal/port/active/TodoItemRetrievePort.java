package tk.hildebrandt.ddd.hexagonal.port.active;

import java.util.List;

import jakarta.transaction.Transactional;

import tk.hildebrandt.ddd.hexagonal.service.TodoItemDto;

public interface TodoItemRetrievePort {
   @Transactional
   List<TodoItemDto> list();
}

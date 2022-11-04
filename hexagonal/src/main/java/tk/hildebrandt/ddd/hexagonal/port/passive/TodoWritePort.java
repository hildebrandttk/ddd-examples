package tk.hildebrandt.ddd.hexagonal.port.passive;

import tk.hildebrandt.ddd.hexagonal.domain.TodoItem;

public interface TodoWritePort {

   TodoItem persist(TodoItem todoItem);
}

package tk.hildebrandt.ddd.hexagonal.port.active;

import java.util.Optional;

import javax.transaction.Transactional;

import tk.hildebrandt.ddd.hexagonal.domain.TodoItem;
import tk.hildebrandt.ddd.hexagonal.service.FinishCommand;
import tk.hildebrandt.ddd.hexagonal.service.StartProcessCommand;
import tk.hildebrandt.ddd.hexagonal.service.TodoItemDto;

public interface TodoItemLifeCyclePort {
   @Transactional
   Optional<TodoItemDto> startProcess(StartProcessCommand startProcessCommand);

   @Transactional
   Optional<TodoItemDto> finish(FinishCommand finishCommand);
}

package tk.hildebrandt.ddd.onion.api;

import java.util.Optional;

import jakarta.transaction.Transactional;
import tk.hildebrandt.ddd.onion.core.FinishCommand;
import tk.hildebrandt.ddd.onion.core.StartProcessCommand;
import tk.hildebrandt.ddd.onion.core.TodoItem;

public interface TodoItemLifeCycle {
   @Transactional
   Optional<TodoItem> startProcess(StartProcessCommand startProcessCommand);

   @Transactional
   Optional<TodoItem> finish(FinishCommand finishCommand);
}

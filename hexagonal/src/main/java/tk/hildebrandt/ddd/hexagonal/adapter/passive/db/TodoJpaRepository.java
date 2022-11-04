package tk.hildebrandt.ddd.hexagonal.adapter.passive.db;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoJpaRepository extends JpaRepository<TodoItemJpaEntity, UUID> {

}

package be.ucll.todolist.model.Repository;

import be.ucll.todolist.model.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}

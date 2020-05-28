package be.ucll.todolist.model.Repository;

import be.ucll.todolist.model.domain.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubTaskRepository extends JpaRepository<SubTask,Integer> {
}

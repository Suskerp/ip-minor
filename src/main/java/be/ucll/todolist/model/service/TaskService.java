package be.ucll.todolist.model.service;

import be.ucll.todolist.model.DTO.SubTaskDTO;
import be.ucll.todolist.model.DTO.TaskDTO;
import be.ucll.todolist.model.domain.SubTask;

import java.util.List;

public interface TaskService {
    List<TaskDTO> getTasks();
    void addTask(TaskDTO task);
    TaskDTO getWithId(int id);
    boolean updateTask(TaskDTO task);
    void addSubTask(SubTaskDTO subTask, int id);
    boolean deleteTask(int id);
    boolean exists(int id);

}

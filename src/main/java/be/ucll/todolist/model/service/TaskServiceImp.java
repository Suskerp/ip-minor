package be.ucll.todolist.model.service;

import be.ucll.todolist.model.DTO.SubTaskDTO;
import be.ucll.todolist.model.DTO.SubTaskDTOMapper;
import be.ucll.todolist.model.DTO.TaskDTO;
import be.ucll.todolist.model.DTO.TaskDTOMapper;
import be.ucll.todolist.model.Repository.TaskRepository;
import be.ucll.todolist.model.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImp implements TaskService {
    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImp(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<TaskDTO> getTasks(){
        return taskRepository.findAll().stream().map(TaskDTOMapper::taskTODTO).collect(Collectors.toList());
    }

    @Override
    public void addTask(TaskDTO taskDTO) {
        taskRepository.save(TaskDTOMapper.dTOtoTask(taskDTO));
    }

    @Override
    public TaskDTO getWithId(int id) {
        return TaskDTOMapper.taskTODTO(taskRepository.getOne(id));
    }

    @Override
    public boolean updateTask(TaskDTO taskDTO) {


        if (taskRepository.existsById(taskDTO.getTaskID())) {
            taskRepository.save(TaskDTOMapper.dTOtoTask(taskDTO));
            return true;
        }
        return false;
    }

    @Override
    public void addSubTask(SubTaskDTO subTaskDTO, int id) {
        Task task =taskRepository.getOne(id);
        subTaskDTO.setTask(task);
        task.addSubTask(SubTaskDTOMapper.DTOtoSubtask(subTaskDTO));
        taskRepository.save(task);
    }

    @Override
    public boolean deleteTask(int id) {

        if (taskRepository.existsById(id)){
            taskRepository.delete(taskRepository.getOne(id));
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean exists(int id) {
        return taskRepository.existsById(id);
    }
}

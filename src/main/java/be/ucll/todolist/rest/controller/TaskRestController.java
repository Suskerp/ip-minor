package be.ucll.todolist.rest.controller;

import be.ucll.todolist.model.DTO.TaskDTO;
import be.ucll.todolist.model.service.TaskService;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskRestController {

    private final TaskService taskService;

    public TaskRestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<TaskDTO> getTasks(){
        return taskService.getTasks();
    }

    @PostMapping
    public String  addTask(@RequestBody @Valid TaskDTO taskDTO){
        taskService.addTask(taskDTO);

        if (taskDTO.getTaskID() != 0){
            return "Adding a task with ID is pointless, nevertheless task was added succesfully but not with your given ID";
        }else {
            return "Task added succesfully";
        }
    }

    @PutMapping
    public String updateTask(@RequestBody @Valid TaskDTO taskDTO){
        if (taskService.updateTask(taskDTO)){
            return "Task update succesfully";
        }else {
            return "No task was updated, perhaps try another id or give up";
        }
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable String id) {

        if (taskService.deleteTask(Integer.parseInt(id))){
            return "Task deleted succesfully";
        }else {
            return "No task was deleted, perhaps try another id or give up.";
        }
    }

}

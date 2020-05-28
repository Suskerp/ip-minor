package be.ucll.todolist.controller;


import be.ucll.todolist.model.DTO.SubTaskDTO;
import be.ucll.todolist.model.DTO.TaskDTO;
import be.ucll.todolist.model.domain.Task;
import be.ucll.todolist.model.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @GetMapping
    public String showTasks(Model model){
        model.addAttribute("tasks",taskService.getTasks());
        return "tasksOverview";
    }

    @GetMapping("/{id}")
    public String showTaskWithID(Model model, @PathVariable("id") Integer id){
        if (!taskService.exists(id)){
            return "redirect:/";
        }

        model.addAttribute("task",taskService.getWithId(id));
        return "taskDetail";
    }

    @GetMapping("/new")
    public String getNewTaskPage(Model model                                                                                 ){
        model.addAttribute("taskDTO",new Task());
        return "createTask";
    }


    @PostMapping("/new")
    public String addNewTask(@ModelAttribute @Valid TaskDTO taskDTO, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "createTask";
        }
            taskService.addTask(taskDTO);
            return "redirect:/task";
    }

    @GetMapping("/edit/{id}")
    public String editTask(Model model, @PathVariable("id") int id){
        if (!taskService.exists(id)){
            return "redirect:/";
        }
        model.addAttribute("taskDTO",taskService.getWithId(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String updateTask(@ModelAttribute @Valid TaskDTO taskDTO,BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            return "edit";
        }
        taskService.updateTask(taskDTO);
        return "redirect:/task";
    }

    @GetMapping("/{id}/sub/create")
    public String addsubTaskkPage(Model model,@PathVariable("id") int id){
        if (!taskService.exists(id)){
            return "redirect:/";
        }
        model.addAttribute("task",taskService.getWithId(id));
        model.addAttribute("subTaskDTO",new SubTaskDTO());
        return "addSubtask";
    }

    @PostMapping("/sub/create")
    public String createSubTask(@ModelAttribute @Valid SubTaskDTO subTaskDTO,BindingResult bindingResult, Model model,@RequestParam("id") int id){
        if (bindingResult.hasErrors()){
            model.addAttribute("task",taskService.getWithId(id));
            return "addSubtask";
        }
        taskService.addSubTask(subTaskDTO,id);
        return "redirect:/task/" + id;
    }
}

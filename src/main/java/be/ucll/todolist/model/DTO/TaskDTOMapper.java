package be.ucll.todolist.model.DTO;

import be.ucll.todolist.model.domain.Task;

public class TaskDTOMapper {
    public static TaskDTO taskTODTO(Task task){
        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setDescription(task.getDescription());
        taskDTO.setDueDate(task.getDueDate());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setSubTasks(SubTaskDTOMapper.listSubtasksToDTO(task.getSubTasks()));
        taskDTO.setTaskID(task.getTaskID());

        return taskDTO;
    }


    public static Task dTOtoTask(TaskDTO taskDTO){
        Task task = new Task();

        task.setDescription(taskDTO.getDescription());
        task.setDueDate(taskDTO.getDueDate());
        task.setTitle(taskDTO.getTitle());
        task.setSubTasks(SubTaskDTOMapper.listDTOToSubtasks(taskDTO.getSubTasks()));
        task.setTaskID(taskDTO.getTaskID());

        return task;
    }

}

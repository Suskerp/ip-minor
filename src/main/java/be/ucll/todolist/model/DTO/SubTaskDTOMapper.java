package be.ucll.todolist.model.DTO;

import be.ucll.todolist.model.domain.SubTask;

import java.util.ArrayList;
import java.util.List;

public class SubTaskDTOMapper {
    public static SubTaskDTO subTaskToDTO(SubTask subtask){
        SubTaskDTO subTaskDTO = new SubTaskDTO();

        subTaskDTO.setTitle(subtask.getTitle());
        subTaskDTO.setSubTaskID(subtask.getSubTaskID());
        subTaskDTO.setDescription(subtask.getDescription());
        subTaskDTO.setTask(subtask.getTask());

        return subTaskDTO;
    }

    public static SubTask DTOtoSubtask(SubTaskDTO subTaskDTO){
        SubTask subTask = new SubTask();

        subTask.setTitle(subTaskDTO.getTitle());
        subTask.setSubTaskID(subTaskDTO.getSubTaskID());
        subTask.setDescription(subTaskDTO.getDescription());
        subTask.setTask(subTaskDTO.getTask());

        return subTask;
    }

    public static List<SubTaskDTO> listSubtasksToDTO(List<SubTask> subTasks){
        List<SubTaskDTO> subTaskDTOS = new ArrayList<>();

        for (SubTask subTask:subTasks) {
            subTaskDTOS.add(subTaskToDTO(subTask));
        }

        return subTaskDTOS;
    }

    public static List<SubTask> listDTOToSubtasks(List<SubTaskDTO> subTaskDTOS){
        List<SubTask> subTasks = new ArrayList<>();

        for (SubTaskDTO subTaskDTO:subTaskDTOS) {
            subTasks.add(DTOtoSubtask(subTaskDTO));
        }

        return subTasks;
    }
}

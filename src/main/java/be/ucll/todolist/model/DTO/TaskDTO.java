package be.ucll.todolist.model.DTO;

import be.ucll.todolist.model.domain.SubTask;

import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskDTO {
    @NotEmpty(message ="{title.notempty}")
    private String title;

    @NotNull(message ="{duedate.notnull}")
    @Future(message ="{duedate.future}")
    @Column(name = "duedate")
    private LocalDateTime dueDate;
    private String description;

    private int taskID;

    private List<SubTaskDTO> subTasks = new ArrayList<>();

    public TaskDTO(String title, LocalDateTime dueDate, String description, int taskID) {
        this.title = title;
        this.dueDate = dueDate;
        this.description = description;
        this.taskID = taskID;
    }

    public TaskDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getFormattedDueDate() {
        return dueDate.getMonth().name().toLowerCase() + " " + dueDate.getDayOfMonth() + " " + dueDate.getYear()  + " " + dueDate.getHour() + " hour";
    }

    public String getDescription() {
        return (description != null ? description : "");
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public void addSubTask(SubTaskDTO subTask){
        subTasks.add(subTask);
    }

    public List<SubTaskDTO> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTaskDTO> subTasks) {
        this.subTasks = subTasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDTO taskDTO = (TaskDTO) o;
        return taskID == taskDTO.taskID;
    }

}

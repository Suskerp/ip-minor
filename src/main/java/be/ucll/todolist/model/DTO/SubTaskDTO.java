package be.ucll.todolist.model.DTO;

import be.ucll.todolist.model.domain.Task;

import javax.validation.constraints.NotEmpty;


public class SubTaskDTO {

    private int subTaskID;

    @NotEmpty(message = "{title.notempty}")
    private String title;

    private String description;

    private Task task;


    public SubTaskDTO(String title, String description,Task task,int subTaskID) {
        this.title = title;
        this.description = description;
        this.task = task;
        this.subTaskID = subTaskID;
    }
    public SubTaskDTO(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return (description !=null ? description:"");
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getSubTaskID() {
        return subTaskID;
    }

    public void setSubTaskID(int subTaskID) {
        this.subTaskID = subTaskID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubTaskDTO that = (SubTaskDTO) o;
        return subTaskID == that.subTaskID;
    }
}

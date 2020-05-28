package be.ucll.todolist.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "subtasks")
@JsonIgnoreProperties(value = { "task" })
public class SubTask {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int subTaskID;

    @NotEmpty(message = "{title.notempty}")
    private String title;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "parentid", nullable = false)
    private Task task;


    public SubTask(String title, String description,Task task,int subTaskID) {
        this.title = title;
        this.description = description;
        this.task = task;
        this.subTaskID = subTaskID;
    }
    public SubTask(){}

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
        SubTask subTask = (SubTask) o;
        return subTaskID == subTask.subTaskID;
    }

}

package be.ucll.todolist.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "TASKS")
@JsonIgnoreProperties(value = { "task","formattedDueDate" })
public class Task {
    @NotEmpty(message ="{title.notempty}")
    private String title;

    @NotNull(message ="{duedate.notnull}")
    @Future(message ="{duedate.future}")
    @Column(name = "duedate")
    private LocalDateTime dueDate;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int taskID;

    private String description;

    @OneToMany(mappedBy = "task", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<SubTask> subTasks;

    public Task(String title, LocalDateTime dueDate, String description, List<SubTask> subTasks) {
        this.title = title;
        this.dueDate = dueDate;
        this.description = description;
        this.subTasks = subTasks;
    }

    public Task(){
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

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getFormattedDueDate() {
        return dueDate.getMonth().name().toLowerCase() + " " + dueDate.getDayOfMonth() + " " + dueDate.getYear()  + " " + dueDate.getHour() + " hour";
    }

    public String getDescription() {
        return (description !=null ? description:"");
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return taskID == task.taskID;
    }

    public int getTaskID() {
        return taskID;
    }

   public List<SubTask> getSubTasks() {
        return subTasks;
    }

    public void addSubTask(SubTask subTask){
        subTasks.add(subTask);
    }

    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }
}

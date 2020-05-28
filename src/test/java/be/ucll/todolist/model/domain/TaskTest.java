package be.ucll.todolist.model.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaskTest {
    LocalDateTime localDateTime1 = LocalDateTime.of(2000,2,23,23,34);

    Task task = new Task("Task1",localDateTime1,"Dit is task 1",new ArrayList<>());

    @BeforeAll
    void setup(){
        task.setTaskID(1);
    }
    @Test
    void getDescriptionTest(){
        Task task2 = new Task();

        assertEquals(task.getDescription(),"Dit is task 1");
        assertEquals(task2.getDescription(),"");
    }

    @Test
    void equalsTest(){
        Task task2 = new Task();
        task2.setTaskID(1);
        assertEquals(task2,task);
    }

    @Test
    void formattedDueDateTest(){
        assertEquals("february 23 2000 23 hour",task.getFormattedDueDate());
    }

    @Test
    void addSubTasksTest(){
        SubTask subTask = new SubTask();
        subTask.setSubTaskID(1);
        List<SubTask> subTasks = task.getSubTasks();

        assertNotNull(subTask);
        assertTrue(subTasks.isEmpty());

        task.addSubTask(subTask);

        subTasks = task.getSubTasks();

        assertFalse(subTasks.isEmpty());
        assertEquals(1, subTasks.size());
        SubTask subTask1 = subTasks.get(0);
        assertEquals(subTask,subTask1);
    }
}

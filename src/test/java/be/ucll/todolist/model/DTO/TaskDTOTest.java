package be.ucll.todolist.model.DTO;

import be.ucll.todolist.model.domain.SubTask;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaskDTOTest {
    LocalDateTime localDateTime1 = LocalDateTime.of(2000, 2, 23, 23, 34);

    TaskDTO task = new TaskDTO("Task1", localDateTime1, "Dit is task 1",1);

    @BeforeAll
    void setup() {
        task.setSubTasks(new ArrayList<>());
    }


    @Test
    void getDescriptionTest() {
        TaskDTO task2 = new TaskDTO();

        assertEquals(task.getDescription(), "Dit is task 1");
        assertEquals(task2.getDescription(), "");
    }

    @Test
    void equalsTest() {
        TaskDTO task2 = new TaskDTO();
        task2.setTaskID(1);
        assertEquals(task2, task);
    }

    @Test
    void formattedDueDateTest() {
        assertEquals("february 23 2000 23 hour", task.getFormattedDueDate());
    }

    @Test
    void addSubTasksTest() {
        SubTaskDTO subTask = new SubTaskDTO();
        subTask.setSubTaskID(1);
        List<SubTaskDTO> subTasks = task.getSubTasks();

        assertNotNull(subTask);
        assertTrue(subTasks.isEmpty());

        task.addSubTask(subTask);

        subTasks = task.getSubTasks();

        assertFalse(subTasks.isEmpty());
        assertEquals(1, subTasks.size());
        SubTaskDTO subTask1 = subTasks.get(0);
        assertEquals(subTask, subTask1);
    }
}
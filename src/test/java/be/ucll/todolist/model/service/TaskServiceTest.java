package be.ucll.todolist.model.service;

import be.ucll.todolist.model.DTO.SubTaskDTO;
import be.ucll.todolist.model.DTO.TaskDTO;
import be.ucll.todolist.model.domain.SubTask;
import be.ucll.todolist.model.domain.Task;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @BeforeAll
    void setup(){
        LocalDateTime localDateTime1 = LocalDateTime.of(2025, 2, 23, 23, 34);
        TaskDTO task = new TaskDTO("Task1", localDateTime1, "Dit is task 1",1);

        TaskDTO task2 = new TaskDTO("Task1", localDateTime1, "Dit is task 1",3);

        taskService.addTask(task);
        taskService.addTask(task2);
    }
    @Test
    void testGetTasks(){
        List<TaskDTO> taskDTOS = taskService.getTasks();

        assertNotNull(taskDTOS);
        assertFalse(taskDTOS.isEmpty());
        assertTrue(taskDTOS.size()>=2);
        TaskDTO task = taskDTOS.get(taskDTOS.size()-1);
        assertNotNull(task);
    }

    @Test
    void testAddTask(){
        String titel = "dummyaddTest";
        String description = "dummydescription";
        LocalDateTime localDateTime1 = LocalDateTime.of(2025, 2, 23, 23, 34);
        TaskDTO dummyDto = new TaskDTO();
        dummyDto.setTitle(titel);
        dummyDto.setDescription(description);
        dummyDto.setDueDate(localDateTime1);

        int intitialSize = taskService.getTasks().size();

        taskService.addTask(dummyDto);

        assertEquals(intitialSize + 1, taskService.getTasks().size());

        TaskDTO dummyDtoFromService = taskService.getTasks().get(intitialSize);

        assertEquals(dummyDtoFromService.getDescription(),description);
        assertEquals(dummyDtoFromService.getDueDate(),localDateTime1);
        assertEquals(dummyDtoFromService.getTitle(),titel);

    }

    @Test
    void getTaskTest(){
        TaskDTO taskDTO = taskService.getWithId(1);
        TaskDTO taskDTO1 = new TaskDTO();
        taskDTO1.setTaskID(1);

        assertNotNull(taskDTO);
        assertEquals(taskDTO1,taskDTO);
    }

    @Test
    void updateTask(){
        TaskDTO taskDTO = taskService.getWithId(1);

        taskDTO.setTitle("WOPPAAAAAA");
        LocalDateTime localDateTime1 = LocalDateTime.of(2025, 2, 23, 23, 34);
        taskDTO.setDueDate(localDateTime1);
        taskDTO.setDescription("WOPPAAAAAA");

        taskService.updateTask(taskDTO);

        taskDTO = taskService.getWithId(1);

        assertEquals(taskDTO.getTitle(),"WOPPAAAAAA");
        assertEquals(taskDTO.getDescription(),"WOPPAAAAAA");
        assertEquals(taskDTO.getDueDate(),localDateTime1);
    }

    @Test
    void addSubTaskTest(){
        String titel = "dummyaddTest";
        String description = "dummydescription";
        LocalDateTime localDateTime1 = LocalDateTime.of(2025, 2, 23, 23, 34);
        TaskDTO dummyDto = new TaskDTO();

        dummyDto.setTitle(titel);
        dummyDto.setDescription(description);
        dummyDto.setDueDate(localDateTime1);

        taskService.addTask(dummyDto);


        SubTaskDTO subTask = new SubTaskDTO();
        subTask.setTitle("WOPPA");
        subTask.setDescription("WOPPA");

        taskService.addSubTask(subTask,taskService.getTasks().size());

        TaskDTO taskDTO = taskService.getWithId(taskService.getTasks().size());
        SubTaskDTO task = taskDTO.getSubTasks().get(0);

        assertEquals(task.getTitle(),"WOPPA");
        assertEquals(task.getDescription(),"WOPPA");

    }
}

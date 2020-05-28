package be.ucll.todolist.model.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SubTaskTest {

    Task task  = new Task();

    private SubTask subTask = new SubTask("Subtask1","Dit is een subtask",task,1);

    @Test
    void getDescriptionTest(){
        SubTask subTask1 = new SubTask();

        assertEquals(subTask.getDescription(),"Dit is een subtask");
        assertEquals(subTask1.getDescription(),"");
    }

    @Test
    void equalsTest(){
        SubTask subTask2 = new SubTask();
        subTask2.setSubTaskID(1);
        assertEquals(subTask,subTask2);
    }

}

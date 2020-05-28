package be.ucll.todolist.model.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskIDComparatorTest {
    private TaskIDComparator taskIDComparator = new TaskIDComparator();

    @Test
    void testCompare(){
        Task task = new Task();
        task.setTaskID(1);
        Task task1 = new Task();
        task1.setTaskID(2);
        Task task2 = new Task();
        task2.setTaskID(2);

        assertEquals(-1,taskIDComparator.compare(task,task2));
        assertEquals(0,taskIDComparator.compare(task1,task2));
        assertEquals(1,taskIDComparator.compare(task2,task));
    }
}

package be.ucll.todolist.model.domain;

import java.util.Comparator;

public class TaskIDComparator implements Comparator {
    public int compare(Object o1,Object o2){
        Task t1=(Task) o1;
        Task t2=(Task) o2;

        if(t1.getTaskID()==t2.getTaskID())
            return 0;
        else if(t1.getTaskID()>t2.getTaskID())
            return 1;
        else
            return -1;
    }
}
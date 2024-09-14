package lecture2.homework2.tasktracker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskManager {

    private final List<Task> taskList = new ArrayList<>();

    public void addTask(Task task) {
        taskList.add(task);
    }

    public void deleteTask(Task task) {
        taskList.remove(task);
    }

    public void sortByPriorityAsc() {
        taskList.sort(Comparator.comparingInt(Task::getPriority));
    }

    public void sortByPriorityDesc() {
        taskList.sort(Comparator.comparingInt(Task::getPriority).reversed());
    }

    public void print() {
        for (Task task : taskList) {
            System.out.println(task);
        }
    }
}

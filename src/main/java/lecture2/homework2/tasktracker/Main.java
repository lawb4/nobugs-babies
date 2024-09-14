package lecture2.homework2.tasktracker;

public class Main {
    public static void main(String[] args) {

        TaskManager taskManager = new TaskManager();
        Task task1 = new Task("Покормить кота", 2);
        Task task2 = new Task("Помыть посуду", 3);
        Task task3 = new Task("Выполнить домашку по NoBugs Babies", 1);
        Task task4 = new Task("Попылесосить", 2);

        System.out.println("~Добавляем задачи в список.");
        taskManager.addTask(task1);
        taskManager.addTask(task2);
        taskManager.addTask(task3);
        taskManager.addTask(task4);

        System.out.println("~Список задач в порядке их добавления:");
        taskManager.print();

        System.out.println("~Список задач, отсортированный по приоритету (ASC)");
        taskManager.sortByPriorityAsc();
        taskManager.print();

        System.out.println("~Удаляю одну задачу");
        taskManager.deleteTask(task1);

        taskManager.print();
    }
}

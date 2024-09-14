package lecture2.homework2.tasktracker;

public class Task {

    private String description;
    private int priority;

    public Task(String description) {
        this.description = description;
    }

    public Task(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return String.format("[%d] %s;", getPriority(), getDescription());
    }
}

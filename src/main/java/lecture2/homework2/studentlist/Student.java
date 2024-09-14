package lecture2.homework2.studentlist;

public class Student {

    private final String id;
    private final String name;

    public Student() {
        this.id = "unknown";
        this.name = "unknown";
    }

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(String name) {
        this.id = "id_" + name;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("StudentId: %s, Name: %s;", getId(), getName());
    }
}

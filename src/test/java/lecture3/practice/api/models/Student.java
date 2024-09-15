package lecture3.practice.api.models;

public class Student {

    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    public String toJson() {
        return String.format("{\"name\": \"%s\", \"grade\": \"%s\"}", name, grade);
    }
}
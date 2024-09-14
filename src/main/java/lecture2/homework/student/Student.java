package lecture2.homework.student;

public class Student implements Printable {

    private String name;
    private int gradeBookId;
    private double gpa;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGradeBookId() {
        return gradeBookId;
    }

    public void setGradeBookId(int gradeBookId) {
        this.gradeBookId = gradeBookId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public void print() {
        System.out.printf("Студент %s. Номер зачётной книжки: %d. Средний балл: %s",
                getName(), getGradeBookId(), String.format("%.1f", getGpa()));
    }
}

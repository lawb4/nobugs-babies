package lecture2.homework1.student;

public class Student implements Printable {

    private String name;
    private String gradeBookId;
    private double gpa;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGradeBookId() {
        return gradeBookId;
    }

    public void setGradeBookId(String gradeBookId) {
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

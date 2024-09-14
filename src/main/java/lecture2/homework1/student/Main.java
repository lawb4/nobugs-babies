package lecture2.homework1.student;

public class Main {
    public static void main(String[] args) {

        Student student = new Student();
        student.setName("Егор");
        student.setGradeBookId("90235");
        student.setGpa(8.8d);

        student.print();
    }
}

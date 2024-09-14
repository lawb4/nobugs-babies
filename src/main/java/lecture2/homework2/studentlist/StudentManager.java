package lecture2.homework2.studentlist;

import java.util.ArrayList;

public class StudentManager {

    private final ArrayList<Student> listOfStudents = new ArrayList<>();

    public void addStudent(Student student) {
        listOfStudents.add(student);
    }

    public void removeStudentById(int studentId) {
        for (Student student : listOfStudents) {
            if (student.getId() == studentId) {
                listOfStudents.remove(student);
                break;
            }
        }
    }

    public void getAllStudents() {
        for (Student student : listOfStudents) {
            System.out.println(student.toString());
        }
    }
}

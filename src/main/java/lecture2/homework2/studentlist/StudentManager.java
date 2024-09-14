package lecture2.homework2.studentlist;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private final List<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void removeStudent(Student student) {
        studentList.remove(student);
    }

    public void removeStudentById(String studentId) {
        for (Student student : studentList) {
            if (student.getId().equals(studentId)) {
                studentList.remove(student);
                break;
            }
        }
    }

    public void printStudents() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}

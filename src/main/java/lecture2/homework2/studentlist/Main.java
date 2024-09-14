package lecture2.homework2.studentlist;

public class Main {
    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        Student student1 = new Student(42, "Ivan");
        Student student2 = new Student(67, "Dasha");

        System.out.println("Cписок студентов пуст");
        studentManager.getAllStudents(); // 0 students

        studentManager.addStudent(student1);
        System.out.println("Список студентов содержит одного студента:");
        studentManager.getAllStudents(); // 1 student

        studentManager.addStudent(student2);
        System.out.println("Список студентов содержит двух студентов:");
        studentManager.getAllStudents(); // 2 students

        studentManager.removeStudentById(student1.getId());
        System.out.println("Список студентов содержит одного студента:");
        studentManager.getAllStudents(); // 1 student

        studentManager.removeStudentById(student2.getId());
        System.out.println("Cписок студентов пуст");
        studentManager.getAllStudents(); // 0 students
    }
}

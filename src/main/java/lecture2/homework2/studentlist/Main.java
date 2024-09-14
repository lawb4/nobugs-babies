package lecture2.homework2.studentlist;

public class Main {
    public static void main(String[] args) {

        StudentManager studentManager = new StudentManager();
        Student student1 = new Student("STD-42", "Ivan");
        Student student2 = new Student( "Dasha");

        System.out.println("~Cписок студентов пуст.");
        studentManager.printStudents();

        System.out.println("~Добавляем первого студента.");
        studentManager.addStudent(student1);

        System.out.println("~Список студентов содержит одного студента:");
        studentManager.printStudents();

        System.out.println("~Добавляем второго студента.");
        studentManager.addStudent(student2);

        System.out.println("~Список студентов содержит двух студентов:");
        studentManager.printStudents();

        System.out.println("~Удаляем первого студента по id.");
        studentManager.removeStudentById(student1.getId());

        System.out.println("~Список студентов содержит одного студента:");
        studentManager.printStudents();

        System.out.println("~Удаляем второго студента:");
        studentManager.removeStudent(student2);

        System.out.println("~Cписок студентов пуст.");
        studentManager.printStudents();
    }
}

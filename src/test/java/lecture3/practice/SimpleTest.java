package lecture3.practice;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import lecture3.practice.api.StudentAsserts;
import lecture3.practice.api.StudentRequests;
import lecture3.practice.api.models.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SimpleTest {

    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/22f58aa1029345aa8facf429d3da9afe";
    }

    @Test
    public void userShouldBeAbleToCreateStudent() {

        Student student = new Student("Viktor Mamonov", 3);

        StudentRequests.createStudent(student.toJson());
    }

    @Test
    public void userShouldBeAbleToEnsureStudentExists() {
        Student student = new Student("Evgeniy Razumov", 5);

        String studentId = StudentRequests.createStudent(student.toJson());
        StudentRequests.getStudent(studentId);
    }

    @Test
    public void userShouldBeAbleToDeleteExistingStudent() {
        Student student = new Student("Ivan Sokolov", 1);
        String studentId = StudentRequests.createStudent(student.toJson());

        StudentRequests.deleteStudent(studentId);

        StudentAsserts.assertStudentNotExists(studentId);
    }
}


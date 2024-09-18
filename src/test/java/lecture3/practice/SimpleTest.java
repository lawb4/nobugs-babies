package lecture3.practice;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import lecture3.practice.api.StudentAsserts;
import lecture3.practice.api.StudentRequests;
import lecture3.practice.api.models.Student;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SimpleTest {

    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/c2115d09f6e04ca0a047aec0cba2e1d0";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void userShouldBeAbleToCreateStudent() {

        Student student = Student.builder()
                .name("Viktor Mamonov")
                .grade(3).build();

        StudentRequests.createStudent(student);
    }

    @Test
    public void userShouldBeAbleToEnsureStudentExists() {
        Student student = Student.builder()
                .name("Evgeniy Razumov")
                .grade(5).build();

        Student createdStudent = StudentRequests.createStudent(student);
        StudentRequests.getStudent(createdStudent.getId());
    }

    @Test
    public void userShouldBeAbleToDeleteExistingStudent() {
        Student student = Student.builder()
                .name("Ivan Sokolov")
                .grade(1).build();
        Student createdStudent = StudentRequests.createStudent(student);

        StudentRequests.deleteStudent(createdStudent.getId());

        StudentAsserts.assertStudentNotExists(createdStudent.getId());
    }
}


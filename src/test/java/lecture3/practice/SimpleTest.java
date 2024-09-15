package lecture3.practice;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import lecture3.practice.api.StudentRequests;
import lecture3.practice.api.StudentAsserts;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SimpleTest {

    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/a88e06f0ff8a4d47a23108addd490317";
    }

    @Test
    public void userShouldBeAbleToCreateStudent() {

        StudentRequests.createStudent("""
                {
                  "name": "Viktor Mamonov",
                  "grade": 3
                }""");
    }

    @Test
    public void userShouldBeAbleToEnsureStudentExists() {
        String studentId = StudentRequests.createStudent("""
                {
                  "name": "Evgeniy Razumov",
                  "grade": 5
                }""");
        StudentRequests.getStudent(studentId);
    }

    @Test
    public void userShouldBeAbleToDeleteExistingStudent() {
        // Шаг 1. Создание студента и присваивание его id переменной studentId.
        String studentId = StudentRequests.createStudent("""
                {
                  "name": "Ivan Sokolov",
                  "grade": 1
                }""");
        // Шаг 2. Удаление студента.
        StudentRequests.deleteStudent(studentId);
        // Шаг 3. Проверить, что студента больше не существует.
        StudentAsserts.assertStudentNotExists(studentId);
    }
}


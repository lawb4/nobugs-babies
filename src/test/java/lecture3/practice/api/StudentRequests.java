package lecture3.practice.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import lecture3.practice.api.models.Student;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class StudentRequests {

    public static Student createStudent(Student student) {

        String studentJson;
        try {
            studentJson = new ObjectMapper().writeValueAsString(student);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return given()
                .body(studentJson)
                .contentType(ContentType.JSON)
                .when()
                .post("/student")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey("_id"))
                .extract()
                .as(Student.class, ObjectMapperType.GSON);
    }

    public static void getStudent(String studentId) {
        given()
                .get("/student/" + studentId)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    public static void deleteStudent(String studentId) {
        given()
                .delete("/student/" + studentId)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}

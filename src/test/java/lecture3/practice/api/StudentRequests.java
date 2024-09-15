package lecture3.practice.api;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class StudentRequests {

    public static String createStudent(String body) {
        return given()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post("/student")
                .then()
                .assertThat() //syntactic sugar
                .statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey("_id"))
                .extract()
                .path("_id");
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

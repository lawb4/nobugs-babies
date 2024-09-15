package lecture3.practice.api;

import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;

public class NegativeAsserts {

    public static void assertStudentNotExists(String studentId) {
        given()
                .get("/student/" + studentId)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}

package lecture3.homework.api;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {

    protected static final String UNICORNS_API_PATH = "/unicorns-v4/";
    private static final String ID = "_id";
    protected static final String COLOR_TAIL = "colorTail";

    public static String createUnicornJsonBody(String name, String colorTail) {
        return String.format("{\"name\": \"%s\", \"colorTail\": \"%s\"}", name, colorTail);
    }

    public static String createUnicorn(String body) {

        return given()
                .body(body)
                .contentType(ContentType.JSON)
                .when()
                .post(UNICORNS_API_PATH)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey(ID))
                .extract()
                .path(ID);
    }

    public static void getUnicorn(String unicornId) {
        given()
                .get(UNICORNS_API_PATH + unicornId)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    public static void updateUnicornTailColor(String unicornId, String updatedBody) {

        given()
                .body(updatedBody)
                .contentType(ContentType.JSON)
                .when()
                .put(UNICORNS_API_PATH + unicornId)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    public static void deleteUnicorn(String unicornId) {
        given()
                .delete(UNICORNS_API_PATH + unicornId)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}

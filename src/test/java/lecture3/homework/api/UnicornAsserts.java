package lecture3.homework.api;

import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static lecture3.homework.api.UnicornRequests.UNICORNS_API_PATH;
import static org.hamcrest.Matchers.equalTo;

public class UnicornAsserts {

    public static void assertUnicornHasValidColorTail(String unicornId, String colorTail) {
        given()
                .get(UNICORNS_API_PATH + "/" + unicornId)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("colorTail", equalTo(colorTail));
    }

    public static void assertUnicornNotExists(String unicornId) {

        given()
                .get(UNICORNS_API_PATH + "/" + unicornId)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}

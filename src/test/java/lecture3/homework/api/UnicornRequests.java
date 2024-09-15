package lecture3.homework.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import lecture3.homework.api.models.Unicorn;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;

public class UnicornRequests {

    protected static final String UNICORNS_API_PATH = "/unicorns-v5/";
    private static final String UNICORNS_API_ID_KEY = "_id";
    protected static final String COLOR_TAIL = "colorTail";

    public static Unicorn createUnicorn(Unicorn unicorn) {

        String unicornJson;
        try {
            unicornJson = new ObjectMapper().writeValueAsString(unicorn);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return given()
                .body(unicornJson)
                .contentType(ContentType.JSON)
                .when()
                .post(UNICORNS_API_PATH)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("$", hasKey(UNICORNS_API_ID_KEY))
                .extract()
                .as(Unicorn.class, ObjectMapperType.GSON);
    }

    public static void getUnicorn(String unicornId) {
        given()
                .get(UNICORNS_API_PATH + unicornId)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    public static void updateUnicornColorTail(Unicorn unicorn, String colorTail) {

        unicorn.setColorTail(colorTail);

        String unicornJson;
        try {
            unicornJson = new ObjectMapper().writeValueAsString(unicorn);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        given()
                .body(unicornJson)
                .contentType(ContentType.JSON)
                .when()
                .put(UNICORNS_API_PATH + unicorn.getId())
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

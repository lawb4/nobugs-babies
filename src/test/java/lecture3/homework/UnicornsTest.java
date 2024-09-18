package lecture3.homework;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import lecture3.homework.api.UnicornAsserts;
import lecture3.homework.api.UnicornRequests;
import lecture3.homework.api.models.Unicorn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UnicornsTest {

    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/c2115d09f6e04ca0a047aec0cba2e1d0";
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .build();
    }

    @Test
    public void userShouldBeAbleToCreateUnicorn() {
        Unicorn unicorn = Unicorn.builder()
                .name("Rainbow Dash")
                .colorTail("red").build();

        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);

        UnicornRequests.getUnicorn(createdUnicorn.getId());
    }

    @Test
    public void userShouldBeAbleToChangeUnicornTailColor() {
        Unicorn unicorn = Unicorn.builder()
                .name("Rainbow Dash")
                .colorTail("red").build();

        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);

        UnicornRequests.updateUnicornColorTail(createdUnicorn, "orange");
        UnicornAsserts.assertUnicornHasValidColorTail(createdUnicorn.getId(), "orange");
    }

    @Test
    public void userShouldBeAbleToDeleteUnicorn() {
        Unicorn unicorn = Unicorn.builder()
                .name("Rainbow Dash")
                .colorTail("red").build();

        Unicorn createdUnicorn = UnicornRequests.createUnicorn(unicorn);

        UnicornRequests.deleteUnicorn(createdUnicorn.getId());
        UnicornAsserts.assertUnicornNotExists(createdUnicorn.getId());
    }
}

package lecture3.homework;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import lecture3.homework.api.UnicornAsserts;
import lecture3.homework.api.UnicornRequests;
import lecture3.homework.api.models.Unicorn;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UnicornsTest {

    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/fa99ade4d11048b2af182c564229d07f";
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

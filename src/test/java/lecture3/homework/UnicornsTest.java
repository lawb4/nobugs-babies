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
        RestAssured.baseURI = "https://crudcrud.com/api/22f58aa1029345aa8facf429d3da9afe";
    }

    @Test
    public void userShouldBeAbleToCreateUnicorn() {
        Unicorn unicorn = new Unicorn("Rainbow Dash", "red");
        String unicornId = UnicornRequests.createUnicorn(unicorn.toJson());

        UnicornRequests.getUnicorn(unicornId);
    }

    @Test
    public void userShouldBeAbleToChangeUnicornTailColor() {
        Unicorn unicorn = new Unicorn("Rainbow Dash", "red");
        String unicornId = UnicornRequests.createUnicorn(unicorn.toJson());

        unicorn.setColorTail("orange");

        UnicornRequests.updateUnicornTailColor(unicornId, unicorn.toJson());

        UnicornAsserts.assertUnicornHasValidColorTail(unicornId, "orange");
    }

    @Test
    public void userShouldBeAbleToDeleteUnicorn() {
        Unicorn unicorn = new Unicorn("Rainbow Dash", "red");
        String unicornId = UnicornRequests.createUnicorn(unicorn.toJson());

        UnicornRequests.deleteUnicorn(unicornId);
        UnicornAsserts.assertUnicornNotExists(unicornId);
    }
}

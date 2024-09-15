package lecture3.homework;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import lecture3.homework.api.UnicornAsserts;
import lecture3.homework.api.UnicornRequests;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class UnicornsTest {

    private final String UNICORN_BODY_EXAMPLE = UnicornRequests.createUnicornJsonBody
            ("Rainbow Dash", "red");

    @BeforeAll
    public static void setupTests() {
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        RestAssured.baseURI = "https://crudcrud.com/api/a88e06f0ff8a4d47a23108addd490317";
    }

    @Test
    public void userShouldBeAbleToCreateUnicorn() {
        String unicornId = UnicornRequests.createUnicorn(UNICORN_BODY_EXAMPLE);

        UnicornRequests.getUnicorn(unicornId);
    }

    @Test
    public void userShouldBeAbleToChangeUnicornTailColor() {
        String unicornId = UnicornRequests.createUnicorn(UNICORN_BODY_EXAMPLE);

        UnicornRequests.updateUnicornTailColor(unicornId,
                UnicornRequests.createUnicornJsonBody("Rainbow Dash", "orange"));

        UnicornAsserts.assertUnicornHasValidColorTail(unicornId, "orange");
        //UnicornRequests.getUnicorn(unicornId);
    }

    @Test
    public void userShouldBeAbleToDeleteUnicorn() {
        String unicornId = UnicornRequests.createUnicorn(UNICORN_BODY_EXAMPLE);

        UnicornRequests.deleteUnicorn(unicornId);
        UnicornAsserts.assertUnicornNotExists(unicornId);
    }
}

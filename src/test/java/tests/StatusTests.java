package tests;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.is;

public class StatusTests {

    @Test
    void checkStatus(){
        get("https://selenoid.autotests.cloud/status")
                .then()
                .body("total",is(20));

    }
}

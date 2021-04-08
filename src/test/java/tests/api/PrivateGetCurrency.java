package tests.api;

import static io.restassured.RestAssured.given;
import org.junit.Test;


public class PrivateGetCurrency extends BaseApiTest {

    @Test
    public void checkCurrencyInPB(){
        given().spec(rspec)
                .queryParam("exchange")
                .queryParam("coursid",4)
                .when()
                .log()
                .all()
                .get("/pubinfo")
                .then()
                .log()
                .everything()
                .spec(respSpec);

    }
}

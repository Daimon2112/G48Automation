package tests.api;

import static io.restassured.RestAssured.given;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.form;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

public class PrivateGetCurrency extends BaseApiTest {

    @RunWith(Parameterized.class)
    public static class PrivatGetCurrencyTest extends BaseApiTest{

        private final int courseId;

        public PrivatGetCurrencyTest(int courseId) {
            this.courseId = courseId;
        }

        @Parameterized.Parameters
        public static List<Integer> data(){
            return new ArrayList<Integer>(){{
                add(5);
                add(11);
            }};
        }

        @Test
        public void checkCurrencyInPB() {
            //     String response =
            given().spec(rspec)
                    .queryParam("exchange")
                    .queryParam("coursid", this.courseId)
                    .when()
                    .log()
                    .everything()
                    .get("/pubinfo")
                    .then()
                    .log()
                    .everything()
                    .spec(respSpec)
                    .assertThat()
                    .body("ccy", hasItems("USD", "EUR", "BTC", "RUR"))
                    .body("ccy", hasSize(4))
                    .body("base_ccy", hasItem(equalTo("UAH")));
        }
    }
}

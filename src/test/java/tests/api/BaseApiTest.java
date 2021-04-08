package tests.api;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Before;

public abstract class BaseApiTest {

    protected RequestSpecification rspec;
    protected ResponseSpecification respSpec;

    @Before
    public void setUp(){
        this.rspec = new RequestSpecBuilder()
                .setBaseUri("https://api.privatbank.ua/p24api")
                .addQueryParam("json")
                .build();
        this.respSpec = new RequestSpecBuilder()
                .build().expect().statusCode(200);
    }

}


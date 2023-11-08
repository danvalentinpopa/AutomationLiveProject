package tests.apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import utils.APIBaseTest;

public class StandaloneAPITest extends APIBaseTest {

    @Test
    public void firstTest(){

        //Set the req specification
        RequestSpecification requestSpecification = RestAssured.given();

        Response response = requestSpecification.get("/users/1"); //example of an endpoint

        //print the response status code
        System.out.println("Response code: " + response.getStatusCode());

        //print the response body
        System.out.println("Response body: " +response.getBody().asString());
    }
}

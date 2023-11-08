package tests.apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.APIBaseTest;


public class InvalidUserRetrievalAPITest extends APIBaseTest {

    @Test
    public void testInvalidUserRetrievalAPI(){

        int invalidUserID = 1000; //Invalid user ID (assuming it does not exist)

        Response response = RestAssured.given().when().get("/users/" + invalidUserID);

        Assert.assertEquals(response.getStatusCode(), 404, "Status code is not 404");//404 for resource not found
    }
}

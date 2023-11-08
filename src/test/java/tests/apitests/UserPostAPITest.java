package tests.apitests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.APIBaseTest;

import static io.restassured.RestAssured.given;

public class UserPostAPITest extends APIBaseTest {

    @Test
    public void testUserPostAPI(){
        int userID = 1;

        Response response = given().when().get("/users/" + userID + "/posts"); //Endpoint to get a single user

        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not as expected");


        int expectedPostCount = 10;
        int actualPostCount = response.jsonPath().getList("$").size();
        System.out.println(actualPostCount);

        Assert.assertEquals(actualPostCount, expectedPostCount, "Unexpected number of posts");
    }
}

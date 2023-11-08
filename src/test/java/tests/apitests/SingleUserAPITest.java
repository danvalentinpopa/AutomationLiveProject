package tests.apitests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.APIBaseTest;
import static io.restassured.RestAssured.given;

public class SingleUserAPITest extends APIBaseTest {

    @Test
    public void testSingleUserAPI(){

        int userID = 1;

        Response response = given().when().get("/users/" + userID); //Endpoint to get a single user

        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200, "Status code is not as expected");

        String firstUser = "Leanne Graham"; //expected user
        String actualFirstName = response.jsonPath().getString("name");
        System.out.println(actualFirstName);

        Assert.assertEquals(actualFirstName, firstUser, "The name is not as expected");

    }
}

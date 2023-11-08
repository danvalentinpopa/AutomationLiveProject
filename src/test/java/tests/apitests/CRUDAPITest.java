package tests.apitests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.APIBaseTest;
import static io.restassured.RestAssured.given;

/**
 * GET request test:
 * Fetches posts using GET request and validated the response status code
 */

public class CRUDAPITest extends APIBaseTest {

    @Test
    public void testGetRequest(){

        Response response = given().when().get("/posts"); //GET req
        System.out.println("Get request: " + response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200, "Get request failed");
    }

    @Test
    public void testPostRequest(){
        String requestBody = "{\"title\": \"Test Title\", \"body\": \"Test Body\", \"userId\": 1}";
        System.out.println(requestBody);

        Response response = given().contentType(ContentType.JSON).body(requestBody).when().post("/posts"); //POST request to create a post

        Assert.assertEquals(response.getStatusCode(), 201, "Post request failed");
    }

    @Test
    public void testPutRequest(){
        int postIdToUpdate = 1;
        String updatedBody = "{\"body\": \"Updated body Contend\"}";

        Response response = given().contentType(ContentType.JSON).body(updatedBody).when().put("/posts/" + postIdToUpdate);

        String actualBody = response.jsonPath().getString("body");
        System.out.println(actualBody);

        Assert.assertEquals(response.getStatusCode(), 200, "PUT request failed");
    }

    @Test
    public void testDeleteRequest(){
        int postIdToDelete = 1;
        Response response = given().when().delete("/posts/" + postIdToDelete);

        Assert.assertEquals(response.getStatusCode(), 200, "DELETE request failed");
    }

}

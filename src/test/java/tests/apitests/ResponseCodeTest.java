package tests.apitests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.APIBaseTest;

public class ResponseCodeTest extends APIBaseTest {

    @Test
    public void testGetRequestReturn200(){
        Response response = RestAssured.given().when().get("/posts");
        Assert.assertEquals(response.getStatusCode(), 200, "GET request failed");
    }

    @Test
    public void testPostRequestReturn201(){
        String newPostBody = "{\"title\": \"Test title\", \"body\": \"Test body\", \"userId\": 1}";
        System.out.println(newPostBody);

        Response createPostResponse = RestAssured.given().body(newPostBody).when().post("/posts");

        Assert.assertEquals(createPostResponse.getStatusCode(), 201, "POST request failed");
    }

    @Test
    public void testPutRequestReturn200(){
        int postIdToUpdate = 1;
        String newPostBody = "{\"title\": \"Updated title\", \"body\": \"Test body\", \"userId\": 1}";

        Response updatedPostResponse = RestAssured.given().body(newPostBody).when().put("/posts/" + postIdToUpdate);

        Assert.assertEquals(updatedPostResponse.getStatusCode(), 200, "PUT request failed");
    }

    @Test
    public void testDeleteRequestReturn200(){
        int postIdToDelete = 1;

        Response deletePostResponse = RestAssured.given().when().delete("/posts/" + postIdToDelete);
        Assert.assertEquals(deletePostResponse.getStatusCode(), 200, "DELETE request failed");

    }

    @Test
    public void testNonExistentResourceReturn404(){
        int nonExistentId = 1000;

        Response response = RestAssured.given().when().get("/posts/" + nonExistentId);

        Assert.assertEquals(response.getStatusCode(), 404, "Non-existent resource check failed");
    }
}

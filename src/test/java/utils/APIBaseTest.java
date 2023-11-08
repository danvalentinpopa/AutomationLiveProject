package utils;

import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class APIBaseTest {

    @BeforeSuite
    public void setup(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com"; //sample base URL
    }

    @AfterSuite
    public void tearDown(){
        RestAssured.reset();
    }

}

package tests.old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseTest;

public class RegisterTest extends BaseTest {


    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testRegistration(){
        driver.get("https://qa-practice.netlify.app/register");


        WebElement emailAddress = driver.findElement(By.id("emailAddress"));
        WebElement passwordElement = driver.findElement(By.id("password"));
        WebElement checkBox = driver.findElement(By.id("exampleCheck1"));
        WebElement submitButton = driver.findElement(By.id("registerBtn"));

        emailAddress.sendKeys("test@test.com");
        passwordElement.sendKeys("password");
        checkBox.click();
        submitButton.click();

        WebElement successMessage = driver.findElement(By.id("message"));

        Assert.assertTrue(successMessage.getText().contains("The account has been"));


    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

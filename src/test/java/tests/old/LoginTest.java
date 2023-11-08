package tests.old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest{


    WebDriver driver;
    @BeforeMethod
            public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        driver.get("https://qa-practice.netlify.app/auth_ecommerce");


    WebElement userNameElement = driver.findElement(By.id("email"));
    WebElement passwordElement = driver.findElement(By.id("password"));
    WebElement submitButtonElement = driver.findElement(By.id("submitLoginBtn"));


        userNameElement.sendKeys("admin@admin.com");

        passwordElement.sendKeys("admin123");

        submitButtonElement.click();


        WebElement headerTitle = driver.findElement(By.className("section-header"));

        Assert.assertEquals(headerTitle.getText(), "SHOPPING CART");


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

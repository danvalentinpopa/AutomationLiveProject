package tests.old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest {


    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void simpleDropdownTest() {
        driver.get("https://qa-practice.netlify.app/alerts");

        WebElement alertBtn = driver.findElement(By.id("alert-btn"));
        alertBtn.click();

        String alertText = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();

        System.out.println(alertText);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

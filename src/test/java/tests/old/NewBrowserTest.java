package tests.old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

public class NewBrowserTest {


    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void newBrowserTest() {
        driver.get("https://qa-practice.netlify.app/window");

        String originalWindow = driver.getWindowHandle();

        WebElement newBrowserButton = driver.findElement(By.id("newWindowBtn"));
        newBrowserButton.click();

        Set<String> handles = driver.getWindowHandles();
        for (String handle : handles) {
            System.out.println(handle);
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                Assert.assertTrue(driver.findElement(By.id("peopleTable")).isDisplayed());
                driver.close();
            }
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

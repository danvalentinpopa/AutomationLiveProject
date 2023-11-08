package tests.old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IFrameTest {


    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void simpleDropdownTest() {
        driver.get("https://qa-practice.netlify.app/iframe");

        WebElement pageTitle = driver.findElement(By.xpath("//*[@id='content']/h2"));
        System.out.println(pageTitle.getText());

        try {
            WebElement iFrameTitle = driver.findElement(By.className("display-4"));
            System.out.println(iFrameTitle.getText());

        }catch (Throwable throwable){
            driver.switchTo().frame("iframe-checkboxes");

            WebElement iFrameTitle = driver.findElement(By.className("display-4"));
            System.out.println(iFrameTitle.getText());

            Assert.assertTrue(iFrameTitle.getText().contains("Hello, this is an Iframe!"));
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

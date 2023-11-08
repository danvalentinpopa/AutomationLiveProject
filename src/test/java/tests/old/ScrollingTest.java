package tests.old;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollingTest {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void scrollingAction(){
        driver.get("https://qa-practice.netlify.app/scroll");

        WebElement scrollingTestTitle = driver.findElement(By.xpath("//*[@id=\"content\"]/h2"));
        System.out.println(scrollingTestTitle.getText());
        Assert.assertEquals(scrollingTestTitle.getText(), "Scrolling Demo");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50000)");

//        Actions actions = new Actions(driver);
//        actions.scrollToElement(driver.findElement(By.xpath("//*[@id=\"the-end\"]/h3")));
//        Assert.assertEquals(endOfScrollingElement.getText(), "THE END");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

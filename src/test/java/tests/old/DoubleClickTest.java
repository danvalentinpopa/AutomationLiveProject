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

public class DoubleClickTest {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void doubleClickAction(){

        driver.get("https://qa-practice.netlify.app/double-click");

        WebElement secondTabTitle = driver.findElement(By.xpath("//*[@id=\"content\"]/h2"));
        System.out.println(secondTabTitle.getText());
        Assert.assertEquals(secondTabTitle.getText(), "Double Click on Button Example");

        WebElement doubleClickButton = driver.findElement(By.id("double-click-btn"));
        doubleClickButton.click();

        WebElement toastMessage = driver.findElement(By.id("double-click-result"));
        Assert.assertFalse(toastMessage.isDisplayed());

        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();

        Assert.assertTrue(toastMessage.isDisplayed());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

package tests.old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DropDownTest {


    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void simpleDropdownTest() {
        driver.get("https://qa-practice.netlify.app/dropdowns");


//        WebElement dropdownButton = driver.findElement(By.id("dropdown-menu"));
//
//        Select select = new Select(dropdownButton);
//        select.selectByVisibleText("Argentina");
//        Assert.assertTrue(dropdownButton.getText().contains("Argentina"));
//
//        select.selectByIndex(2);
//        Assert.assertTrue(dropdownButton.getText().contains("Afghanistan"), "Index no 2 is not as expected!");



        WebElement multiLevelDropDownButton = driver.findElement(By.id("multi-level-dropdown-btn"));
        multiLevelDropDownButton.click();

        WebElement hoverOver  = driver.findElement(By.linkText("Hover me for more options"));
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverOver).build().perform();


        WebElement secondHover = driver.findElement(By.linkText("Even More.."));
        actions.moveToElement(secondHover).build().perform();


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

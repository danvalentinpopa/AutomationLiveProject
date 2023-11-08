package tests.old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxesTests {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void testCheckboxes(){

        driver.get("https://qa-practice.netlify.app/checkboxes");

        WebElement checkboxNumber1 = driver.findElement(By.id("checkbox1"));
        WebElement checkboxNumber2 = driver.findElement(By.id("checkbox2"));
        WebElement checkboxNumber3 = driver.findElement(By.id("checkbox3"));
        WebElement resetButton = driver.findElement(By.cssSelector("button[type='reset']"));

        System.out.println("checkbox no 1 is selected: " + checkboxNumber1.isSelected());
        Assert.assertFalse(checkboxNumber1.isSelected());

        checkboxNumber1.click();

        System.out.println("checkbox no 1 is selected: " + checkboxNumber1.isSelected());
        Assert.assertTrue(checkboxNumber1.isSelected());

        System.out.println("checkbox no 2 is selected: " + checkboxNumber2.isSelected());
        Assert.assertFalse(checkboxNumber2.isSelected());

        checkboxNumber2.click();

        System.out.println("checkbox no 2 is selected: " + checkboxNumber2.isSelected());
        Assert.assertTrue(checkboxNumber2.isSelected());


        System.out.println("checkbox no 3 is selected: " + checkboxNumber3.isSelected());
        Assert.assertFalse(checkboxNumber3.isSelected());

        checkboxNumber3.click();

        System.out.println("checkbox no 3 is selected: " + checkboxNumber2.isSelected());
        Assert.assertTrue(checkboxNumber3.isSelected());


        //check if the checkboxes are unchecked
        resetButton.click();
        Assert.assertFalse(checkboxNumber1.isSelected());
        Assert.assertFalse(checkboxNumber2.isSelected());
        Assert.assertFalse(checkboxNumber3.isSelected());

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

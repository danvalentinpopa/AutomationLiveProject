package tests.old;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class DynamicTableTest {


    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void newBrowserTest() {
        driver.get("https://qa-practice.netlify.app/dynamic-table");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[1]/td[4]")));

        WebElement ageOfFirstPerson;
        WebElement ageOfSecondPerson;

        ageOfFirstPerson = driver.findElement(By.xpath("//tr[1]/td[3]"));
        ageOfSecondPerson = driver.findElement(By.xpath("//tr[2]/td[3]"));

        try {
            if (Integer.parseInt(ageOfFirstPerson.getText()) < Integer.parseInt(ageOfSecondPerson.getText())) {

                System.out.println("we reach try block");
                System.out.println(ageOfFirstPerson.getText());
                System.out.println(ageOfSecondPerson.getText());
                System.out.println("First person is older then second one");
            }
        } catch (Throwable error){
            ageOfFirstPerson = driver.findElement(By.xpath("//tr[1]/td[4]"));
            ageOfSecondPerson = driver.findElement(By.xpath("//tr[2]/td[4]"));

            if (Integer.parseInt(ageOfFirstPerson.getText()) < Integer.parseInt(ageOfSecondPerson.getText())) {

                System.out.println("we reach catch block");
                System.out.println(ageOfFirstPerson.getText());
                System.out.println(ageOfSecondPerson.getText());
                System.out.println("First person is older then second one");
            }
        } finally {
            System.out.println("we reach finally block!");
        }

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

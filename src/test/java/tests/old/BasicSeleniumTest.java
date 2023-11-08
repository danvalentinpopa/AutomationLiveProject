package tests.old;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseTest;

public class BasicSeleniumTest extends BaseTest {


    @Test
    @Parameters({"website title"})
    public void sampleTest(String title) {
        driver.get("https://www.example.com/");

        String pageTitle = driver.getTitle();

        System.out.println("Page title is: " + pageTitle);

        Assert.assertEquals(pageTitle, title);

//        WebElement linkText = driver.findElement(By.linkText("More information..."));
//
//        linkText.click();
//
//        WebElement textInsideSecondPage = driver.findElement(By.xpath("//h2[contains(.,'Further Reading')]"));
//
//        Assert.assertEquals(textInsideSecondPage.getText(), title);
    }

}

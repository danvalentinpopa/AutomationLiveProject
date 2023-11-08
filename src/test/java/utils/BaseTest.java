package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

public class BaseTest {

    protected WebDriver driver;

    private ScreenshotUtils screenshotUtils;

    private ExtentTest extentTest;



    @BeforeSuite
    public void setupReport(){
        //Initialize ExtendTest
        ReportManager.getInstance();
    }

    @BeforeClass
    public void setupDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        screenshotUtils = new ScreenshotUtils(driver);
        driver.manage().window().maximize();
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @AfterMethod
    public void afterMethod(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            captureAndSaveFailureScreenShot(result.getMethod().getMethodName());
        }
        if (result.getStatus() == ITestResult.FAILURE){
            extentTest.log(Status.FAIL, MarkupHelper.createLabel("Testcase failed: " + result.getName(), ExtentColor.RED));
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, MarkupHelper.createLabel("Testcase passes: " + result.getName(), ExtentColor.GREEN));
        } else {
            extentTest.log(Status.SKIP, MarkupHelper.createLabel("Testcase skipped: " + result.getName(), ExtentColor.ORANGE));
        }
    }

    @AfterClass
    public void teardownDriver(){
        if (driver != null){
            driver.quit();
        }
    }

    @AfterSuite
    public void tearDown(){
        //Flush ExtentReports to generate the report
        ReportManager.getInstance().flush();
    }


    protected void initTest(String testName){
        extentTest = ReportManager.getInstance().createTest(testName);
    }

    private void captureAndSaveFailureScreenShot(String testName){
        //create a folder is doesn't exist
        File screenShotDirectory = new File("screenshots");
        if (!screenShotDirectory.exists()){
            screenShotDirectory.mkdirs();
        }
        //capture and save the screenshot
        screenshotUtils.captureAndSaveScreenshot(testName);
    }


}

package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    private WebDriver driver;

    public ScreenshotUtils(WebDriver driver){
        this.driver = driver;
    }


    public void captureAndSaveScreenshot(String testName){

        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
            String screenshotFileName = testName + "_" + timestamp + ".png";
            String screenshotDirectory = "screenshots"; // Specify your desired directory


            File targetFile = new File(screenshotDirectory, screenshotFileName);
            FileHandler.copy(screenshotFile, targetFile);
            System.out.println("Screenshot saved to " + targetFile.getAbsolutePath());
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}

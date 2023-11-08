package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountServicesElements {

    public WebDriver driver;

    public AccountServicesElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getAccountOverview(){
        return driver.findElement(By.linkText("Accounts Overview"));
    }

    public WebElement getFirstAccount(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ng-binding")));
        return driver.findElement(By.className("ng-binding"));
    }

    public WebElement getAccountDetailsTitle(){
        return driver.findElement(By.xpath("//h1[text()='Account Details']"));
    }

    public WebElement getAccountNumberFromAccountDetails(){
        return driver.findElement(By.id("accountId"));
    }

    public WebElement getTransferFundsButton(){
        return driver.findElement(By.linkText("Transfer Funds"));
    }
}



package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationUtilsElements {
    public WebDriver driver;

    public AuthenticationUtilsElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getFirstName(){
        return driver.findElement(
                By.id("customer.firstName")
        );
    }
    public WebElement getLastName(){
        return driver.findElement(By.id("customer.lastName"));
    }
    public WebElement getAddress(){
        return driver.findElement(By.id("customer.address.street"));
    }
    public WebElement getCity(){
        return driver.findElement(By.id("customer.address.city"));
    }
    public WebElement getState(){
        return driver.findElement(By.id("customer.address.state"));
    }
    public WebElement getZipCode(){
        return driver.findElement(By.id("customer.address.zipCode"));
    }
    public WebElement getSsn(){
        return driver.findElement(By.id("customer.ssn"));
    }
    public WebElement getUsername(){
        return driver.findElement(By.id("customer.username"));
    }
    public WebElement getPassword(){
        return driver.findElement(By.id("customer.password"));
    }
    public WebElement getRepeatedPassword(){
        return driver.findElement(By.id("repeatedPassword"));
    }
    public WebElement getSubmitButton(){
        return driver.findElement(By.xpath("//input[@value='Register']"));
    }
}

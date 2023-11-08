package pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageElements {
    private final WebDriver driver;

    public HomePageElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getRegisterButton(){
        return  driver.findElement(By.linkText("Register"));
    }

    public WebElement getUsernameInput(){
        return driver.findElement(By.cssSelector("input[name='username']"));
    }
    public WebElement getPasswordInput(){
        return driver.findElement(By.cssSelector("input[name='password']"));
    }
    public WebElement getSubmitButton(){
        return driver.findElement(By.cssSelector("input[type='submit']"));
    }
}

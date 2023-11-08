package pages.actions;


import org.openqa.selenium.WebDriver;
import pages.elements.HomePageElements;

public class HomePage{

    private final HomePageElements elements;

    public HomePage(WebDriver driver){
        this.elements = new HomePageElements(driver);
    }

    public void clickOnRegisterButton(){
        elements.getRegisterButton().click();
    }

    public void loginUser(String username, String password){
        elements.getUsernameInput().sendKeys(username);
        elements.getPasswordInput().sendKeys(password);
        elements.getSubmitButton().click();
    }

}

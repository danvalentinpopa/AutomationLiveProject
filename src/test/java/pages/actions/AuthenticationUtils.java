package pages.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.elements.AuthenticationUtilsElements;

public class AuthenticationUtils {

    private AuthenticationUtilsElements elements;

    public AuthenticationUtils(WebDriver driver){
        this.elements = new AuthenticationUtilsElements(driver);
    }

    public void registerUser(String user, String pass){
        elements.getFirstName().sendKeys("Dan");
        elements.getLastName().sendKeys("Popa");
        elements.getAddress().sendKeys("bucharest");
        elements.getCity().sendKeys("bucharest");
        elements.getState().sendKeys("bucharest");
        elements.getZipCode().sendKeys("123456");
        elements.getSsn().sendKeys("456789");
        elements.getUsername().sendKeys(user);
        elements.getPassword().sendKeys(pass);
        elements.getRepeatedPassword().sendKeys(pass);
        elements.getSubmitButton().click();
    }
}

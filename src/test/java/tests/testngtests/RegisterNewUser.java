package tests.testngtests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.actions.AuthenticationUtils;
import pages.actions.HomePage;
import utils.BaseTest;

public class RegisterNewUser extends BaseTest {

    @BeforeMethod
    public void setup(){
        //Initialize the ExtentTest instance for this test
        initTest("Register new user");
    }

    @Test
    public void registerNewUser(){

        HomePage homePage = new HomePage(driver);
        homePage.clickOnRegisterButton();

        String username = RandomStringUtils.randomAlphabetic(6);
        String password = RandomStringUtils.randomAlphabetic(10);

        System.out.println("Username: " + username + ", password: " + password);

        AuthenticationUtils authenticationUtils = new AuthenticationUtils(driver);
        authenticationUtils.registerUser(username, password);

    }

}

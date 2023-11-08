package tests.bdd;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.actions.AccountServices;
import pages.actions.AuthenticationUtils;
import pages.actions.HomePage;
import utils.WebDriverManagerBDD;

public class TransferFundsBetweenAccounts {

    private WebDriver driver;
    private AccountServices accountServices;



    @When("I click on the Transfer Funds link")
    public void i_click_on_the_transfer_funds_link() {

        driver = WebDriverManagerBDD.setupDriver();

        accountServices = new AccountServices(driver);
        accountServices.clickOnTheTransferFundsButton();

    }
    @And("I transfer {int} between two of my accounts")
    public void i_transfer_between_two_of_my_accounts(Integer int1) {

    }
    @Then("the transfer should be successful")
    public void the_transfer_should_be_successful() {

    }
    @And("the account balances should be updated")
    public void the_account_balances_should_be_updated() {

    }
    @After
    public void tearDown() {
        WebDriverManagerBDD.teardownDriver();
    }

}

package com.juaracoding;

import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static com.juaracoding.utils.Hooks.driver;

public class LoginTest {

    private LoginPage loginPage = new LoginPage(driver);

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {
        delay(1);
        loginPage.enterUsername("standard_user");
        delay(1);
        loginPage.enterPassword("secret_sauce");
    }

    @When("I enter invalid username and valid password")
    public void i_enter_invalid_username_and_valid_password() {
        delay(1);
        loginPage.enterUsername("invalid_user");
        delay(1);
        loginPage.enterPassword("secret_sauce");
    }

    @When("I enter valid username and invalid password")
    public void i_enter_valid_username_and_invalid_password() {
        delay(1);
        loginPage.enterUsername("standard_user");
        delay(1);
        loginPage.enterPassword("invalid_password");
    }

    @When("I enter invalid username and password")
    public void i_enter_invalid_username_and_password() {
        delay(1);
        loginPage.enterUsername("invalid_user");
        delay(1);
        loginPage.enterPassword("invalid_password");
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should be redirected to the main page")
    public void i_should_be_redirected_to_the_main_page() {
        delay(1);
        String actualTitle = loginPage.getPageTitle();
        Assert.assertEquals(actualTitle, "Swag Labs");
    }

    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        delay(1);
        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(loginPage.getErrorMessageText(), expectedErrorMessage);
    }

    public static void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


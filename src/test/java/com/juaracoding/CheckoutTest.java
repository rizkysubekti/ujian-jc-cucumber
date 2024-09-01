package com.juaracoding;

import com.juaracoding.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.juaracoding.pages.CheckoutPage;

public class CheckoutTest {
    WebDriver driver;
    CheckoutPage checkoutPage;
    private LoginPage loginPage;

    @Given("I have 2 products in the cart")
    public void i_have_2_products_in_the_cart() {
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // Login as standard user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Add two products to the cart
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();

        // Go to cart and proceed to checkout
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.xpath("//button[@id='checkout']")).click();

        // Initialize CheckoutPage after navigating to checkout
        checkoutPage = new CheckoutPage(driver);
    }

    @Given("I am on the checkout page")
    public void i_am_on_the_checkout_page() {
        delay(1);
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one"));
    }

    @When("I enter my first name, last name, and postal code")
    public void i_enter_my_first_name_last_name_and_postal_code() {
        delay(1);
        checkoutPage.enterFirstName("Rizky");
        delay(1);
        checkoutPage.enterLastName("Subekti");
        delay(1);
        checkoutPage.enterPostalCode("16116");
    }

    @When("I enter my first name and last name but leave the postal code blank")
    public void i_enter_my_first_name_and_last_name_but_leave_the_postal_code_blank() {
        delay(1);
        checkoutPage.enterFirstName("Rizky");
        delay(1);
        checkoutPage.enterLastName("Subekti");
    }

    @And("I click the continue button")
    public void i_click_the_continue_button() {
        delay(1);
        checkoutPage.clickContinueButton();
    }

    @And("I click the finish button")
    public void i_click_the_finish_button() {
        delay(1);
        checkoutPage.clickFinishButton();
    }

    @Then("I should see the confirmation message {string}")
    public void i_should_see_the_confirmation_message(String expectedMessage) {
        delay(1);
        Assert.assertEquals(checkoutPage.getConfirmationMessage(), expectedMessage);
    }

    @Then("I should see an error message indicating that the postal code is required")
    public void i_should_see_an_error_message_indicating_that_the_postal_code_is_required() {
        delay(1);
        Assert.assertTrue(checkoutPage.getErrorMessage().contains("Error: Postal Code is required"));
    }

    public static void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

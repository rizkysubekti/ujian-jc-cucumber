package com.juaracoding;

import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ProductPage;
import com.juaracoding.utils.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ProductTest {

    WebDriver driver;
    private ProductPage productPage = new ProductPage(Hooks.driver);
    private LoginPage loginPage;

    @Given("I am logged in as a standard user")
    public void i_am_logged_in_as_a_standard_user() {
        System.setProperty("webdriver.chrome.driver", "C:\\MyTools\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // Login as standard user
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Initialize ProductsPage after login
        productPage = new ProductPage(driver);
    }

    @When("I add the first product to the cart")
    public void i_add_the_first_product_to_the_cart() {
        delay(1);
        productPage.addFirstProductToCart();
    }

    @When("I add the second product to the cart")
    public void i_add_the_second_product_to_the_cart() {
        delay(1);
        productPage.addSecondProductToCart();
    }

    @Then("the cart should display {string} items")
    public void the_cart_should_display_items(String itemCount) {
        delay(1);
        Assert.assertEquals(productPage.getCartItemCount(), itemCount);
    }

    @Then("the cart should contain the first product")
    public void the_cart_should_contain_the_first_product() {
        delay(1);
        productPage.clickCartIcon();
        Assert.assertTrue(productPage.isFirstProductInCart());
    }

    @Then("the cart should contain the second product")
    public void the_cart_should_contain_the_second_product() {
        delay(1);
        productPage.clickCartIcon();
        Assert.assertTrue(productPage.isSecondProductInCart());
    }

    public static void delay(long detik) {
        try {
            Thread.sleep(detik * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

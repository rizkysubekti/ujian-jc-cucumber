package com.juaracoding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement addToCartButtonFirstProduct;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    WebElement addToCartButtonSecondProduct;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement cartIcon;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    WebElement cartBadge;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    WebElement firstProductInCart;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    WebElement secondProductInCart;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addFirstProductToCart() {
        addToCartButtonFirstProduct.click();
    }

    public void addSecondProductToCart() {
        addToCartButtonSecondProduct.click();
    }

    public void clickCartIcon() {
        cartIcon.click();
    }

    public String getCartItemCount() {
        return cartBadge.getText();
    }

    public boolean isFirstProductInCart() {
        return firstProductInCart.isDisplayed();
    }

    public boolean isSecondProductInCart() {
        return secondProductInCart.isDisplayed();
    }

}

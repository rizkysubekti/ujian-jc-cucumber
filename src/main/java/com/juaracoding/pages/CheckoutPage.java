package com.juaracoding.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement postalCodeField;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement continueButton;

    @FindBy(xpath = "//button[@id='finish']")
    WebElement finishButton;

    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement confirmationMessage;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorMessage;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeField.sendKeys(postalCode);
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickFinishButton() {
        finishButton.click();
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

}

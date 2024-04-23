package com.udacity.jwdnd.c1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CounterPageSignup {
    @FindBy(id = "inputUsername")
    private WebElement username;

    @FindBy(id = "inputPassword")
    private WebElement password;

    @FindBy(id = "inputFirstName")
    private WebElement firstName;

    @FindBy(id = "inputLastName")
    private WebElement lastName;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    @FindBy(id = "success-msg")
    private WebElement successMsg;

    public CounterPageSignup(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean signUpUser(String username, String password, String firstName, String lastName) {
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.submitButton.click();
        return this.successMsg.isDisplayed();
    }

}

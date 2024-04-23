package com.udacity.jwdnd.c1.review;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CounterPageLogin {

    @FindBy(id = "inputUsername")
    private WebElement username;

    @FindBy(id = "inputPassword")
    private WebElement password;


    public CounterPageLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getInputUsername() {
        return username.getText();
    }

    public String getInputPassword() {
        return password.getText();
    }

    public void setUsername(WebElement username) {
        this.username = username;
    }

    public void setPassword(WebElement password) {
        this.password = password;
    }
}

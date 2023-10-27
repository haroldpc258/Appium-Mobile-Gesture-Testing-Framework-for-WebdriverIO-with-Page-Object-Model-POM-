package com.globant.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "button-LOGIN")
    private WebElement loginBtn;
    @AndroidFindBy(accessibility = "button-login-container")
    private WebElement logInSelect;
    @AndroidFindBy(accessibility = "button-sign-up-container")
    private WebElement signUpSelect;
    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement confirmPasswordInput;
    @AndroidFindBy(accessibility = "input-email")
    private WebElement emailInput;
    @AndroidFindBy(accessibility = "input-password")
    private WebElement passwordInput;
    @AndroidFindBy(accessibility = "button-SIGN UP")
    private WebElement signUpBtn;

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }

    public boolean IsScreenAvailable() {
        return isElementAvailable(loginBtn);
    }

    public String getAlertText() {
        waitAlertToBePresent();
        return driver.switchTo().alert().getText();
    }

    public void signUp() {
        clickOn(signUpSelect);
        String email = "example@example.com";
        String password = "password";
        writeIn(emailInput, email);
        writeIn(passwordInput, password);
        writeIn(confirmPasswordInput, password);
        clickOn(signUpBtn);
    }

    public void signIn() {
        signUp();
        waitAlertToBePresent();
        driver.switchTo().alert().accept();
        clickOn(logInSelect);
        String email = "example@example.com";
        String password = "password";
        writeIn(emailInput, email);
        writeIn(passwordInput, password);
        clickOn(loginBtn);
    }


}

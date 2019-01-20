package com.staging9mcollab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * This class models the Login Page and its objects
 *
 * @author Zoran Dragovic
 */
public class LoginPage {
    @FindBy(how = How.ID, using = "username")
    public WebElement email;

    @FindBy(how = How.ID, using = "password")
    public WebElement password;

    @FindBy(how = How.ID, using = "rememberMe")
    public WebElement rememberMe;

    @FindBy(how = How.LINK_TEXT, using = "Forgot Password?")
    public WebElement forgotPassword;

    @FindBy(how = How.ID, using = "kc-login")
    public WebElement logIn;

    public void enterUsername(String username) {
        email.clear();
        email.sendKeys(username);
    }

    public void enterPassword(String pass) {
        password.clear();
        password.sendKeys(pass);
    }

    public void clickLogIn() {
        logIn.click();
    }

    /**
     * This method is used to login to application
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogIn();
    }
}
package com.staging9mcollab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Page object class for Login page
 *
 * @author Zoran Dragovic
 */
public class LoginPage {
    //Login page object elements
    @FindBy(how = How.ID, using = "username")
    public WebElement emailInput;

    @FindBy(how = How.ID, using = "password")
    public WebElement passwordInput;

    @FindBy(how = How.ID, using = "kc-login")
    public WebElement logInButton;

    public void enterUsername(String username) {
        emailInput.clear();
        emailInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogIn() {
        logInButton.click();
    }

    /**
     * <p>
     * This method is used to login to application
     * </p>
     * @param username user's email address
     * @param password user's password
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogIn();
    }
}
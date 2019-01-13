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

    @FindBy(how = How.LINK_TEXT, using = "kc-login")
    public WebElement logIn;
}
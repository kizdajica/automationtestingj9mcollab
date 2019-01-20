package com.staging9mcollab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.staging9mcollab.helpers.WaitHelpers.waitAditional;

public class NavigationPage {
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[3]/div[1]/ul/li[2]/a")
    public WebElement myGroups;

    @FindBy(how = How.XPATH, using = "//a[@tooltip='Create group']")
    public WebElement createAGroupButton;

    @FindBy(how = How.XPATH, using = "//md-menu/a")
    public WebElement userMenu;

    @FindBy(how = How.XPATH, using = "//button[@aria-label='logout']")
    public WebElement logOutButton;


    public void clickMyGroups() {
        myGroups.click();
    }

    public void openUserMenu() {
        userMenu.click();
    }

    public void clickLogOut() {
        logOutButton.click();
    }

    public void clickCreateGroup() {
        createAGroupButton.click();
    }

    public void logOut() {
        openUserMenu();
        waitAditional(1);
        clickLogOut();
    }
}
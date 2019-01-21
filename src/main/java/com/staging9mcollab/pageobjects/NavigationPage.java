package com.staging9mcollab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.staging9mcollab.helpers.WaitHelpers.waitAditional;

/**
 * Page object class for Navigation page
 *
 * @author Zoran Dragovic
 */
public class NavigationPage {
    //Navigation page object elements
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[3]/div[1]/ul/li[2]/a")
    public WebElement myGroupsButton;

    @FindBy(how = How.XPATH, using = "//a[@tooltip='Create group']")
    public WebElement createGroupButton;

    @FindBy(how = How.XPATH, using = "//md-menu/a")
    public WebElement userMenuDropdown;

    @FindBy(how = How.XPATH, using = "//button[@aria-label='logout']")
    public WebElement logOutButton;

    public void clickMyGroups() {
        myGroupsButton.click();
    }

    public void clickCreateGroup() {
        createGroupButton.click();
    }

    public void openUserMenu() {
        userMenuDropdown.click();
    }

    public void clickLogOut() {
        logOutButton.click();
    }

    /**
     * <p>
     * This method logs out the user
     * </p>
     */
    public void logOut() {
        openUserMenu();
        waitAditional(1);
        clickLogOut();
    }
}
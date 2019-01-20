package com.staging9mcollab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * This class models the DashboardPage Page and its objects
 *
 * @author Zoran Dragovic
 */
public class DashboardPage {
    @FindBy(how = How.XPATH, using = "/html/body/div/div[4]/div/div[1]/div/div[1]/div[2]/div/button[1]")
    public WebElement createAGroupButton;

    public void clickCreateGroup() {
        createAGroupButton.click();
    }
}

package com.staging9mcollab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NavigationPage {
    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[3]/div[1]/ul/li[2]/a")
    public WebElement myGroups;

    @FindBy(how = How.XPATH, using = "/html/body/div/div[4]/div/div[1]/div/div[1]/div[2]/div/button[1]")
    public WebElement createAGroupButton;

    public void clickMyGroups() {
        myGroups.click();
    }
}

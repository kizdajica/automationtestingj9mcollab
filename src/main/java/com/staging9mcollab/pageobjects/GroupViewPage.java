package com.staging9mcollab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Page object class for Group View page
 *
 * @author Zoran Dragovic
 */
public class GroupViewPage {
    //Group View page object elements
    @FindBy(how = How.XPATH, using = "//span[text()='Open']/ancestor::button[@class='button button--transparent-white button--transition-background ng-scope']")
    public WebElement openButton;

    public void clickOpen() {
        openButton.click();
    }
}
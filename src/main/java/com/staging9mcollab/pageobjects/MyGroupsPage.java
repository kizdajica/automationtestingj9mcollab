package com.staging9mcollab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Page object class for My Groups page
 *
 * @author Zoran Dragovic
 */
public class MyGroupsPage {
    //My Groups page object elements
    @FindBy(how = How.XPATH, using = "//span[text()='Edit']")
    public WebElement editButton;
}
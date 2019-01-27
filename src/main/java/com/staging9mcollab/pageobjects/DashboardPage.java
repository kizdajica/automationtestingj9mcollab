package com.staging9mcollab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Page object class for Dashboard page
 *
 * @author Zoran Dragovic
 */
public class DashboardPage {
    //Dashboard page object elements
    @FindBy(how = How.XPATH, using = "/html/body/div/div[4]/div/div[1]/div/div[1]/div[2]/div[1]/div/div[4]/div[2]/span/pre")
    public WebElement mainTopicMessage;

    @FindBy(how = How.XPATH, using = "/html/body/div/div[4]/div/div[1]/div/div[1]/div[2]/div[2]/div/div[4]/div[2]/span/pre")
    public WebElement subTopicMessage;
}
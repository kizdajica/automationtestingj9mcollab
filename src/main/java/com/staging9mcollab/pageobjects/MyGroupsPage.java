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
    /**
     * The name of the created group
     */
    private static final String topicName = "654Group789";

    //My Groups page object elements
    @FindBy(how = How.XPATH, using = "//span[text()='" + topicName + "']/ancestor::td[@class='name']")
    public WebElement existingTopicName;

    /**
     * <p>
     * This method opens the existing group
     * </p>
     */
    public void clickExistingTopic() {
        existingTopicName.click();
    }
}
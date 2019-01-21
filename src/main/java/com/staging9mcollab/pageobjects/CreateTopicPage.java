package com.staging9mcollab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.staging9mcollab.helpers.WaitHelpers.waitAditional;

/**
 * Page object class for Create Topic page
 *
 * @author Zoran Dragovic
 */
public class CreateTopicPage {
    //Create Topic page object elements
    @FindBy(how = How.XPATH, using = "//input[@name='topicName']")
    public WebElement subtopicNameInput;

    @FindBy(how = How.XPATH, using = "//button[@aria-label='AddRemove']")
    public WebElement addAllButton;

    @FindBy(how = How.XPATH, using = "//button[@flex='25']")
    public WebElement createButton;

    public void enterSubtopicName(String name) {
        subtopicNameInput.clear();
        subtopicNameInput.sendKeys(name);
    }

    public void clickAddAllButton() {
        addAllButton.click();
    }

    public void clickCreateButton() {
        createButton.click();
    }

    /**
     * <p>
     * This method creates new subtopic
     * </p>
     *
     * @param name subtopic name
     */
    public void createSubtopic(String name) {
        enterSubtopicName(name);
        waitAditional(1);
        clickAddAllButton();
        waitAditional(1);
        clickCreateButton();
    }
}
package com.staging9mcollab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.staging9mcollab.helpers.WaitHelpers.waitAditional;

public class CreateTopicPage {
    @FindBy(how = How.XPATH, using = "//input[@name='topicName']")
    public WebElement subtopicName;

    @FindBy(how = How.XPATH, using = "//button[@aria-label='AddRemove']")
    public WebElement addAllButton;

    @FindBy(how = How.XPATH, using = "//button[@flex='25']")
    public WebElement createButton;

    public void enterSubtopicName(String name) {
        subtopicName.sendKeys(name);
    }

    public void clickAddAllButton() {
        addAllButton.click();
    }

    public void clickCreateButton() {
        createButton.click();
    }

    public void createSubtopic(String name) {
        enterSubtopicName(name);
        waitAditional(1);
        clickAddAllButton();
        waitAditional(1);
        clickCreateButton();
    }
}

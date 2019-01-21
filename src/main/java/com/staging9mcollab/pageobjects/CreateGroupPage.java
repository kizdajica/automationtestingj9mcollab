package com.staging9mcollab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Page object class for Create Group page
 *
 * @author Zoran Dragovic
 */
public class CreateGroupPage {
    //Create Group page object elements
    @FindBy(how = How.CSS, using = "input[name='groupName']")
    public WebElement mainTopicInput;

    @FindBy(how = How.CSS, using = "textarea[placeholder='Add description...']")
    public WebElement descriptionInput;

    @FindBy(how = How.XPATH, using = "/html/body/div/div[4]/div/div[1]/div[3]/div/div/div/button[1]")
    public WebElement createButton;

    public void setMainTopic(String mainTopic) {
        mainTopicInput.clear();
        mainTopicInput.sendKeys(mainTopic);
    }

    public void addDescription(String description) {
        descriptionInput.clear();
        descriptionInput.sendKeys(description);
    }

    public void clickCreate() {
        createButton.click();
    }

    /**
     * <p>
     * This method creates main topic
     * </p>
     *
     * @param mainTopic   main topic name
     * @param description main topic description
     */
    public void createGroup(String mainTopic, String description) {
        setMainTopic(mainTopic);
        addDescription(description);
        clickCreate();
    }
}
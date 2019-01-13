package com.staging9mcollab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CreateGroupPage {
    @FindBy(how = How.CSS, using = "input[name='groupName']")
    private WebElement setMainTopic;

    @FindBy(how = How.CSS, using = "textarea[placeholder='Add description...']")
    private WebElement addDescription;

    @FindBy(how = How.XPATH, using = "/html/body/div/div[4]/div/div[1]/div[3]/div/div/div/button[1]")
    private WebElement create;

    private void setMainTopic(String mainTopic) {
        setMainTopic.clear();
        setMainTopic.sendKeys(mainTopic);
    }

    private void addDescription(String description) {
        addDescription.clear();
        addDescription.sendKeys(description);
    }

    private void clickCreate() {
        create.click();
    }

    public void createGroup(String mainTopic, String description) {
        setMainTopic(mainTopic);
        addDescription(description);
        clickCreate();
    }
}

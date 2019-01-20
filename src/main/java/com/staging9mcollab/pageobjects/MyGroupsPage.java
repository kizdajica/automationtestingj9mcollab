package com.staging9mcollab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyGroupsPage {
    private static final String topicName = "654Group789";

    @FindBy(how = How.XPATH, using = "//span[text()='" + topicName + "']/ancestor::td[@class='name']")
    public WebElement existingTopicName;

    public void clickExistingTopic() {
        existingTopicName.click();
    }
}
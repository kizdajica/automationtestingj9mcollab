package com.staging9mcollab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MyGroupsPage {
    @FindBy(how = How.XPATH, using = "//span[text()='654Group989']/ancestor::td[@class='name']")
    public WebElement existingTopicName;

    public void clickExistingTopic() {
        existingTopicName.click();
    }
}
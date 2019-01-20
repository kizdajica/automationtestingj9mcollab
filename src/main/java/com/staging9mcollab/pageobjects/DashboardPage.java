package com.staging9mcollab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * This class models the DashboardPage Page and its objects
 *
 * @author Zoran Dragovic
 */
public class DashboardPage {
    private static final String topicMessage = "This is Topic message";
    private static final String subtopicMessage = "This is Subtopic message";
    @FindBy(how = How.XPATH, using = "//pre[text()='" + topicMessage + "']/ancestor::span[@class='message-text']")
    public WebElement mainTopicMessage;

    @FindBy(how = How.XPATH, using = "//pre[text()='" + subtopicMessage + "']/ancestor::span[@class='message-text']")
    public WebElement subTopicMessage;
}

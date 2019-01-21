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
    /**
     * The message sent to main topic members
     */
    private static final String topicMessage = "This is a main topic message";
    /**
     * The message sent to subtopic members
     */
    private static final String subtopicMessage = "This is a subtopic message";

    //Dashboard page object elements
    @FindBy(how = How.XPATH, using = "//pre[text()='" + topicMessage + "']/ancestor::span[@class='message-text']")
    public WebElement mainTopicMessage;

    @FindBy(how = How.XPATH, using = "//pre[text()='" + subtopicMessage + "']/ancestor::span[@class='message-text']")
    public WebElement subTopicMessage;
}
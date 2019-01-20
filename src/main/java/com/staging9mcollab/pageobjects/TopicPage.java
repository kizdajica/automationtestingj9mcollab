package com.staging9mcollab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TopicPage {
    private static final String topicName = "654Group789";
    private static final String subtopicName = "Subtopic";

    @FindBy(how = How.XPATH, using = "//div[@id='topics']/div/div/div/div[2]/div/button")
    public WebElement createSubtopicButton;

    @FindBy(how = How.XPATH, using = "//span[text()='Create Conclusion']/ancestor::button[@type='button']")
    public WebElement createConclusionButton;

    @FindBy(how = How.XPATH, using = "//span[text()='View conclusion']/ancestor::button[@type='button']")
    public WebElement viewConclusionButton;

    @FindBy(how = How.XPATH, using = "//button[text()=' Edit Group']/ancestor::div[@class='button-wrap ng-scope']")
    public WebElement editGroupButton;

    @FindBy(how = How.ID, using = "tinymce")
    public WebElement textArea;

    @FindBy(how = How.XPATH, using = "//div[3]/md-input-container/md-select")
    public WebElement votingTypeUnselected;

    @FindBy(how = How.XPATH, using = "//div[3]/md-input-container/md-select/md-select-value/span/div")
    public WebElement votingTypeSelected;

    @FindBy(how = How.XPATH, using = "//div[3]/md-select-menu/md-content/md-option/div")
    public WebElement majority;

    @FindBy(how = How.XPATH, using = "//div[3]/md-select-menu/md-content/md-option[2]/div")
    public WebElement consensus;

    @FindBy(how = How.CSS, using = ".ladda-button")
    public WebElement proposeButton;

    @FindBy(how = How.XPATH, using = "//div[text()=' " + topicName + "']/ancestor::div[@class='center']")
    public WebElement mainTopic;

    @FindBy(how = How.XPATH, using = "//textarea[@placeholder='Type a message...']")
    public WebElement messageTextArea;

    @FindBy(how = How.XPATH, using = "//button[@ng-click='vm.sendMessage()']")
    public WebElement sendMessageButton;

    @FindBy(how = How.XPATH, using = "//div[text()=' " + subtopicName + "']/ancestor::div[@class='center']")
    public WebElement subtopic;

    public void clickCreateSubtopic() {
        createSubtopicButton.click();
    }

    public void clickCreateConclusion() {
        createConclusionButton.click();
    }

    public void clickViewConclusion() {
        viewConclusionButton.click();
    }

    public void clickEditGroup() {
        editGroupButton.click();
    }

    public void enterConclusionName(String conclusionName) {
        textArea.clear();
        textArea.sendKeys(conclusionName);
    }

    public void clickVotingType() {
        votingTypeUnselected.click();
    }

    public void selectMajority() {
        majority.click();
    }

    public void selectConsensus() {
        consensus.click();
    }

    public void clickPropose() {
        proposeButton.click();
    }

    public void selectVotingType() {
        clickVotingType();
        selectConsensus();
    }

    public void selectMainTopic() {
        mainTopic.click();
    }

    public void enterMessageText(String message) {
        messageTextArea.sendKeys(message);
    }

    public void clickSendMessage() {
        sendMessageButton.click();
    }

    public void sendMessage(String message) {
        enterMessageText(message);
        clickSendMessage();
    }

    public void selectSubtopic() {
        subtopic.click();
    }
}
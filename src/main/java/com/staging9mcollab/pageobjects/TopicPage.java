package com.staging9mcollab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Page object class for Topic page
 *
 * @author Zoran Dragovic
 */
public class TopicPage {
    //Topic page object elements
    @FindBy(how = How.XPATH, using = "//button[@tooltip='Create a new topic']")
    public WebElement createSubtopicButton;

    @FindBy(how = How.XPATH, using = "//span[text()='Create Conclusion']/ancestor::button[@type='button']")
    public WebElement createConclusionButton;

    @FindBy(how = How.XPATH, using = "//span[text()='View conclusion']/ancestor::button[@type='button']")
    public WebElement viewConclusionButton;

    @FindBy(how = How.XPATH, using = "//button[text()=' Edit Group']/ancestor::div[@class='button-wrap ng-scope']")
    public WebElement editGroupButton;

    @FindBy(how = How.ID, using = "tinymce")
    public WebElement conclusionTextArea;

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

    @FindBy(how = How.XPATH, using = "//textarea[@placeholder='Type a message...']")
    public WebElement messageTextArea;

    @FindBy(how = How.XPATH, using = "//button[@ng-click='vm.sendMessage()']")
    public WebElement sendMessageButton;

    public void clickCreateSubtopic() {
        createSubtopicButton.click();
    }

    public void clickCreateConclusion() {
        createConclusionButton.click();
    }

    public void enterConclusionName(String conclusionName) {
        conclusionTextArea.clear();
        conclusionTextArea.sendKeys(conclusionName);
    }

    public void clickVotingType() {
        votingTypeUnselected.click();
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

    public void enterMessageText(String message) {
        messageTextArea.sendKeys(message);
    }

    public void clickSendMessage() {
        sendMessageButton.click();
    }

    /**
     * <p>
     * This method sends the message
     * </p>
     *
     * @param message message that will be sent
     */
    public void sendMessage(String message) {
        enterMessageText(message);
        clickSendMessage();
    }
}
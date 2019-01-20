package com.staging9mcollab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TopicPage {
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
}
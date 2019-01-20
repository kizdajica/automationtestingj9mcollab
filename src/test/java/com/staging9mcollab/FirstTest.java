package com.staging9mcollab;

import basetest.BaseTest;
import com.staging9mcollab.pageobjects.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.staging9mcollab.helpers.PropertyReader.getProperty;
import static com.staging9mcollab.helpers.WaitHelpers.waitUntilElementIsClickable;
import static com.staging9mcollab.helpers.WaitHelpers.waitUntilElementIsVisible;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CreateGroupPage createGroupPage;
    GroupViewPage groupViewPage;
    TopicPage topicPage;

    By createButton = By.xpath("/html/body/div/div[4]/div/div[1]/div[3]/div/div/div/button[1]");
    By iframe = By.cssSelector("iframe[id$='_ifr']");

    @BeforeEach
    public void initializePageObjects() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        createGroupPage = PageFactory.initElements(driver, CreateGroupPage.class);
        groupViewPage = PageFactory.initElements(driver, GroupViewPage.class);
        topicPage = PageFactory.initElements(driver, TopicPage.class);
    }

    @Test
    public void login() throws IOException {
        waitUntilElementIsVisible(driver, By.id("kc-login"), 10);
        loginPage.login(getProperty("username"), getProperty("password"));

        waitUntilElementIsClickable(driver, dashboardPage.createAGroupButton, 10);
        assertEquals("9mCollab", driver.getTitle());
        dashboardPage.clickCreateGroup();

        waitUntilElementIsVisible(driver, createButton, 10);
        createGroupPage.createGroup(getProperty("mainTopic"), getProperty("description"));

        waitUntilElementIsClickable(driver, groupViewPage.openButton, 10);
        groupViewPage.clickOpen();

        waitUntilElementIsClickable(driver, topicPage.createConclusionButton, 10);
        topicPage.clickCreateConclusion();

        waitUntilElementIsVisible(driver, iframe, 10);
        switchToIframe(iframe);
        topicPage.enterConclusionName(getProperty("conclusionName"));
        exitIframe();
        topicPage.selectVotingType();
        waitUntilElementIsClickable(driver, topicPage.proposeButton, 10);
        topicPage.clickPropose();

        waitUntilElementIsClickable(driver, topicPage.viewConclusionButton, 10);
        assertTrue(topicPage.viewConclusionButton.isDisplayed());
    }
}
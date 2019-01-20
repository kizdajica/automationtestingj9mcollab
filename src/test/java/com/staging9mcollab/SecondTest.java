package com.staging9mcollab;

import basetest.BaseTest;
import com.staging9mcollab.pageobjects.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.staging9mcollab.helpers.PropertyReader.getProperty;
import static com.staging9mcollab.helpers.WaitHelpers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SecondTest extends BaseTest {
    LoginPage loginPage;
    NavigationPage navigationPage;
    MyGroupsPage myGroupsPage;
    TopicPage topicPage;
    GroupViewPage groupViewPage;
    CreateTopicPage createTopicPage;
    DashboardPage dashboardPage;

    @BeforeEach
    public void initializePageObjects() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        navigationPage = PageFactory.initElements(driver, NavigationPage.class);
        myGroupsPage = PageFactory.initElements(driver, MyGroupsPage.class);
        topicPage = PageFactory.initElements(driver, TopicPage.class);
        groupViewPage = PageFactory.initElements(driver, GroupViewPage.class);
        createTopicPage = PageFactory.initElements(driver, CreateTopicPage.class);
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
    }

    @Test
    public void secondTest() throws IOException {
        waitUntilElementIsVisible(driver, By.id("kc-login"), 10);
        loginPage.login(getProperty("username1"), getProperty("password"));

        waitUntilElementIsClickable(driver, navigationPage.createAGroupButton, 1);
        assertEquals("9mCollab", driver.getTitle());
        navigationPage.clickMyGroups();

        waitUntilElementIsClickable(driver, myGroupsPage.existingTopicName, 10);
        myGroupsPage.clickExistingTopic();

        waitAditional(1);
        topicPage.clickCreateSubtopic();

        waitUntilElementIsClickable(driver, createTopicPage.subtopicName, 10);
        createTopicPage.createSubtopic(getProperty("subtopicName"));

        waitAditional(2);
        topicPage.selectMainTopic();
        waitAditional(1);
        topicPage.sendMessage(getProperty("topicMessage"));
        topicPage.selectSubtopic();
        waitAditional(1);
        topicPage.sendMessage(getProperty("subtopicMessage"));

        navigationPage.logOut();

        waitUntilElementIsVisible(driver, By.id("kc-login"), 10);
        loginPage.login(getProperty("username2"), getProperty("password"));

        waitUntilElementIsClickable(driver, dashboardPage.mainTopicMessage, 10);
        assertEquals(getProperty("topicMessage"), dashboardPage.mainTopicMessage.getText());
        assertEquals(getProperty("subtopicMessage"), dashboardPage.subTopicMessage.getText());
    }
}
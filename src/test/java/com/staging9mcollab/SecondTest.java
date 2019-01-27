package com.staging9mcollab;

import basetest.BaseTest;
import com.staging9mcollab.pageobjects.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

import static com.staging9mcollab.helpers.PropertyReader.getProperty;
import static com.staging9mcollab.helpers.Randomizer.randomizeValue;
import static com.staging9mcollab.helpers.WaitHelpers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Class that contains second test
 *
 * @author Zoran Dragovic
 */
public class SecondTest extends BaseTest {
    //Declaration of page objects
    LoginPage loginPage;
    NavigationPage navigationPage;
    MyGroupsPage myGroupsPage;
    TopicPage topicPage;
    GroupViewPage groupViewPage;
    CreateTopicPage createTopicPage;
    DashboardPage dashboardPage;

    /**
     * <p>
     * This method initializes page objects.
     * The method is run before each test in SecondTest class
     * </p>
     */
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

    /**
     * <p>
     * This is the second test
     * </p>
     */
    @Test
    public void secondTest() throws IOException {
        //3. Login into application
        waitUntilElementIsVisible(driver, By.id("kc-login"), 10);
        loginPage.login(getProperty("username1"), getProperty("password"));

        //4. Go to main topic of the created group
        waitUntilElementIsClickable(driver, navigationPage.createGroupButton, 10);
        assertEquals("9mCollab", driver.getTitle());
        navigationPage.clickMyGroups();

        waitUntilElementIsClickable(driver, myGroupsPage.editButton, 10);
        driver.findElement(By.xpath("//span[text()='" + getProperty("manualTopic") + "']/ancestor::td[@class='name']")).click();

        //5. Create a subtopic
        waitUntilElementIsClickable(driver, topicPage.createSubtopicButton, 10);
        driver.findElement(By.xpath("//div[text()=' " + getProperty("manualTopic") + "']/ancestor::div[@class='center']")).click();
        waitAditional(1);
        topicPage.clickCreateSubtopic();

        waitUntilElementIsClickable(driver, createTopicPage.subtopicNameInput, 10);
        String subtopicName = randomizeValue(getProperty("subtopic"));
        createTopicPage.createSubtopic(subtopicName);

        //6. Send a message to both topics as user1
        waitAditional(2);
        topicPage.sendMessage(getProperty("subtopicMessage"));
        driver.findElement(By.xpath("//div[text()=' " + getProperty("manualTopic") + "']/ancestor::div[@class='center']")).click();
        waitAditional(1);
        topicPage.sendMessage(getProperty("topicMessage"));

        //7. Check messages as user2
        navigationPage.logOut();

        waitUntilElementIsVisible(driver, By.id("kc-login"), 10);
        loginPage.login(getProperty("username2"), getProperty("password"));

        //Assert that both messages are successfully sent
        waitUntilElementIsClickable(driver, dashboardPage.mainTopicMessage, 10);
        assertEquals(getProperty("topicMessage"), dashboardPage.mainTopicMessage.getText());
        assertEquals(getProperty("subtopicMessage"), dashboardPage.subTopicMessage.getText());
    }
}
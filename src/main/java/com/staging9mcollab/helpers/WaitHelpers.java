package com.staging9mcollab.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Helper class that defines different waits
 *
 * @author Zoran Dragovic
 */
public class WaitHelpers {

    /**
     * <p>
     * This method waits for selected element to be present on the page
     * </p>
     *
     * @param driver  instance of WebDriver
     * @param locator locator of selected element in By format
     * @param seconds max wait time in seconds if element is not found on the page
     * @return Boolean value
     */
    public static Boolean waitUntilElementIsPresent(WebDriver driver, By locator, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * <p>
     * This method waits for selected element to be visible on the page
     * </p>
     *
     * @param driver  instance of WebDriver
     * @param locator locator of selected element in By format
     * @param seconds max wait time in seconds if element is not found on the page
     * @return Boolean value
     */
    public static Boolean waitUntilElementIsVisible(WebDriver driver, By locator, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * <p>
     * This method waits for selected element to be clickable on the page
     * </p>
     *
     * @param driver  instance of WebDriver
     * @param element Webelement we are waiting for
     * @param seconds max wait time in seconds if element is not found on the page
     * @return Boolean value
     */
    public static Boolean waitUntilElementIsClickable(WebDriver driver, WebElement element, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * <p>
     * This method waits for given amount of seconds
     * </p>
     * @param seconds number of seconds to wait
     */
    public static void waitAditional(double seconds) {
        if (seconds > 0) {
            int milliseconds = (int) (seconds * 1000);

            try {
                Thread.sleep(milliseconds);
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                throw new WebDriverException();
            }
        }
    }
}
package com.staging9mcollab.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelpers {

    public static Boolean waitUntilElementIsPresent(WebDriver driver, By locator, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Boolean waitUntilElementIsVisible(WebDriver driver, By locator, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static Boolean waitUntilElementIsClickable(WebDriver driver, WebElement element, long seconds) {
        WebDriverWait wait = new WebDriverWait(driver, seconds);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

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
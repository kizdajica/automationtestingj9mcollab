package com.staging9mcollab.baseclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * This is the Base Test class that manipulates with the driver
 *
 * @author Zoran Dragovic
 */
public class BaseTest {
    private WebDriver driver;

    /**
     * This method initializes the driver and navigates to AUT
     */
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromeDriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationtesting.staging-9mcollab.com");
    }

    /**
     * This method closes the driver
     */
    public void tearDown() {
        driver.quit();
    }
}

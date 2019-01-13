package com.staging9mcollab.baseclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static com.staging9mcollab.helpers.PropertyReader.getProperty;

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
    public void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/driver/chromeDriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getProperty("url"));
    }

    /**
     * This method closes the driver
     */
    public void tearDown() {
        driver.quit();
    }
}

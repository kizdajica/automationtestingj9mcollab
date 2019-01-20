package basetest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static com.staging9mcollab.helpers.PropertyReader.getProperty;

/**
 * This is the Base Test class that manipulates with the driver
 *
 * @author Zoran Dragovic
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver;

    /**
     * This method initializes the driver and navigates to AUT
     */
    @BeforeAll
    public void setUp() throws IOException {
        System.setProperty(getProperty("key"), getProperty("value"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getProperty("url"));
    }

    /**
     * This method closes the driver
     */
    @AfterAll
    public void tearDown() {
        driver.quit();
    }

    protected void switchToIframe(By iframe) {
        driver.switchTo().frame(driver.findElement(iframe));
    }

    protected void exitIframe() {
        driver.switchTo().defaultContent();
    }
}
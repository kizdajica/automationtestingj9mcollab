package basetest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static com.staging9mcollab.helpers.PropertyReader.getProperty;

/**
 * This is the Base Test class that manipulates with the driver and contains common methods
 *
 * @author Zoran Dragovic
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {
    protected WebDriver driver;
    protected ExtentHtmlReporter html;
    protected ExtentReports extent;

    /**
     * <p>
     * This method initializes the driver and navigates to AUT.
     * It also performs setup for report creation.
     * This method is run once before all tests in test class
     * </p>
     */
    @BeforeAll
    public void setUp() throws IOException {
        html = new ExtentHtmlReporter(getProperty("extentReportPath"));
        extent = new ExtentReports();
        extent.attachReporter(html);
        extent.createTest(getClass().getName());

        System.setProperty(getProperty("key"), getProperty("value"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(getProperty("url"));
    }

    /**
     * <p>
     * This method closes the driver and creates the report.
     * This method is run after all tests in test class
     * </p>
     */
    @AfterAll
    public void tearDown() {
        extent.flush();
        driver.quit();
    }

    /**
     * <p>
     * This method switches to iframe content
     * </p>
     *
     * @param iframe iframe locator in By format
     */
    protected void switchToIframe(By iframe) {
        driver.switchTo().frame(driver.findElement(iframe));
    }

    /**
     * <p>
     * This method exits from iframe to default content
     * </p>
     */
    protected void exitIframe() {
        driver.switchTo().defaultContent();
    }
}
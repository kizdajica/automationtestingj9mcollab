package basetest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
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
    private ExtentReports extent;

    /**
     * <p>
     * This method initializes the driver and navigates to AUT.
     * It also performs setup for report creation.
     * This method is run once before all tests in test class
     * </p>
     */
    @BeforeAll
    public void setUp() throws IOException {
        ExtentHtmlReporter html = new ExtentHtmlReporter("src/test/output/extentReport/" + getClass().getSimpleName() + "Report.html");
        html.config().setReportName(getClass().getSimpleName() + " Selenium Automation Report");
        html.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(html);
        extent.setSystemInfo("Test creator", "Zoran Dragovic");
        extent.setSystemInfo("Browser", "Chrome");
        extent.createTest(getClass().getSimpleName());

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
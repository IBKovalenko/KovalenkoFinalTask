package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.BasePage;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BaseTest {


    @BeforeClass
    public synchronized void setUp() {
        String browser = System.getProperty("browser");

        WebDriver driver;

        if (browser == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else {
            switch (browser) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                default:
                    throw new IllegalStateException("Wrong browser");
            }
        }
        log.info("Opening main page");
        driver.get("https://demo.prestashop.com/");
        driver.manage().window().maximize();
        BasePage.setThreadLocalDriver(driver);
       // driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.id("loadingMessage")));

        driver.switchTo().frame("framelive");
        new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingMessage")));

    }

    @AfterClass
    public void quit() {
        log.info("Closing the browser");
        if (BasePage.getDriver() != null) {
            BasePage.getDriver().quit();
        }
        BasePage.getThreadLocalDriver().remove();
    }
}
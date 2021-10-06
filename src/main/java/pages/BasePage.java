package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

    private static ThreadLocal<WebDriver> THREAD_LOCAL_DRIVER = new ThreadLocal<>();

    public static void setThreadLocalDriver(WebDriver driver) {
        THREAD_LOCAL_DRIVER.set(driver);
    }

    public static ThreadLocal<WebDriver> getThreadLocalDriver() {
        return THREAD_LOCAL_DRIVER;
    }

    public static WebDriver getDriver() {
        return THREAD_LOCAL_DRIVER.get();
    }

    protected WebElement waitUntilVisible(By locator, int seconds) {
        return new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected Boolean waitUntilInvisible(By locator, int seconds) {
        return new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected WebElement waitUntilClickable(By locator, int seconds) {
        return new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.elementToBeClickable(locator));
    }
}
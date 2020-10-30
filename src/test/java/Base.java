import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
/**
 * Created by ryddmo on 2020-06-17.
 */
public class Base {
    public WebDriver driver;
    public Base(WebDriver driver) { this.driver = driver; }
    public void goTo(String url) {
        if (url.contains("http")) {
            driver.get(url);
        } else {
            String baseUrl = "";
            driver.get(baseUrl + url);
        }
    }
    public WebElement find(By locator) { return driver.findElement(locator); }
    public List<WebElement> findElements(By locator) { return driver.findElements(locator); }
    public void click(By locator) { find(locator).click(); }
    public void type(String inputText, By locator) {
        find(locator).sendKeys(inputText);
    }
    public void submit(By locator) {
        find(locator).submit();
    }
    public String getText(By locator) {
        return find(locator).getText();
    }
    public Boolean isDisplayed(By locator) {
        try {
            return find(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException exception) {
            return false;
        }
    }
    public Boolean waitForIsDisplayed(By locator, Integer... timeout) {
        try {
            waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                    (timeout.length > 0 ? timeout[0] : null));
        } catch (org.openqa.selenium.TimeoutException exception) {
            return false;
        }
        return true;
    }
    private void waitFor(ExpectedCondition<WebElement> condition, Integer timeout) {
        timeout = timeout != null ? timeout : 10;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(condition);
    }
    public WebDriver getDriver() {
        return driver;
    }
}
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HandelDriver {
    WebDriver driver;

    public WebDriver getDriver(String inDriver){
        if (inDriver.toUpperCase().equals("CHROME")){
            System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
            driver = new ChromeDriver();


        } else {
            System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\gecko026\\geckodriver.exe");
            DesiredCapabilities dc = DesiredCapabilities.firefox();
            dc.setCapability("marionette", true);
            driver = new FirefoxDriver();
        }
        return driver;
    }

}
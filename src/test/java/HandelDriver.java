import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class HandelDriver {
    WebDriver driver;

    public WebDriver getDriver(String inDriver){
        if (inDriver.toUpperCase().equals("CHROME")){
            System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
            driver = new ChromeDriver();


        } else {
            //WebDriverManager.edgedriver().setup();
            //driver = new EdgeDriver();
            //OLD - WORKING
            System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
            //DesiredCapabilities dc = EdgeOptions.();
            //dc.setCapability("marionette", true);
            driver = new EdgeDriver();
        }
        return driver;
    }

}




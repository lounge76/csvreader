import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class values_test {

    static WebDriver driver;
    static String text;

    @BeforeTest
    public void setup() throws Exception {
        driver = new HandelDriver().getDriver("CHROME");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://chercher.tech/selenium-webdriver-sample");
        GetText();

    }


    @Test (priority = 100)
     public void GetText() throws IOException {
        // fetches text from the element and stores it in text
        String text = driver.findElement(By.xpath("//li[@class='breadcrumb-item active update']")).getText();
        System.out.println("Text String is : "+ text);
    }


    @Test (priority = 101)
    public void PasteText() throws IOException {
        driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]")).sendKeys(text);
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
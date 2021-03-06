import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Button_test {

    //Provide CSV file path. It Is In c: Drive..
    String CSV_PATH="./Excel/Detail.csv";

    static WebDriver driver;


    @BeforeTest
    public void setup() throws Exception {
        driver = new HandelDriver().getDriver("CHROME");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://test.rubywatir.com/radios.php");


    }

    @Test (priority = 53)

     public void Click_buttons53() throws IOException {
        WebElement radioId = driver.findElement(By.id("radioId"));

        radioId.click();
        System.out.println(" 53 Radio Button with ID Selected");
    }

    @Test (priority = 52)
    public void Verify_button_state52() throws IOException {

        /**
         * Validate Radio button using isSelected() method
         */

        WebElement radioElement = driver.findElement(By.id("radioId"));
        boolean selectState = radioElement.isSelected();

        //performing click operation only if element is not selected
        if (selectState == false) {
            radioElement.click();
        }
    }

    @Test (priority = 51)
    public void Verify_button_displayed51() throws IOException {
        /**
         * Validate Radio button using isDisplayed() method
         */

        WebElement radioElement = driver.findElement(By.id("radioId"));
        boolean selectState = radioElement.isDisplayed();

//performing click operation only if element is not selected
        if (selectState == false) {
            radioElement.click();
        }
    }



        @AfterTest
    public void afterTest() {
        System.out.println("after 54 Button: Driver close");
        driver.close();
    }

}
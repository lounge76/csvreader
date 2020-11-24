import com.opencsv.CSVReader;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CSVRead {

    //Provide CSV file path. It Is In c: Drive..
    String CSV_PATH="./Excel/Detail.csv";

    static WebDriver driver;


    @BeforeTest
    public void setup() throws Exception {
        driver = new HandelDriver().getDriver("CHROME");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.get("http://only-testing-blog.blogspot.com/2014/05/form.html");


    }

    @Test (priority = 4)
    public void Syns_texten4() throws IOException {
        driver.get("http://only-testing-blog.blogspot.com/2014/05/form.html");
        if (driver.findElement(By.xpath("//a[contains(.,'Only Testing')]")).isDisplayed()) {
            System.out.println("Element is Visible");
        } else {
            System.out.println("Element is InVisible");

        }

    }

    @Test  (priority = 2)
    public void csvDataRead2() throws IOException {
        driver.get("http://only-testing-blog.blogspot.com/2014/05/form.html");

        CSVReader reader = new CSVReader(new FileReader(CSV_PATH));
        String [] csvCell;
        //while loop will be executed till the last line In CSV-.
        while ((csvCell = reader.readNext()) != null) {
            String FName = csvCell[0];
            String LName = csvCell[1];
            String Email = csvCell[2];
            String Mob = csvCell[3];
            String company = csvCell[4];
            driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys(FName);
            driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys(LName);
            driver.findElement(By.xpath("//input[@name='EmailID']")).sendKeys(Email);
            driver.findElement(By.xpath("//input[@name='MobNo']")).sendKeys(Mob);
            driver.findElement(By.xpath("//input[@name='Company']")).sendKeys(company);
            driver.findElement(By.xpath("//input[@value='Submit']")).click();
            driver.switchTo().alert().accept();
        }
    }

    @Test (priority = 3)

    public void Screenshot3() throws IOException {
        driver.get("http://only-testing-blog.blogspot.com/2014/05/form.html");

        Screenshot screenshot = new AShot().takeScreenshot(driver);
        ImageIO.write(screenshot.getImage(), "png", new File("./Screenshots/screenshot_"+System.currentTimeMillis()+".png"));
    }


    @Test  (priority = 1)
    public void Click_buttons1() throws IOException {
        driver.get("http://test.rubywatir.com/radios.php");
        WebElement radioId = driver.findElement(By.id("radioId"));

        radioId.click();
        System.out.println("Radio Button with ID Selected");
    }

    @Test  (priority = 7)
    public void AfterTest_7() throws IOException {
        System.out.println("After test7 : Driver close");
        driver.close();
    }



    @AfterTest
    public void afterTest() {
        //System.out.println("After test7 : Driver close");
        //driver.close();
    }

}
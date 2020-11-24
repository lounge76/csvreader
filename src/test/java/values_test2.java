import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class values_test2 {

    static WebDriver driver;
    static String text;

    @BeforeTest
    public void setup() throws Exception {
        driver = new HandelDriver().getDriver("CHROME");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.get("https://chercher.tech/selenium-webdriver-sample");
        GetText();
    }

    public void GetText() throws IOException {
        driver.get("https://chercher.tech/selenium-webdriver-sample");
        text = driver.findElement(By.xpath("//li[@class='breadcrumb-item active update']")).getText();
        System.out.println("Text String is : "+ text);
    }

    @Test (priority = 1)
    public void CanPasteTextInFirstEmailField() throws IOException {
        driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
        driver.findElement(By.xpath("//*[@id=\"at-cv-lightbox-button-holder\"]/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"user-message\"]")).sendKeys(text);
    }

    @Test (priority = 2)
    public void CanPasteTextInSecondEmailField() throws IOException {
        driver.findElement(By.xpath("//input[@id=\"exampleInputPassword1\"]")).sendKeys(text);
    }

    @Test (priority = 3)
    public void IsEmailFieldDispalyed() throws IOException {
        if (driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]")).isDisplayed()) {
            System.out.println("Element is Visible");
        } else {
            System.out.println("Element is InVisible");
        }
    }

    @Test (priority = 4)
            public void IsEmailFieldDispalyed_2() {

        WebElement inputSearchField = driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]"));
        assertTrue(inputSearchField.isDisplayed());

        //assertEquals(driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]".getText(),"Sample Page")
    }


    @Test (priority = 5)
    public void IsEmailFieldContentCorrent() throws IOException  {


        //assertEquals(driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]".getText(),"Sample Page")

        //String text = driver.findElement(By.xpath("//*[@id="page-top"]/div[2]/div/ol/li[2]/text()")).getText();
        //assertTrue(text.contains("Sample Page"));

        //assertTrue(driver.findElement(By.xpath("//input[@id=\"exampleInputEmail1\"]")).getText().contains(""));
    }



    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
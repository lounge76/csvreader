import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class xlsxreadtest {

    //Provide CSV file path. It Is In c: Drive..
    //String CSV_PATH="./Excel/Detail.csv";

    static WebDriver driver;


    //@BeforeTest
    //public void setup() throws Exception {
    //    driver = new HandelDriver().getDriver("CHROME");
    //    driver.manage().window().maximize();
    //    driver.manage().deleteAllCookies();
    //    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.get("http://only-testing-blog.blogspot.com/2014/05/form.html");
    //}

    @Test (priority = 1)
    public void Syns_texten() throws IOException {
        driver.get("http://only-testing-blog.blogspot.com/2014/05/form.html");
        if (driver.findElement(By.xpath("//a[contains(.,'Only Testing')]")).isDisplayed()) {
            System.out.println("Element is Visible");
        } else {
            System.out.println("Element is InVisible");
        }
    }

    @Test (priority = 2)
    public void Read_xslx() throws IOException {
        //driver.get("http://only-testing-blog.blogspot.com/2014/05/form.html");

        FileInputStream fis = new FileInputStream("./files/Test.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);
        //I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
        //Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
        //Row row = sheet.getRow(0);
        //Cell cell = row.getCell(0);
        //System.out.println(cell);
        System.out.println(sheet.getRow(2).getCell(1).toString());
        System.out.println(sheet.getRow(3).getCell(1));
        System.out.println(sheet.getRow(4).getCell(1));
        System.out.println(sheet.getRow(5).getCell(1));
        System.out.println(sheet.getRow(6).getCell(1));

        String FName = sheet.getRow(2).getCell(1).toString();
        System.out.println(FName);

    }



    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest : Driver close");
        driver.close();
    }

}
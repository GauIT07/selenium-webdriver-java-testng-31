package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register");

        driver.manage().window().maximize();
    }
    // Selenium 1.x / 2.x / 3.x / 4.x
    // 8 loai Locator
    // Selenium Locator = HTML Attribute
    // ID/ Class/ Name = trung voi 3 attribute cua HTML
    // LinkText/ Partial LinkText: HTML (the a)
    // Tagname : HTML Tagname
    // XPath / CSS

    // Selenium 4.x - GUI
    // Class - Relative Locator
    // above/ bellow/ near/ leftOf/ rightOf

    // UI testing\
    // FUI: Functional UI

    // GUI: Graphic UI
    // Font/ Size/ Color/ Position/ Location/ Resolution/ Responsive/...

    // TestNG: Order testcase theo Alphabet (0-9, A-Z)
    // FirstName textbox - HTML Code
    // HTML Element: <tagname attribute_name1='attribute_value' attribute_name2='attribute_value'...>

    /*
    * <input type="text" data-val="true" data-val-required="First name is required." id="FirstName" name="FirstName">
    */

    @Test
    public void TC_01_ID(){
        driver.findElement(By.id("FirstName"));
    }

    @Test
    public void TC_02_Class(){
        driver.findElement(By.className("header-logo"));

    }

    @Test
    public void TC_03_Name(){
        driver.findElement(By.name("DateOfBirthDay"));
    }


    @Test
    public void TC_04_Tagname(){
        driver.findElements(By.tagName("input"));
    }


    @Test
    public void TC_05_LinkText(){
        driver.findElement(By.linkText("Shipping & returns"));
    }


    @Test
    public void TC_06_Partial_LinkText(){
        driver.findElement(By.partialLinkText("vendor account"));
    }


    @Test
    public void TC_07_CSS(){
        //CSS vs ID
        driver.findElement(By.cssSelector("input[id='LastName']"));
        driver.findElement(By.cssSelector("input#LastName"));
        driver.findElement(By.cssSelector("#LastName"));

        //CSS vs class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));

        //CSS vs Tagname
        driver.findElement(By.cssSelector("input"));

        //CSS vs LinkText
        driver.findElement(By.cssSelector("a[href='/customer/addresses']"));

        //CSS vs Partial LinkText
        // lấy giữa *
        driver.findElement(By.cssSelector("a[href*='address']"));
        // lấy đầu ^
        // driver.findElement(By.cssSelector("a[href^='address']"));
        // lấy đuôi $
        // driver.findElement(By.cssSelector("a[href$='address']"));
    }

    @Test
    public void TC_08_Xpath(){
        //Xpath vs ID
        driver.findElement(By.xpath("//input[@id='LastName']"));

        //Xpath vs class
        driver.findElement(By.xpath("//div[@class='page-title']"));

        //Xpath vs Tagname
        driver.findElement(By.xpath("//input"));

        //Xpath vs LinkText
        driver.findElement(By.xpath("//a[@href='/customer/addresses']"));
        driver.findElement(By.xpath("//a[text()='Addresses']"));

        //Xpath vs Partial LinkText
        driver.findElement(By.xpath("//a[contains(@href,'addresses')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Addresses')]"));

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}



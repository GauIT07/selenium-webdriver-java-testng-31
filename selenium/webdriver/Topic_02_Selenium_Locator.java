package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
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
        driver.findElement(By.("FirstName"))

    }

    @Test
    public void TC_02_Class(){

    }

    @Test
    public void TC_03_Name(){

    }


    @Test
    public void TC_04_LinkText(){

    }


    @Test
    public void TC_05_Partial_LinkText(){

    }


    @Test
    public void TC_06_Tagname(){

    }


    @Test
    public void TC_07_CSS(){

    }


    @Test
    public void TC_08_Xpath(){

    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}



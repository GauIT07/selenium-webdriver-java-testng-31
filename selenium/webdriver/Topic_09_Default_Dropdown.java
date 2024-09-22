    package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_09_Default_Dropdown {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void TC_01_Default_Dropdown(){

        // 1. Xóa dữ liệu
        // 2. Nhập dữ liệu
        // 3. Verify
        // 4. Test tính năng Clear form

        // TextArea
        // Nhập dữ liệu xuống dòng thêm \n
        // Nhập dữ liệu tab khoảng cách thêm \t

        driver.get("https://demo.nopcommerce.com/register");

//        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("");
        driver.findElement(By.cssSelector("input#Email")).sendKeys(getEmailAddress());

//        Select dayDropdown = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
//        dayDropdown.selectByVisibleText("15");
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).selectByVisibleText("15");
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).selectByVisibleText("November");
        new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).selectByVisibleText("2023");


        driver.findElement(By.cssSelector("input#Password")).sendKeys("Auto@12345");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("Auto@12345");
    }

    @Test
    public void TC_02(){

    }

    @Test
    public void TC_03(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
    public String getEmailAddress() {
        // Random rand = new Random();
        // String emailAddress = "automation" + rand.nextInt(99999) + "@gmail.net"
        // return emailAddress;

        Random rand = new Random();
        return "Automation" + rand.nextInt(99999) + "@gmail.net";

        // return "automation" + new Random().nextInt(99999) + "@gmail.net";
    }

}



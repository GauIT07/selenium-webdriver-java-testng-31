package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_06_Web_Browser_Command_BT {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://live.techpanda.org/index.php");

    }
    @Test
    public void TC_01_Verify_URL(){
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://live.techpanda.org/index.php/customer/account/login/";
        Assert.assertEquals(currentUrl, expectedUrl);
    }

    @Test
    public void TC_02_Verify_Title(){
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        String currentTitle = driver.getTitle();
        String expectedTitle = "Customer Login";
        Assert.assertEquals(currentTitle, expectedTitle);

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        String currentTitle_2 = driver.getTitle();
        String expectedTitle_2 = "Create New Customer Account";
        Assert.assertEquals(currentTitle_2,expectedTitle_2);
    }

    @Test
    public void TC_03_Navigate_function(){
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "http://live.techpanda.org/index.php/customer/account/create/";
        Assert.assertEquals(currentUrl, expectedUrl);

        driver.navigate().back();
        String currentUrl_Back = driver.getCurrentUrl();
        String expectedUrl_Back = "http://live.techpanda.org/index.php/customer/account/login/";
        Assert.assertEquals(currentUrl_Back, expectedUrl_Back);

        driver.navigate().forward();
        String currentTitle_Forward = driver.getTitle();
        String expectedTitle_Forward = "Create New Customer Account";
        Assert.assertEquals(currentTitle_Forward,expectedTitle_Forward);
    }

    @Test
    public void TC_04_Get_Page_Source(){
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        String pageSource_Login = driver.getPageSource();
        String expectedText = "Login or Create an Account";
        Assert.assertTrue(pageSource_Login.contains(expectedText));

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        String pageSource_CreateAccount = driver.getPageSource();
        String expectedText_CreateAccount = "Create an Account";
        Assert.assertTrue(pageSource_CreateAccount.contains(expectedText_CreateAccount));

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}



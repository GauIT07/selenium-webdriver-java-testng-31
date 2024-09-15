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
        sleepInSecond(3);
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");

    }

    @Test
    public void TC_02_Verify_Title(){
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        Assert.assertEquals(driver.getTitle(), "Customer Login");

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
    }

    @Test
    public void TC_03_Navigate_function(){
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/create/");

        driver.navigate().back();
        sleepInSecond(1);
        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/customer/account/login/");

        driver.navigate().forward();
        sleepInSecond(1);
        Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
    }

    @Test
    public void TC_04_Get_Page_Source(){
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(1);
        // Kiểm tra có chứa thì dùng hàm Assert.assertTrue -> kết quả true:true -> pass
        Assert.assertTrue(driver.getPageSource().contains("Login or Create an Account"));

        driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
        sleepInSecond(1);
        // Kiểm tra có chứa thì dùng hàm Assert.assertTrue -> kết quả true:true -> pass
        Assert.assertTrue(driver.getPageSource().contains("Create an Account"));

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            // hàm thread.sleep của java -> bắt buộc phải có exception: InterruptedException
            // hàm thread.slepp có tham số truyền vào là milisecond
            Thread.sleep(timeInSecond*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}



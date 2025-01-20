package webdriver_31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_19_Popup {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Fix_Popup_In_DOM() throws InterruptedException {
        driver.get("https://ngoaingu24h.vn/");
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();
        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='Đăng nhập']/parent::div")).isDisplayed());

        driver.findElement(By.cssSelector("input[autocomplete='username']")).sendKeys("automationfc");
        driver.findElement(By.cssSelector("input[autocomplete='new-password']")).sendKeys("automationfc");

        driver.findElement(By.xpath("//div[@class='auth-form']//button[text()='Đăng nhập']")).click();
        Thread.sleep(1000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div#notistack-snackbar")).getText(),"Bạn đã nhập sai tài khoản hoặc mật khẩu!");

        driver.findElement(By.xpath("//h2[text()='Đăng nhập']/button")).click();
        Thread.sleep(1000);

        Assert.assertEquals(driver.findElements(By.xpath("//h2[text()='Đăng nhập']/parent::div")).size(), 0);
    }

    @Test
    public void TC_02() {

    }

    @Test
    public void TC_03() {

    }

    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}



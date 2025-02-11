package webdriver_31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_19_Random_Popup {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Random_Popup_Not_In_DOM() throws InterruptedException {
        driver.get("https://tiki.vn/");
        Thread.sleep(5000);

        By popup = By.cssSelector("div[class*=styles__PopupContent]");
        if (driver.findElements(popup).size()>0 &&  driver.findElements(popup).get(0).isDisplayed()){
            driver.findElement(By.cssSelector("div[class*=styles__PopupContent] img[alt='close-icon']")).click();
        }

        driver.findElement(By.cssSelector("div[data-view-id='header_header_account_container']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Xin chào,']/ancestor::div[contains(@class,'styles__Root')]")).isDisplayed());

    }

    @Test
    public void TC_02_DeHieu_Random_popup_In_DOM() throws InterruptedException {
        driver.get("https://dehieu.vn/");
        Thread.sleep(2000);

        By popup = By.cssSelector("div.modal-content");
        if (driver.findElement(popup).isDisplayed()){
            driver.findElement(By.cssSelector("div.modal-content button.close")).click();
        }

        driver.findElement(By.xpath("//a[text()=' Đăng nhập']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Đăng nhập']")).isDisplayed());

    }

    @Test
    public void TC_03() {

    }

    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}



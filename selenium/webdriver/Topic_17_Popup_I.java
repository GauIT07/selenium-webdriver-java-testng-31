package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_17_Popup_I {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Popup_In_DOM() {
        driver.get("https://ngoaingu24h.vn/");

        String text = "automationfc";
        driver.findElement(By.xpath("button.login_")).click();
        By loginPopup = By.xpath("//div[@role='dialog']");
        Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
        driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys(text);
        driver.findElement(By.xpath("//input[@autocomplete='new-password']")).sendKeys(text);
        driver.findElement(By.xpath("//div[@class='auth-form']//button[text()='Đăng nhập']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div#notistack-snackbar")).getText(), "Bạn đã nhập sai tài khoản hoặc mật khẩu!");
        driver.findElement(By.xpath("//h2[text()='Đăng nhập']/button")).click();
        Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
    }

    @Test
    public void TC_02_Popup_In_DOM() {
        driver.get("https://skills.kynaenglish.vn/dang-nhap");

        Assert.assertTrue(driver.findElement(By.cssSelector("div.k-popup-account-mb-content")).isDisplayed());
        driver.findElement(By.cssSelector("input#user-login")).sendKeys("automationfc@gmail.com");
        driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#btn-submit-login")).click();
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(), "Sai tên đăng nhập hoặc mật khẩu");

    }

    @Test
    public void TC_03_Popup_Not_In_DOM() {
        driver.get("https://tiki.vn/");

        driver.findElement(By.cssSelector("div#VIP_BUNDLE picture.webpimg-container img[alt='close-icon']")).click();
        driver.findElement(By.xpath("//span[text()='Tài khoản']/parent::div")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.ReactModal__Content")).isDisplayed());

        driver.findElement(By.cssSelector("p.login-with-email")).click();
        driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//input[@name='email']/parent::div/following-sibling::span[1]")).getText(), "Email không được để trống");
        Assert.assertEquals(driver.findElement(By.xpath("//input[@type='password']/parent::div/following-sibling::span")).getText(), "Mật khẩu không được để trống");

        driver.findElement(By.cssSelector("button.btn-close")).click();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.findElements(By.cssSelector("div.ReactModal__Content")).size(), 0);
        //Assert.assertFalse(driver.findElement(By.xpath("//button[@class='btn-close']/parent::div")).isDisplayed());


    }

    @Test
    public void TC_04_Popup_Not_In_DOM() {
        driver.get("https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0");

        driver.findElement(By.xpath("//div[@aria-label='Facebook']")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("form#login_popup_cta_form")).isDisplayed());

        driver.findElement(By.xpath("//div[@aria-label='Đóng']")).click();
        sleepInSecond(2);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.findElements(By.cssSelector("form#login_popup_cta_form")).size(),0);

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}



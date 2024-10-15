package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_11_Button {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void TC_01_Egov_Button(){
        driver.get("https://egov.danang.gov.vn/reg");

        WebElement registerButton = driver.findElement(By.cssSelector("input.egov-button"));

        // Kiểm tra button bị disable khi chưa click checkbox
        Assert.assertFalse(registerButton.isEnabled());

        driver.findElement(By.cssSelector("input#chinhSach")).click();

        // Kiểm tra button enable khi đã click checbox
        Assert.assertTrue(registerButton.isEnabled());

        // Lấy mã màu của button
        String registerBackgroundRGB = registerButton.getCssValue("background-color");
        System.out.println("Background color RGB: "+registerBackgroundRGB);

        // Convert từ kiểu String (mã RGB) qua kiểu Color
        Color registerBackgroundColour = Color.fromString(registerBackgroundRGB);

        // Convert qua kiểu Hexa
        String registerBackgroundHexa = registerBackgroundColour.asHex();
        System.out.println("Background color Hexa: "+registerBackgroundHexa);

        Assert.assertEquals(registerBackgroundHexa, "#ef5a00");

    }

    @Test
    public void TC_02_Fahasa_Button(){
        driver.get("https://www.fahasa.com/customer/account/create");

        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();

        WebElement loginButton = driver.findElement(By.cssSelector("button.fhs-btn-login"));

        Assert.assertFalse(loginButton.isEnabled());

        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(), "#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("test@yopmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");

        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(), "#c92127");

    }



    @AfterClass
    public void afterClass(){
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



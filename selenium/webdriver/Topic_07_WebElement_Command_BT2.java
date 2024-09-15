package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_07_WebElement_Command_BT2 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://live.techpanda.org/");

    }
    @Test
    public void TC_01_Login_with_empty_Email_and_Password(){
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(2);

        driver.findElement(By.cssSelector("button#send2")).click();
        // Email
        Assert.assertTrue(driver.findElement(By.cssSelector("div#advice-required-entry-email")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-email")).getText(), "This is a required field.");

        //Password
        Assert.assertTrue(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-required-entry-pass")).getText(), "This is a required field.");
    }

    @Test
    public void TC_02_Login_with_invalid_Email(){
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(2);

        driver.findElement(By.id("email")).sendKeys("12341234@12312.123123");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.cssSelector("button#send2")).click();
        // Email
        Assert.assertTrue(driver.findElement(By.cssSelector("div#advice-validate-email-email")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-email-email")).getText(), "Please enter a valid email address. For example johndoe@domain.com.");
    }

    @Test
    public void TC_03_Login_with_Password_less_than_6_characters(){
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(2);

        driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123");
        driver.findElement(By.cssSelector("button#send2")).click();
        // Email
        Assert.assertTrue(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.cssSelector("div#advice-validate-password-pass")).getText(), "Please enter 6 or more characters without leading or trailing spaces.");
    }

    @Test
    public void TC_04_Login_with_incorrect_Email_and_Password(){
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(2);

        driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123123123");
        driver.findElement(By.cssSelector("button#send2")).click();
        // Email
        Assert.assertTrue(driver.findElement(By.className("error-msg")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.className("error-msg")).getText(), "Invalid login or password.");

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




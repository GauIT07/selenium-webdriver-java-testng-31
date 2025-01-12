package webdriver_31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_15_Alert {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_JS_Alert() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.switchTo().alert().getText(), "I am a JS Alert");

        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked an alert successfully");

    }

    @Test
    public void TC_02_JS_Confirm() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.switchTo().alert().getText(), "I am a JS Confirm");

        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You clicked: Cancel");

    }

    @Test
    public void TC_03_JS_Prompt() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        Thread.sleep(2000);

        String text = "Automation testing";

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.switchTo().alert().getText(), "I am a JS prompt");

        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(), "You entered: " + text);
    }

    @Test
    public void TC_04_Authentication_Alert() throws InterruptedException {
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.example p")).getText(), "Congratulations! You must have the proper credentials.");
    }

    @Test
    public void TC_05_Authentication_Alert_II() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(2000);

        String username = "admin";
        String password = "admin";

        String url = driver.findElement(By.xpath("//li/a[text()='Basic Auth']")).getDomProperty("href");
        System.out.println(url);

        String[] array = url.split("//");

        System.out.println(array[0] + " " + array[1]);
        driver.get(array[0]+"//"+username+":"+password+"@"+array[1]);
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.example p")).getText(), "Congratulations! You must have the proper credentials.");
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}



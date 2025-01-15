package webdriver_31;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_18_Action_III {
    WebDriver driver;
    Actions action;


    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        action = new Actions(driver);

    }

    @Test
    public void TC_01_DragAndDrop_HTML4() throws InterruptedException {

    }

    @Test
    public void TC_02_DragAndDrop_HTML5() throws InterruptedException {

    }


    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}



package webdriver_31;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
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
        driver = new FirefoxDriver() ;
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        action = new Actions(driver);

    }

    @Test
    public void TC_01_Scroll() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        Thread.sleep(3000);

        By doubleClickButton = By.xpath("//button[text()='Double click me']");

        if (driver.toString().contains("Chrome") || driver.toString().contains("Edge")) {
            action.scrollToElement(driver.findElement(doubleClickButton)).perform();
        } else {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(doubleClickButton));
            Thread.sleep(2000);
        }

        action.doubleClick(driver.findElement(doubleClickButton))
                .pause(Duration.ofSeconds(2))
                .perform();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");

    }

    @Test
    public void TC_02_DragAndDrop_HTML4() throws InterruptedException {
        driver.get("https://automationfc.github.io/kendo-drag-drop/");

        WebElement sourceCircle = driver.findElement(By.cssSelector("div#draggable"));
        WebElement targetCircle = driver.findElement(By.cssSelector("div#droptarget"));

        Assert.assertEquals(targetCircle.getText(), "Drag the small circle here.");
        Thread.sleep(2000);

        action.dragAndDrop(sourceCircle, targetCircle).perform();
        Thread.sleep(2000);

        Assert.assertEquals(targetCircle.getText(), "You did great!");
        Assert.assertEquals(Color.fromString(targetCircle.getCssValue("background-color")).asHex().toUpperCase(), "#03A9F4");

    }

    @Test
    public void TC_03_DragAndDrop_HTML5() throws InterruptedException {

    }


    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}



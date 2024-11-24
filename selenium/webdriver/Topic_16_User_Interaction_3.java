package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_16_User_Interaction_3 {
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        action = new Actions(driver);
    }

    @Test
    public void TC_01_Drag_Drop_HTML4() {
        driver.get("https://automationfc.github.io/kendo-drag-drop/");

        WebElement sourceCirle = driver.findElement(By.cssSelector("div#draggable"));
        WebElement targetCirle = driver.findElement(By.cssSelector("div#droptarget"));

        action.dragAndDrop(sourceCirle, targetCirle).perform();

        Assert.assertEquals(targetCirle.getText(), "You did great!");

        Assert.assertEquals(Color.fromString(targetCirle.getCssValue("background-color")).asHex().toUpperCase(), "#03A9F4");

    }

    @Test
    public void TC_02_Drag_Drop_HTML5() {
        driver.get("https://automationfc.github.io/drag-drop-html5/");

        WebElement sourceSquare = driver.findElement(By.cssSelector("div#column-a"));
        WebElement targetSquare = driver.findElement(By.cssSelector("div#column-b"));

        action.dragAndDrop(sourceSquare, targetSquare).release().perform();
        sleepInSecond(2);


    }

    @Test
    public void TC_03() {

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



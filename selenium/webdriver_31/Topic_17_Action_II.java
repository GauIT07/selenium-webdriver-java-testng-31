package webdriver_31;

import org.bouncycastle.pqc.jcajce.provider.bike.BCBIKEPrivateKey;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_17_Action_II {
    WebDriver driver;
    Actions action;
    String osName = System.getProperty("os.name");
    Keys keys;

    @BeforeClass
    public void initialBrowser() {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        action = new Actions(driver);
        if (osName.startsWith("Windows")) {
            keys = Keys.CONTROL;
        } else {
            keys = Keys.COMMAND;
        }

    }

    @Test
    public void TC_01_ClickandHold() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-selectable/");
        Thread.sleep(2000);

        List<WebElement> allItem = driver.findElements(By.cssSelector("ol#selectable li"));

        action.clickAndHold(allItem.get(0))
                .clickAndHold(allItem.get(1))
                .clickAndHold(allItem.get(2))
                .clickAndHold(allItem.get(3))
                .release()
                .perform();
        Thread.sleep(3000);

        List<WebElement> allItemSelected = driver.findElements(By.cssSelector("ol#selectable li.ui-selected"));
        Assert.assertEquals(allItemSelected.size(), 4);

    }

    @Test
    public void TC_02_ClickandSelect() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-selectable/");
        Thread.sleep(2000);
        List<WebElement> allItem = driver.findElements(By.cssSelector("ol#selectable li"));


        action.keyDown(keys).perform();

        action.click(allItem.get(0))
                .click(allItem.get(2))
                .click(allItem.get(5))
                .click(allItem.get(10))
                .perform();
        Thread.sleep(3000);

        action.keyUp(keys).perform();

        List<WebElement> allItemSelected = driver.findElements(By.cssSelector("ol#selectable li.ui-selected"));
        Assert.assertEquals(allItemSelected.size(), 4);
    }

    @Test
    public void TC_03_DoubleClick() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");
        Thread.sleep(3000);

        By doubleClickButton = By.xpath("//button[text()='Double click me']");

        if (driver.toString().contains("Firefox")) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(doubleClickButton));
            Thread.sleep(2000);
        }

        action.doubleClick(driver.findElement(doubleClickButton))
                .pause(Duration.ofSeconds(2))
                .perform();

        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");

    }

    @Test
    public void TC_04_RightClick() throws InterruptedException {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
        Thread.sleep(1000);

        By rightClickMeButton = By.xpath("//p/span[text()='right click me']");

        action.contextClick(driver.findElement(rightClickMeButton)).perform();
        Thread.sleep(2000);

        Assert.assertTrue(driver.findElement(By.cssSelector("ul.context-menu-list")).isDisplayed());

        action.moveToElement(driver.findElement(By.xpath("//span[text()='Quit']"))).perform();
        Thread.sleep(1000);

        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Quit']/parent::li")).getAttribute("class").contains("context-menu-visible"));
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Quit']/parent::li")).getAttribute("class").contains("context-menu-hover"));

        action.click(driver.findElement(By.xpath("//span[text()='Quit']"))).perform();
        Thread.sleep(1000);

        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        Assert.assertFalse(driver.findElement(By.cssSelector("ul.context-menu-list")).isDisplayed());
    }

    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}



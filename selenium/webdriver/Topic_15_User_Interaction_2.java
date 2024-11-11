package webdriver;

import org.openqa.selenium.*;
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

public class Topic_15_User_Interaction_2 {
    WebDriver driver;
    Actions action;
    String osName = System.getProperty("os.name");
    Keys keys;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        action = new Actions(driver);
//        if (osName.startsWith("Windows")){
//            keys = Keys.CONTROL;
//        } else {
//            keys = Keys.COMMAND;
//        }

        keys = osName.startsWith("Windows") ? Keys.CONTROL : Keys.COMMAND;
    }

    @Test
    public void TC_01_Click_And_Hold_Block() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allNumber = driver.findElements(By.cssSelector("ol#selectable>li"));
        Assert.assertEquals(allNumber.size(), 20);

        action.clickAndHold(allNumber.get(0)) // click chuột trái và giữ lại
                .moveToElement(allNumber.get(3)) // kéo tới vị trí thứ 4
                .release() // nhả chuột trái
                .perform(); // thực thi câu lệnh
        sleepInSecond(3);

        List<WebElement> allNumberSelected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(allNumberSelected.size(), 4);

    }

    @Test
    public void TC_02_Click_And_Hold_Random() {
        driver.get("https://automationfc.github.io/jquery-selectable/");

        List<WebElement> allNumber = driver.findElements(By.cssSelector("ol#selectable>li"));
        Assert.assertEquals(allNumber.size(), 20);

        // Nhấn phím Ctrl xuống (chưa nhả ra)
        action.keyDown(keys).perform();

        // Click vào từng phần tử để đóng khối
        action.click(allNumber.get(0))
                .click(allNumber.get(3))
                .click(allNumber.get(7))
                .click(allNumber.get(10))
                .click(allNumber.get(13))
                .click(allNumber.get(17))
                .pause(Duration.ofSeconds(3))
                .perform();

        // Nhả phím Control
        action.keyUp(keys).perform();

        List<WebElement> allNumberSelected = driver.findElements(By.cssSelector("ol#selectable>li.ui-selected"));
        Assert.assertEquals(allNumberSelected.size(), 6);
    }

    @Test
    public void TC_03_Double_Click() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,3700)");
        sleepInSecond(2);

        action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
        sleepInSecond(1);

        Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");
    }

    @Test
    public void TC_04_Right_Click() {
        driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");

        action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']"))).perform();

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



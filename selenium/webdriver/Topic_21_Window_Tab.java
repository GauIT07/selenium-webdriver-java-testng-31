package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Topic_21_Window_Tab {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01() {
        driver.get("https://automationfc.github.io/basic-form/");
        String basicFormID = driver.getWindowHandle();

        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());

        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        sleepInSecond(3);

        switchToWindowID(basicFormID);
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());


    }

    @Test
    public void TC_02() {
        driver.get("https://automationfc.github.io/basic-form/");

        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        sleepInSecond(2);

        driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
        sleepInSecond(2);

        switchToWindowTitle("Facebook - Đăng nhập hoặc đăng ký");

    }

    @Test
    public void TC_03() {
        driver.get("https://live.techpanda.org/index.php/");

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        sleepInSecond(2);

        driver.findElement(By.xpath("//a[@title='Sony Xperia']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")).getText(), "The product Sony Xperia has been added to comparison list.");
        sleepInSecond(2);

        driver.findElement(By.xpath("//a[@title='IPhone']/parent::h2/following-sibling::div[@class='actions']//a[@class='link-compare']")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")).getText(), "The product IPhone has been added to comparison list.");
        sleepInSecond(2);

        driver.findElement(By.cssSelector("button[title='Compare']")).click();
        sleepInSecond(2);

        switchToWindowTitle("Products Comparison List - Magento Commerce");
        driver.close();

        switchToWindowTitle("Mobile");
        sleepInSecond(2);

        driver.findElement(By.xpath("//a[text()='Clear All']")).click();
        sleepInSecond(2);

        driver.switchTo().alert().accept();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")).getText(), "The comparison list was cleared.");

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

    private void switchToWindowID(String basicFormID) {
        Set<String> allIDs = driver.getWindowHandles();

        for (String id : allIDs) {
            if (!id.equals(basicFormID)) {
                driver.switchTo().window(id);
                break;
            }
        }
    }

    private void switchToWindowTitle(String expectedTitle) {

        Set<String> allIDs = driver.getWindowHandles();

        for (String id : allIDs) {
            driver.switchTo().window(id);
            sleepInSecond(3);
            String actualTitle = driver.getTitle();
            if (actualTitle.equals(expectedTitle)) {
                break;
            }
        }
    }
}



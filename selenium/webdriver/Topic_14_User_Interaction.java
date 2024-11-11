package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_14_User_Interaction {
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
    public void TC_01_Hover() {
        driver.get("https://automationfc.github.io/jquery-tooltip/");

        WebElement ageTextbox = driver.findElement(By.cssSelector("input#age"));

        action.moveToElement(ageTextbox).perform();
        sleepInSecond(2);

        Assert.assertTrue(driver.findElement(By.cssSelector("div.ui-tooltip-content")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");
    }

    @Test
    public void TC_02_Hover_Myntra() {
        driver.get("https://www.myntra.com/");

        action.moveToElement(driver.findElement(By.xpath("//a[@class= 'desktop-main' and text()='Kids']"))).perform();

        action.click(driver.findElement(By.xpath("//a[@class='desktop-categoryName' and text()='Home & Bath']"))).perform();

        //driver.findElement(By.xpath("//a[@class='desktop-categoryName' and text()='Home & Bath']")).click();

        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='breadcrumbs-crumb']")).getText(), "Kids Home Bath");

    }

    @Test
    public void TC_03_Hover_Fahasa() {
        driver.get("https://www.fahasa.com/");

        action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();

        action.moveToElement(driver.findElement(By.xpath("//span[@class='menu-title' and text()='Sách Trong Nước']"))).perform();

        driver.findElement(By.xpath("//div[@class='fhs_menu_content fhs_column_left']//a[text()='Kỹ Năng Sống']")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//ol[@class='breadcrumb']//strong[text()='Kỹ năng sống']")).isDisplayed());
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



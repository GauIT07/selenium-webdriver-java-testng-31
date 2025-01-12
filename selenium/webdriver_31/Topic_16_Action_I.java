package webdriver_31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_16_Action_I {
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        action = new Actions(driver);
    }

    @Test
    public void TC_01_Hover() throws InterruptedException {
        driver.get("https://automationfc.github.io/jquery-tooltip/");
        Thread.sleep(2000);

        action.moveToElement(driver.findElement(By.cssSelector("input#age")))
                .perform();
        Thread.sleep(3000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");

    }

    @Test
    public void TC_02_Myntra() throws InterruptedException {
        driver.get("https://www.myntra.com/");
        Thread.sleep(2000);

        action.moveToElement(driver.findElement(By.cssSelector("nav.desktop-navbar a[data-group='kids']")))
                .pause(2000)
                .perform();
        action.click(driver.findElement(By.xpath("//div[@class='desktop-paneContent']//a[text()='Home & Bath']")))
                .perform();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.title-container h1")).getText(), "Kids Home Bath");

        //Assert.assertTrue(driver.findElement(By.cssSelector("div.breadcrumbs-base")).getText().contains(""));
    }

    @Test
    public void TC_03_Fahasa() throws InterruptedException {
        driver.get("https://www.fahasa.com/");
        action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu")))
                .pause(2000)
                .perform();
        action.moveToElement(driver.findElement(By.cssSelector("a[title='Sách Trong Nước']")))
                .perform();

        driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//a[text()='Kỹ Năng Sống']")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.fahasa.com/sach-trong-nuoc/tam-ly-ky-nang-song/ky-nang-song.html");

    }

    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}



package webdriver_31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_21_Window_Tab {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01() throws InterruptedException {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.getCurrentUrl();
        driver.getTitle();

        driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
        Thread.sleep(3000);

        String githubTab = driver.getWindowHandle();
        if (driver.getWindowHandle() != githubTab){
            driver.switchTo().window()
        }

        driver.getCurrentUrl();
        driver.getTitle();

        driver.findElement(By.cssSelector("textarea[name='q']")).sendKeys("Selenium WebDriver");
        Assert.assertEquals(driver.findElement(By.cssSelector("")),"");


    }

    @Test
    public void TC_02() {

    }

    @Test
    public void TC_03() {

    }

    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}



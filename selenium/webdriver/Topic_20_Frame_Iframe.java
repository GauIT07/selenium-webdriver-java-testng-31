package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_20_Frame_Iframe {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01() {
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");
        sleepInSecond(3);

        driver.findElement(By.cssSelector("div#imageTemplateContainer>img")).click();
        sleepInSecond(2);

        driver.switchTo().frame(driver.findElement(By.cssSelector("div#formTemplateContainer>iframe")));
        sleepInSecond(2);

        new Select(driver.findElement(By.xpath("//label[contains(text(),'Year')]/following-sibling::select"))).selectByVisibleText("Sophomore");
        sleepInSecond(1);

        new Select(driver.findElement(By.xpath("//label[contains(text(),'Residence')]/following-sibling::select"))).selectByVisibleText("South Dorm");
        sleepInSecond(1);

        driver.findElement(By.xpath("//label[text()='Male']")).click();
        sleepInSecond(1);

        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("nav.header--desktop-floater a[title='Log in']")).click();

        driver.findElement(By.cssSelector("button#login")).click();
        sleepInSecond(1);
        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(), "Username and password are both required.");

    }

    @Test
    public void TC_02() {
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        sleepInSecond(2);

        driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='login_page']")));

        driver.findElement(By.cssSelector("input[name='fldLoginUserId']")).sendKeys("Liverpool_Sala");
        sleepInSecond(2);

        driver.findElement(By.cssSelector("a.login-btn")).click();
        // driver.switchTo().parentFrame();
        driver.switchTo().defaultContent();
        sleepInSecond(15);

        Assert.assertTrue(driver.findElement(By.cssSelector("input#keyboard")).isDisplayed());

        driver.findElement(By.cssSelector("input#keyboard")).sendKeys("123456");
        sleepInSecond(3);
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



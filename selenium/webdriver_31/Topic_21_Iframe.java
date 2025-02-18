package webdriver_31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_21_Iframe {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01() {
        driver.get("https://toidicodedao.com/");

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[title='fb:page Facebook Social Plugin']")));

        Assert.assertEquals(driver.findElement(By.xpath("//a[@title='Tôi đi code dạo']/parent::div/following-sibling::div[contains(text(),'followers')]")).getText(),"403,795 followers");

    }

    @Test
    public void TC_02() throws InterruptedException {
        driver.get("https://www.formsite.com/templates/education/campus-safety-survey/");

        driver.findElement(By.cssSelector("div[role='dialog'] button.osano-cm-dialog__close")).click();

        driver.findElement(By.cssSelector("div#imageTemplateContainer")).click();
        Thread.sleep(2000);

        driver.switchTo().frame(driver.findElement(By.cssSelector("div#formTemplateContainer>iframe")));
        new Select(driver.findElement(By.xpath("//label[contains(text(),'Year')]/following-sibling::select"))).selectByVisibleText("Junior");
        new Select(driver.findElement(By.xpath("//label[contains(text(),'Residence')]/following-sibling::select"))).selectByVisibleText("East Dorm");

        driver.findElement(By.xpath("//span[contains(text(),'Gender')]/following-sibling::table//label[text()='Male']")).click();

        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("nav.header--desktop-floater a[title='Log in']")).click();

        driver.findElement(By.cssSelector("button#login")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div#message-error")).getText(),"Username and password are both required.");
    }

    @Test
    public void TC_03() {

    }

    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}



package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_06_Element_Command_BT {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://automationfc.github.io/basic-form/index.html");

    }

    @Test
    public void TC_01_Element_isDisplayed(){
        driver.findElement(By.xpath("//div[@class='container']/legend/following-sibling::label[contains(text(),'Email')]")).isDisplayed();
        driver.findElement(By.xpath("//div[@class='container']/legend/following-sibling::label[contains(text(),'Under 18')]")).isDisplayed();
        driver.findElement(By.xpath("//div[@class='container']/legend/following-sibling::label[contains(text(),'Education')]")).isDisplayed();

        driver.findElement(By.xpath("//div[@class='container']/legend/following-sibling::label[contains(text(),'User5')]")).isDisplayed();

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}



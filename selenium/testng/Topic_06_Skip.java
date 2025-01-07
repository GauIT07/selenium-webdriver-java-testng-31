package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_06_Skip {

    WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Run Before Class");
    }

    @Test
    public void TC_01(){
        System.out.println("TC 01");
    }

    @Test (enabled = false)
    public void TC_02(){
        System.out.println("TC 02");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        System.out.println("Run After Class");
    }
}
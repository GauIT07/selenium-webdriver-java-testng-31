package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_07_Description {

    WebDriver driver;


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        System.out.println("Run Before Class");
    }

    @Test (description = "Jira SAL#123 - Add Product CarCom MIC")
    public void TC_01(){
        System.out.println("TC 01");
    }

    @Test (description = "Jira SAL#124 - Add Product Health")
    public void TC_02(){
        System.out.println("TC 02");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
        System.out.println("Run After Class");
    }
}

package webdriver_31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_03_Xpath {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register");

    }
    @Test
    public void TC_01_Xpath(){
        // Your Personal Details
        driver.findElement(By.xpath("//label[@for='gender-male']"));
        driver.findElement(By.xpath("//label[@for='gender-female']"));
        driver.findElement(By.xpath("//input[@id='FirstName']"));
        driver.findElement(By.xpath("//input[@id='LastName']"));
        driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        driver.findElement(By.xpath("//input[@id='Email']"));


        // Company Details
        driver.findElement(By.xpath("//input[@id='Company']"));

        // Options
        driver.findElement(By.xpath("//input[@id='Newsletter']"));

        // Your Passwords
        driver.findElement(By.xpath("//input[@id='Password']"));
        driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));

        // Register button
        driver.findElement(By.xpath("//button[@id='register-button']"));

    }

    @Test
    public void TC_02(){

    }

    @Test
    public void TC_03(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}



package webdriver_31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_09_Textbox_TextArea_Exercise {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void TC_01() throws InterruptedException {
        driver.get("http://live.techpanda.org/");

        String firstName = "Test";
        String lastName = "Auto";
        String fullName = firstName + " " + lastName;
        String emailAddress = "autotest" + new Random().nextInt(99999) + "@gmail.net";
        String password = "Abc@1234";

        driver.findElement(By.xpath("//div[@class='footer']//a[text()='My Account']")).click();

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();

        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);

        driver.findElement(By.cssSelector("button[title='Register']")).click();

        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Thank you for registering with Main Website Store.");

        String contactInfoSuccess = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div")).getText();

        Assert.assertTrue(contactInfoSuccess.contains(fullName));
        Assert.assertTrue(contactInfoSuccess.contains(emailAddress));

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();

        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']")).click();

        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();

        driver.findElement(By.cssSelector("input[id='Quality 1_5']")).click();

        driver.findElement(By.cssSelector("textarea#review_field")).sendKeys("Abc \nAbc \nAbc");

        driver.findElement(By.cssSelector("input#summary_field")).sendKeys("Summary review");

        driver.findElement(By.cssSelector("input#nickname_field")).clear();
        driver.findElement(By.cssSelector("input#nickname_field")).sendKeys("Monkey");

        driver.findElement(By.cssSelector("button[title='Submit Review']")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(),"Your review has been accepted for moderation.");

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



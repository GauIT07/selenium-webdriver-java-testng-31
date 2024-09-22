package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_08_Textbox_TextArea_BT {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_TextArea_Textbox() {
        driver.get("http://live.techpanda.org/");
        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
        sleepInSecond(2);

        driver.findElement(By.cssSelector("a[title='Create an Account']")).click();
        sleepInSecond(2);

        // Register
        String firstName = "Automation", lastName = "FC", emailAddress = getEmailAddress(), password = "1122334455";
        String fullName = firstName + " " + lastName;

        driver.findElement(By.cssSelector("input#firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#lastname")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input#email_address")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#confirmation")).sendKeys(password);
        driver.findElement(By.cssSelector("button[title='Register']")).click();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Thank you for registering with Main Website Store.");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.welcome-msg strong")).getText(), "Hello, " + fullName + "!");

        String contactInfo = driver.findElement(By.xpath("//h3[text()='Contact Information']/parent::div/following-sibling::div/p")).getText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();
        driver.findElement(By.xpath("//a[text()='Samsung Galaxy']")).click();
        driver.findElement(By.xpath("//a[text()='Add Your Review']")).click();

        driver.findElement(By.cssSelector("input[id='Quality 1_5']")).click();
        driver.findElement(By.cssSelector("textarea#review_field")).sendKeys("Good application \nPretty easy to navigate.");
        driver.findElement(By.cssSelector("input#summary_field")).sendKeys("Best Phone");
        driver.findElement(By.cssSelector("input#nickname_field")).sendKeys("automnationfc");
        driver.findElement(By.cssSelector("button[title='Submit Review']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Your review has been accepted for moderation.']")).isDisplayed());

        // Logout
        driver.findElement(By.cssSelector("a.skip-account")).click();
        sleepInSecond(2);
        driver.findElement(By.cssSelector("a[title='Log Out']")).click();
        sleepInSecond(10);

        Assert.assertEquals(driver.getCurrentUrl(), "http://live.techpanda.org/index.php/");
    }

    @Test
    public void TC_02_TextArea_Textbox() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        sleepInSecond(2);

        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        sleepInSecond(2);
        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        sleepInSecond(2);

        String firstName = "Automation", middleName = "FC", lastName = "123";
        String userName = getUsename();
        String password = "Auto@12345";
        driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[name='middleName']")).sendKeys(middleName);
        driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(lastName);
        driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).sendKeys("12345");
        String employeeId = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value");
        driver.findElement(By.xpath("//p[text()='Create Login Details']/following-sibling::div//span")).click();
        sleepInSecond(2);
        driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).sendKeys(userName);
        driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input")).sendKeys(password);
        driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstName']")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='middleName']")).getAttribute("value"), middleName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastName']")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"), employeeId);

        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        sleepInSecond(2);

        driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/following-sibling::button")).click();
        sleepInSecond(2);

        String numberComment = "123456789";
        String comment = "Automation FC";
        driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).sendKeys(numberComment);
        driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).sendKeys(comment);
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        sleepInSecond(5);

        driver.findElement(By.cssSelector("i.bi-pencil-fill")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"), numberComment);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"), comment);
        sleepInSecond(2);

        driver.findElement(By.cssSelector("li.oxd-userdropdown")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        sleepInSecond(2);
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

    public String getEmailAddress() {
        // Random rand = new Random();
        // String emailAddress = "automation" + rand.nextInt(99999) + "@gmail.net"
        // return emailAddress;

        Random rand = new Random();
        return "Automation" + rand.nextInt(99999) + "@gmail.net";

        // return "automation" + new Random().nextInt(99999) + "@gmail.net";
    }

    public String getUsename() {
        // Random rand = new Random();
        // String emailAddress = "automation" + rand.nextInt(99999) + "@gmail.net"
        // return emailAddress;

        Random rand = new Random();
        return "Auto" + rand.nextInt(99999);

        // return "automation" + new Random().nextInt(99999) + "@gmail.net";
    }
}



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
        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Thank you for registering with Main Website Store.");

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

        Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg span")).getText(), "Your review has been accepted for moderation.");

    }

    @Test
    public void TC_02_OrangeHRM() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        String firstName = "Test " + new Random().nextInt(999);
        String lastName = "Auto " + new Random().nextInt(999);
        String userName = "Automation Testing " + new Random().nextInt(999);
        String password = "Auto@12345";
        String numberRandom = "555-666-777-888";
        String comment = "Automation \n Best tour";

        By firstNameTextbox = By.cssSelector("input[name='firstName']");
        By lastNameTextbox = By.cssSelector("input[name='lastName']");
        By employeeIdTextbox = By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input");

        By numberTextbox = By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input");
        By commentTextArea = By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea");


        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//span[text()='PIM']/parent::a")).click();

        driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
        Thread.sleep(2000);

        driver.findElement(firstNameTextbox).sendKeys(firstName);
        driver.findElement(lastNameTextbox).sendKeys(lastName);
        String employeeIdNumber = driver.findElement(employeeIdTextbox).getAttribute("value");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//p[text()='Create Login Details']/following-sibling::div//label")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input")).sendKeys(userName);
        driver.findElement(By.xpath("//label[text()='Password']/parent::div/following-sibling::div/input")).sendKeys(password);
        driver.findElement(By.xpath("//label[text()='Confirm Password']/parent::div/following-sibling::div/input")).sendKeys(password);

        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(firstNameTextbox).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(lastNameTextbox).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(employeeIdTextbox).getAttribute("value"), employeeIdNumber);

        Assert.assertTrue(driver.findElement(employeeIdTextbox).isEnabled());
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/following-sibling::button")).click();
        Thread.sleep(3000);

        driver.findElement(numberTextbox).sendKeys(numberRandom);
        driver.findElement(commentTextArea).sendKeys(comment);

        driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//i[@class='oxd-icon bi-pencil-fill']/parent::button")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(numberTextbox).getAttribute("value"), numberRandom);
        Assert.assertEquals(driver.findElement(commentTextArea).getAttribute("value"), comment);

        driver.findElement(By.cssSelector("p.oxd-userdropdown-name")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//span[text()='My Info']/parent::a")).click();
        Thread.sleep(5000);

        Assert.assertEquals(driver.findElement(firstNameTextbox).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(lastNameTextbox).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(employeeIdTextbox).getAttribute("value"), employeeIdNumber);
        Thread.sleep(1000);
        Assert.assertFalse(driver.findElement(employeeIdTextbox).isEnabled());


        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//i[@class='oxd-icon bi-pencil-fill']/parent::button")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.findElement(numberTextbox).getAttribute("value"), numberRandom);
        Assert.assertEquals(driver.findElement(commentTextArea).getAttribute("value"), comment);

        Assert.assertTrue(driver.findElement(numberTextbox).isEnabled());
        Assert.assertTrue(driver.findElement(commentTextArea).isEnabled());

    }

    @Test
    public void TC_03() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}



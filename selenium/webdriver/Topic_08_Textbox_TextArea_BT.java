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
        sleepInSecond(3);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"), numberComment);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"), comment);


        driver.findElement(By.cssSelector("li.oxd-userdropdown")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        sleepInSecond(2);

        driver.findElement(By.cssSelector("input[name='username']")).sendKeys(userName);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        sleepInSecond(2);

        driver.findElement(By.xpath("//span[text()='My Info']")).click();
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='firstName']")).getAttribute("value"), firstName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='middleName']")).getAttribute("value"), middleName);
        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='lastName']")).getAttribute("value"), lastName);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"), employeeId);

        driver.findElement(By.xpath("//a[text()='Immigration']")).click();
        sleepInSecond(2);

        driver.findElement(By.cssSelector("i.bi-pencil-fill")).click();
        sleepInSecond(3);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"), numberComment);
        Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"), comment);

    }


    @Test
    public void TC_03_TextArea_Textbox() {
        // Tạo tài khoản
        driver.get("https://demo.guru99.com");
        String emailAddress = getEmailAddress();
        driver.findElement(By.cssSelector("input[name='emailid']")).sendKeys(emailAddress);
        driver.findElement(By.cssSelector("input[name='btnLogin']")).click();

        // Lấy tài khoản UserID và password
        String userID = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
        String password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();

        // Login
        driver.get("https://demo.guru99.com/v4/");
        sleepInSecond(2);
        driver.findElement(By.cssSelector("input[name='uid']")).sendKeys(userID);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
        driver.findElement(By.cssSelector("input[name='btnLogin']")).click();
        sleepInSecond(2);
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.guru99.com/v4/manager/Managerhomepage.php");

        driver.findElement(By.xpath("//a[text()='New Customer']")).click();
        sleepInSecond(2);

        String customerName = "AutomationFC", dob = "2000-01-01", address = "Auto Street",
                city = "HCM City", state = "VN", pin = "123456", mobileNumber = getPhonenumber(),
                emailCustomer = getEmailAddress(), pass = "Auto@12345";

        driver.findElement(By.cssSelector("input[name='name']")).sendKeys(customerName);
        driver.findElement(By.cssSelector("input[value='m']")).click();
        driver.findElement(By.cssSelector("input#dob")).sendKeys(dob);
        driver.findElement(By.cssSelector("textarea[name='addr']")).sendKeys(address);
        driver.findElement(By.cssSelector("input[name='city']")).sendKeys(city);
        driver.findElement(By.cssSelector("input[name='state']")).sendKeys(state);
        driver.findElement(By.cssSelector("input[name='pinno']")).sendKeys(pin);
        driver.findElement(By.cssSelector("input[name='telephoneno']")).sendKeys(mobileNumber);
        driver.findElement(By.cssSelector("input[name='emailid']")).sendKeys(emailCustomer);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(pass);
        driver.findElement(By.cssSelector("input[name='sub']")).click();
        sleepInSecond(2);

        // verify CustomerID info
        String customerID = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText(), customerID);

        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText(), customerName);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText(), "male");
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText(), dob);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText(), address);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText(), city);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText(), state);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText(), pin);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText(), mobileNumber);
        Assert.assertEquals(driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText(), emailCustomer);

        driver.findElement(By.xpath("//a[text()='Edit Customer']")).click();
        sleepInSecond(2);

        driver.findElement(By.cssSelector("input[name='cusid']")).sendKeys(customerID);
        driver.findElement(By.cssSelector("input[name='AccSubmit']")).click();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(By.cssSelector("input[name='name']")).getAttribute("value"), customerName);
        Assert.assertEquals(driver.findElement(By.cssSelector("textarea[name='addr']")).getText(), address);

        String editAddress = "123 Street D7", editCity = "ThuDuc City", editState = "HCM City", editPin = "001001",
                editMobileNumber = getPhonenumber(), editEmailCustomer = getEmailAddress();
        driver.findElement(By.cssSelector("textarea[name='addr']")).clear();
        driver.findElement(By.cssSelector("textarea[name='addr']")).sendKeys(editAddress);
        driver.findElement(By.cssSelector("input[name='city']")).clear();
        driver.findElement(By.cssSelector("input[name='city']")).sendKeys(editCity);
        driver.findElement(By.cssSelector("input[name='state']")).clear();
        driver.findElement(By.cssSelector("input[name='state']")).sendKeys(editState);
        driver.findElement(By.cssSelector("input[name='pinno']")).clear();
        driver.findElement(By.cssSelector("input[name='pinno']")).sendKeys(editPin);
        driver.findElement(By.cssSelector("input[name='telephoneno']")).clear();
        driver.findElement(By.cssSelector("input[name='telephoneno']")).sendKeys(editMobileNumber);
        driver.findElement(By.cssSelector("input[name='emailid']")).clear();
        driver.findElement(By.cssSelector("input[name='emailid']")).sendKeys(editEmailCustomer);
        driver.findElement(By.cssSelector("input[name='sub']")).click();



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
        Random rand = new Random();
        return "Auto" + rand.nextInt(99999);
    }

    public String getPhonenumber() {
        Random rand = new Random();
        return "090" + rand.nextInt(1000000,9999999);
    }
}



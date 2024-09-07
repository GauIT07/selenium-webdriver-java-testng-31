package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Topic_04_Selenium_Locator_Baitap {
    WebDriver driver;

    @BeforeMethod
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
    }

    @Test
    public void TC_01_Register_with_empty_data() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.cssSelector("label#txtFirstname-error")).isDisplayed();
        driver.findElement(By.cssSelector("label#txtEmail-error")).isDisplayed();
        driver.findElement(By.cssSelector("label#txtCEmail-error")).isDisplayed();
        driver.findElement(By.cssSelector("label#txtPassword-error")).isDisplayed();
        driver.findElement(By.cssSelector("label#txtCPassword-error")).isDisplayed();
        driver.findElement(By.cssSelector("label#txtPhone-error")).isDisplayed();
    }

    @Test
    public void TC_02_Register_with_invalid_Email() {
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("AutomationFC");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("123@456@789");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("123@456@789");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("112233");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("112233");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0901001001");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String email_error_message = driver.findElement(By.cssSelector("label#txtEmail-error")).getText();
        Assert.assertEquals(email_error_message, "Vui lòng nhập email hợp lệ");
        String cemail_error_message = driver.findElement(By.cssSelector("label#txtCEmail-error")).getText();
        Assert.assertEquals(cemail_error_message, "Email nhập lại không đúng");
    }

    @Test
    public void TC_03_Register_with_incorrect_Confirm_Email(){
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("AutomationFC");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("123@456@789");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("112233");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("112233");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0901001001");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String cemail_error_message = driver.findElement(By.cssSelector("label#txtCEmail-error")).getText();
        Assert.assertEquals(cemail_error_message, "Email nhập lại không đúng");
    }

    @Test
    public void TC_04_Register_with_Password_less_than_6_characters(){
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("AutomationFC");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("1122");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("1122");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0901001001");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String password_error_message = driver.findElement(By.cssSelector("label#txtPassword-error")).getText();
        Assert.assertEquals(password_error_message, "Mật khẩu phải có ít nhất 6 ký tự");
        String cpassword_error_message = driver.findElement(By.cssSelector("label#txtCPassword-error")).getText();
        Assert.assertEquals(cpassword_error_message, "Mật khẩu phải có ít nhất 6 ký tự");
    }

    @Test
    public void TC_05_Register_with_incorrect_Confirm_Password(){
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("AutomationFC");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("112233");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("11223333");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("0901001001");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String cpassword_error_message = driver.findElement(By.cssSelector("label#txtCPassword-error")).getText();
        Assert.assertEquals(cpassword_error_message, "Mật khẩu bạn nhập không khớp");
    }

    @Test
    public void TC_06_Register_with_incorrect_Phone(){
        driver.findElement(By.cssSelector("input#txtFirstname")).sendKeys("AutomationFC");
        driver.findElement(By.cssSelector("input#txtEmail")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input#txtCEmail")).sendKeys("abc@gmail.com");
        driver.findElement(By.cssSelector("input#txtPassword")).sendKeys("112233");
        driver.findElement(By.cssSelector("input#txtCPassword")).sendKeys("112233");
        driver.findElement(By.cssSelector("input#txtPhone")).sendKeys("12345656");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String phone_error_message = driver.findElement(By.cssSelector("label#txtPhone-error")).getText();
        Assert.assertEquals(phone_error_message, "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019 - 088 - 03 - 05 - 07 - 08");
    }

    @AfterMethod
    public void afterClass(){
        driver.quit();
    }

}

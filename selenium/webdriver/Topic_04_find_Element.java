package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_find_Element {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public void TC_01_xpath_Attribute(){
        driver.get("http://live.techpanda.org/index.php/");

        driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']"));

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();

        driver.findElement(By.xpath("//div[@class='product-info' and contains(.,'Samsung Galaxy')]//button")).click();

        driver.findElement(By.xpath("//div[@class='header-minicart']"));

        String successmessage = driver.findElement(By.xpath("//li[@class='success-msg']//span")).getText();

        String successmessageText = "Samsung Galaxy was added to your shopping cart.";

        Assert.assertEquals(successmessage, successmessageText);

        // driver.findElement(By.xpath("//input[starts-with(@title,'Email')]"));

    }

    @Test
    public void TC_02_xpath_Text_String(){
        // text() = lấy text tuyệt đối của chuỗi (ký tự xuống dòng/ khoảng trắng)
        driver.get("https://automationfc.github.io/basic-form/");

        //1- Truyền text vào trong locator để check hiển thị (displayed)
        // Nên sử dụng vì nó tuyệt đối
        driver.findElement(By.xpath("//h1[text()='Selenium WebDriver API']")).isDisplayed();

        // Hạn chế vì nó tương đối
        driver.findElement(By.xpath("//p[contains(text(),'Mail Personal or Business Check')]")).isDisplayed();
        driver.findElement(By.xpath("//p[contains(text(),\"Mail Personal or Business Check, Cashier's Check or money order to\")]")).isDisplayed();

        //2- Get text ra để verify
        String text = driver.findElement(By.xpath("//h5[@id='nine']/p[1]")).getText();

        Assert.assertTrue(text.contains("Mail Personal or Business Check"));
        Assert.assertTrue(text.contains("Cashier's Check or money order to"));
        Assert.assertTrue(text.contains("Mail Personal or Business Check, Cashier's Check or money order to"));
    }

    @Test
    public void TC_03(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}



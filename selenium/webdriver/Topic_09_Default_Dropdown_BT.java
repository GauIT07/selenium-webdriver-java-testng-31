    package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_09_Default_Dropdown_BT {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void TC_01_Default_Dropdown(){

        // 1. Xóa dữ liệu
        // 2. Nhập dữ liệu
        // 3. Verify
        // 4. Test tính năng Clear form

        // TextArea
        // Nhập dữ liệu xuống dòng thêm \n
        // Nhập dữ liệu tab khoảng cách thêm \t

        driver.get("https://demo.nopcommerce.com/register");

        driver.findElement(By.cssSelector("input#gender-male")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
        driver.findElement(By.cssSelector("input#Email")).sendKeys(getEmailAddress());

        Select dayDropdown = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
        dayDropdown.selectByVisibleText("1");

        //new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']"))).selectByVisibleText("1");
        List<WebElement> dayOptions = dayDropdown.getOptions();
        Assert.assertEquals(dayOptions.size(), 32);

        Select monthDropdown = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
        monthDropdown.selectByVisibleText("May");
        //new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']"))).selectByVisibleText("May");
        List<WebElement> monthOptions = monthDropdown.getOptions();
        Assert.assertEquals(monthOptions.size(),13);

        Select yearDropdown = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
        yearDropdown.selectByVisibleText("1980");
        //new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']"))).selectByVisibleText("1980");
        List<WebElement> yearOptions = yearDropdown.getOptions();
        Assert.assertEquals(yearOptions.size(),112);

        driver.findElement(By.cssSelector("input#Password")).sendKeys("Auto@12345");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("Auto@12345");
        driver.findElement(By.cssSelector("button#register-button")).click();
        //sleepInSecond(2);

        //Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Your registration completed']")).isDisplayed());

    }

    @Test
    public void TC_02_Default_Dropdown(){

        driver.get("https://rode.com/en/support/where-to-buy");

        Select country = new Select(driver.findElement(By.cssSelector("select#country")));
        Assert.assertFalse(country.isMultiple());
        country.selectByVisibleText("Vietnam");
        driver.findElement(By.cssSelector("input#map_search_query")).sendKeys("HO CHI MINH");
        driver.findElement(By.xpath("//button[text()='Search']")).click();

        List<WebElement> dealers = driver.findElements(By.xpath("//h3[text()='Dealers']/following-sibling::div//h4"));
        Assert.assertEquals(dealers.size(),16);
        // Assert.assertEquals(driver.findElements(By.xpath("//h3[text()='Dealers']/following-sibling::div//h4")).size(),16);

        for(WebElement element: dealers){
        System.out.println(element.getText());
        }
    }

    @Test
    public void TC_03(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    public String getEmailAddress() {
        // Random rand = new Random();
        // String emailAddress = "automation" + rand.nextInt(99999) + "@gmail.net"
        // return emailAddress;

        Random rand = new Random();
        return "Automation" + rand.nextInt(99999) + "@gmail.net";

        // return "automation" + new Random().nextInt(99999) + "@gmail.net";
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}



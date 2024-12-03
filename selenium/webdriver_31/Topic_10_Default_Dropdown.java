package webdriver_31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Topic_10_Default_Dropdown {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        //driver = new FirefoxDriver();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--user-data-dir=C:\\Users\\Admin\\AppData\\Local\\Microsoft\\Edge\\User Data");
        edgeOptions.addArguments("--profile-directory=Profile 2");
        driver = new EdgeDriver(edgeOptions);

        /*
        ChromeOptions option = new ChromeOptions();
        options.addArguments("--disable-geolocation");
        driver = new ChromeDriver(options);

        FirefoxOptions option = new FirefoxOptions();
        option.addPreference("geo.enabled", false);
        option.addPreference("geo.provider.use_corelocation", false);
        driver = new FirefoxDriver(option);
        */

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01() {
        driver.get("https://demo.nopcommerce.com/register");

        String firstName = "Automation";
        String lastName = "Testing";
        String emailAddress = "autotest" + new Random().nextInt(100) + "@gmail.net";
        String day = "8";
        String month = "March";
        String year = "1990";
        String password = "Auto@12345";

        driver.findElement(By.cssSelector("input#gender-male")).click();
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input#LastName")).sendKeys(lastName);
        Select dayDropdown = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
        Assert.assertEquals(dayDropdown.getOptions().size(), 32);
        dayDropdown.selectByVisibleText(day);
        //Assert.assertEquals(dayDropdown.getFirstSelectedOption().getText(), day);

        Select monthDropdown = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
        Assert.assertEquals(monthDropdown.getOptions().size(), 13);
        monthDropdown.selectByVisibleText(month);
        //Assert.assertEquals(monthDropdown.getFirstSelectedOption().getText(), month);

        Select yearDropdown = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
        Assert.assertEquals(yearDropdown.getOptions().size(), 112);
        yearDropdown.selectByVisibleText(year);
        //Assert.assertEquals(yearDropdown.getFirstSelectedOption().getText(), year);

        driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);

        driver.findElement(By.cssSelector("input#Password")).sendKeys(password);
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys(password);

        driver.findElement(By.cssSelector("button#register-button")).click();

        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");

        driver.findElement(By.xpath("//div[@class='header']//a[text()='My account']")).click();

        Assert.assertEquals(dayDropdown.getFirstSelectedOption(),"8");
        Assert.assertEquals(monthDropdown.getFirstSelectedOption(), "March");
        Assert.assertEquals(yearDropdown.getOptions(), "1990");
    }

    @Test
    public void TC_02() throws InterruptedException {
        driver.get("https://rode.com/en/support/where-to-buy");
        Thread.sleep(3000);

        Select countryDropdown = new Select(driver.findElement(By.cssSelector("select#country")));
        Assert.assertFalse(countryDropdown.isMultiple());
        countryDropdown.selectByVisibleText("Vietnam");

        driver.findElement(By.cssSelector("input#map_search_query")).sendKeys("HO CHI MINH");
        driver.findElement(By.xpath("//button[text()='Search']"));

        List<WebElement> dealers = driver.findElements(By.xpath("//h3[text()='Dealers']/following-sibling::div//h4"));
        Assert.assertEquals(dealers.size(), 16);
        for (WebElement element : dealers) {
            System.out.println(element.getText());
        }

    }

    @Test
    public void TC_03() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}



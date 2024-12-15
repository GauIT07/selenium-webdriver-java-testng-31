package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class Topic_09_Parameter {

    WebDriver driver;
    By emailTextbox = By.xpath("//*[@id='email']");
    By passwordTextbox = By.xpath("//*[@id='pass']");
    By loginButton = By.xpath("//*[@id='send2']");

    @Parameters({"browser", "version"})
    @BeforeClass
    public void beforeClass(String browserName, String browserVersion) {
        driver = getBrowserDriver(browserName);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Parameters("environment")
    @Test
    public void TC_01_Login(@Optional("live") String environmentName) {
        // Chức năng Login
        driver.get(getEnvironmentName(environmentName) + "index.php/customer/account/login/");
        System.out.println(getEnvironmentName(environmentName));
        driver.findElement(emailTextbox).sendKeys("selenium_11_01@gmail.com");
        driver.findElement(passwordTextbox).sendKeys("111111");
        driver.findElement(loginButton).click();
        driver.findElement(By.xpath("//button[@id='proceed-button']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText().contains("selenium_11_01@gmail.com"));

        //Action này cho tất cả các User đều giống nhau
        // Mua sản phẩm - thanh toán - verify
        // Logout ra
        driver.findElement(By.xpath("//header[@id='header']//span[text()='Account']")).click();
        driver.findElement(By.xpath("//a[text()='Log Out']")).click();

    }

    private WebDriver getBrowserDriver(String browserName) {
        WebDriver driver;
        if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equals("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Browser name is not valid");
        }
        return driver;
    }

    private String getEnvironmentName (String environmentName) {
        String urlValue;
        if (environmentName.equals("dev")) {
            urlValue = "https://dev.techpanda.org/";
        } else if (environmentName.equals("test")) {
            urlValue = "https://test.techpanda.org/";
        } else if (environmentName.equals("live")) {
            urlValue = "https://live.techpanda.org/";
        } else {
            throw new RuntimeException("Environment name is not valid");
        }
        return urlValue;
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

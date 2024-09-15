package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_06_Web_Browser_Command {
    // các câu lệnh thao tác vs Browser
    // driver.
    WebDriver driver;

    // các câu lệnh thao tác vs Element
    // element.
    WebElement element;

    @BeforeClass
    public void beforeClass() {
        // Muốn dùng được phải khởi tạo
        // Không khởi tạo sẽ báo lỗi NullPointerException
        driver = new FirefoxDriver();
        /*
        driver = new ChromeDriver();
        driver = new EdgeDriver();
        driver = new SafariDriver();
        */

        // driver = new OperaDriver(); // Selenium ver 3
        // driver = new HTMLUnit(); // headless browser
        // Headless: crawl data / dev FE

        // Selenium v3/2/1
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // Selenium v4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        driver.manage().window().maximize();

    }
    @Test
    public void TC_01_Browser() throws MalformedURLException {
        // Mở ra 1 page Url bất kỳ
        driver.get("https://facebook.com");

        System.out.println("Window/ Tab ID = " + driver.getWindowHandle());


        // tắt 1 tab đang chạy
        driver.close();

        // tắt browser có nhiều tab
        driver.quit();

        // 2 hàm này sẽ bị ảnh hưởng bởi implicitlyWait
        // findElement / findElements

        // Nó sẽ đi tìm vs loại By nào và trả về element nếu như được tìm thấy (WebElement)
        // Không tìm thấy: Fail tại step này - throw exception: NoSuchElementException
        // Trả về 1 element - nếu như tìm thấy nhiều hơn 1 thì cũng chỉ lấy 1 (thao tác với các đầu tiên)
        WebElement emailtextbox = driver.findElement(By.id("email"));

        // Nó sẽ đi tìm vs loại By nào và trả về danh sách element nếu như được tìm thấy (list WebElement)
        // Không tìm thấy: trả về 1 list rỗng
        List<WebElement> checkboxes = driver.findElements(By.xpath("input"));
        checkboxes.get(1).click();

        // Lấy ra Url của màn hình/ page hiện tại đang đứng
        driver.getCurrentUrl();
        //  Nếu chỉ dùng 1 lần thì không cần khai báo biến
        Assert.assertEquals(driver.getCurrentUrl(), "https://facebook.com");


        // Lấy ra page source HTML/ CSS/ JS của page hiện tại
        // Verify 1 cách tương đối
        driver.getPageSource();
        Assert.assertTrue(driver.getPageSource().contains("The Apple and Google Play logos"));


        // Lấy ra title của page hiện tại
        // Source -> document.title -> copy rồi compare data
        driver.getTitle();


        // Lấy ra ID của cửa sổ/ tab hiện tại
        // Handle Window/ Tab
        driver.getWindowHandle();
        driver.getWindowHandles();


        // Cookies - Framework
        driver.manage().getCookies();

        // Get ra những log ở Dev Tool - Framework
        driver.manage().logs().get(LogType.DRIVER);

        // Apply cho việc tìm element (findElement / findElements)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        // Chờ cho page được load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        // Set trước khi dùng vs thư viện JavascriptExecutor
        // Inject 1 đoạn code JS vào trong Browser / Element
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        // Selenium 4 mới có
        driver.manage().timeouts().getImplicitWaitTimeout();
        driver.manage().timeouts().getScriptTimeout();
        driver.manage().timeouts().getPageLoadTimeout();

        // Chạy full màn hình
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        driver.manage().window().minimize();

        // Test GUI
        // Test Responsive (Resolution)
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().window().setSize(new Dimension(2560, 1440));

        driver.manage().window().getSize();

        // Set cho browser ở vị trí nào so vs độ phân giải màn hình
        // run trên màn hình có kích thước bao nhiêu để chia tỉ lệ
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().getPosition();


        // Điều hướng trang web
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        // Thao tác vs history của web page (back/ forward)
        driver.navigate().to("");
        driver.navigate().to(new URL("https://facebook.com"));

        // Alert / Window (Tab) / Frame (iFrame)
        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().sendKeys("");
        driver.switchTo().alert().getText();

        String homepageWindowID = driver.getWindowHandle();
        driver.switchTo().window(homepageWindowID);
       // driver.switchTo().newWindow();

        // Switch/ handle fram (iframe)
        // Index / ID (name) / Element
        driver.switchTo().frame(0);
        driver.switchTo().frame("123-ID");
        driver.switchTo().frame(driver.findElement(By.id("")));

        // Switch về HTML chứa frame trước đó
        driver.switchTo().defaultContent();

        // Từ frame trong đi ra frame ngoài chứa nó
        driver.switchTo().parentFrame();


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



package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
        driver = new ChromeDriver();
        driver = new EdgeDriver();
        driver = new SafariDriver();

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
    public void TC_01(){
        // Mở ra 1 page Url bất kỳ
        driver.get("https://facebook.com");
        driver.get("https://automationfc.com");
        driver.get("https://znew.com");

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



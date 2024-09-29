package webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_07_WebElement_Command {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {   }
    @Test
    public void TC_01_Element(){

        // HTML Element: Textbox/ TextArea/ DropDown/ Button/ Checkbox...
        // Tìm và trả về 1 element
        driver.findElement(By.id(""));


        // Tìm và lưu nó vào 1 biến WebElement (chưa tương tác)
        // Khi có dùng biến này ít nhất từ 2 lần trở lên
        WebElement fullNameTextbox = driver.findElement(By.id(""));
        fullNameTextbox.clear();
        fullNameTextbox.sendKeys("AutomationDC");
        fullNameTextbox.getAttribute("value");


        // Tìm và tương tác
        driver.findElement(By.id("")).click();
        driver.findElement(By.id("")).sendKeys();


        // Dùng để xóa dữ liệu trong 1 field cho phép nhập (editable)
        // Textbox / TextArea / Dropdown (editable)
        // Thường được dùng trước hàm sendKeys -> đảm bảo toàn vẹn dữ liệu
        driver.findElement(By.id("")).clear();


        // Dùng để nhập liệu vào các field bên trên
        driver.findElement(By.id("")).sendKeys("");


        // Dùng để click lên element
        driver.findElement(By.id("")).click();


        // Tìm từ node cha vào node con
        driver.findElement(By.id("")).findElement(By.id(""));
        driver.findElement(By.id("")).findElements(By.cssSelector("input"));


        // Tìm nhiều element khớp với điều kiện
        List<WebElement> textboxes = driver.findElements(By.cssSelector(""));

        // Java non Generic
        ArrayList name = new ArrayList();
        name.add("ABV");
        name.add(15);
        name.add('B');
        name.add(true);

        // Java Generic
        ArrayList<String> address = new ArrayList<String>();
        address.add("ABC");
        // address.add(15);
        // address.add('B');
        // address.add(true);


        // Dùng để verify 1 checkbox/ radio / dropdown (default) đã được chọn hay chưa
        Assert.assertTrue(driver.findElement(By.id("")).isSelected());
        Assert.assertFalse(driver.findElement(By.id("")).isSelected());


        // Dropdown (default / custome)
        Select select = new Select(driver.findElement(By.id("")));


        // Dùng để verify 1 element bất kỳ có hiển thị hay không
        Assert.assertTrue(driver.findElement(By.id("")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.id("")).isDisplayed());


        // Dùng để verify 1 element có được thao tác lên hay ko (ko phải read-only)
        Assert.assertTrue(driver.findElement(By.id("")).isEnabled());
        Assert.assertFalse(driver.findElement(By.id("")).isEnabled());


        // Dùng để lấy ra giá trị của attribute trên element
        driver.findElement(By.id("")).getAttribute("title");
        driver.findElement(By.id("")).getAttribute("type");
        driver.findElement(By.id("")).getAttribute("id");


        // Lấy giá trị DOM từ tab Accessibility / Properties -> Devtools - Element
        driver.findElement(By.id("")).getAccessibleName();
        driver.findElement(By.id("")).getDomAttribute("checked");
        driver.findElement(By.id("")).getDomProperty("baseURI");


        // Tab Styles -> Devtools - Element
        // Font/ Size/ Color/ Background
        driver.findElement(By.id("")).getCssValue("background-color");
        driver.findElement(By.id("")).getCssValue("fonr-size");


        // Location (Vị trí) của element so vs độ phân giải màn hình
        // tọa độ x, y so với rìa màn hình trên browser
        Point nameTextLocation = driver.findElement(By.id("")).getLocation();
        nameTextLocation.getX();
        nameTextLocation.getY();

        // Size
        Dimension addressSize = driver.findElement(By.id("")).getSize();

        // Location + Size
        // tọa độ x, y với rìa màn hình trên browser và chiều rộng, chiều cao của element trên giao diện
        Rectangle nameTextboxRect = driver.findElement(By.id("")).getRect();
        nameTextboxRect.getX();
        nameTextboxRect.getY();
        nameTextboxRect.getHeight();
        nameTextboxRect.getWidth();

        // Location
        Point namePoint = nameTextboxRect.getPoint();

        // Size
        Dimension nameSize = nameTextboxRect.getDimension();
        nameSize.getHeight();
        nameSize.getWidth();


        // Shadow Element (JavascriptExecutor)
        driver.findElement(By.id("")).getShadowRoot();


        // Từ id/ class/ name/ css/ xpath có thể truy ngược lại tagname HTML
        driver.findElement(By.id("")).getTagName();
        driver.findElement(By.className("")).getTagName();
        driver.findElement(By.name("")).getTagName();
        driver.findElement(By.cssSelector("")).getTagName();
        driver.findElement(By.xpath("")).getTagName();

        driver.findElement(By.id("")).getText();

        // Chụp hình bị lỗi và lưu dưới dạng nào
        // BYTES
        // FILE (lưu thành 1 hình có kích thước ở trong ổ cứng: .png/ .jpg/...)
        // BASE64 (text)
        driver.findElement(By.id("")).getScreenshotAs(OutputType.BASE64);
        driver.findElement(By.id("")).getScreenshotAs(OutputType.FILE);
        driver.findElement(By.id("")).getScreenshotAs(OutputType.BYTES);


        // Form (element nào là thẻ form hoặc nằm trong thẻ form)
        // hành vi giống như phím enter
        // Register / Login / Search
        driver.findElement(By.id("")).submit();

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



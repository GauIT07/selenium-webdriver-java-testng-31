package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_10_Custom_Dropdown {
    WebDriver driver;

    // wait tường minh: trạng thái cụ thể của element
    // Visible - hiển thị
    // Invisible - không hiển thị
    // Presence - có trong HTML ko hiển thị
    // Number - số lượng element
    // Clickable - element có được click hay ko...
    WebDriverWait explicitWait;

    // FluentWait<WebDriver> fluentWait;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        explicitWait =  new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait ngầm định: ko rõ ràng cho 1 trạng thái cụ thể nào của element hết
        // Cho việc tìm element - findElement(s)
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @Test
    public void TC_01_jQuery() {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        // 1 - Click vào 1 thẻ để cho nó show hết các item bên trong dropdown ra
        driver.findElement(By.cssSelector("span#number-button")).click();
        sleepInSecond(3);

        // 2.1 - Nó sẽ show ra hết tất cả các item
        // 2.2 - Nó sẽ show ra nhưng chỉ chứa 1 phần và đang load thêm - Ngàn/ Triệu record
        //      Chờ cho nó show hết tất cả các item trong dropdown

        // Có case item ko visible hết tất cả (Angular/ ...)
        // Visible: nhìn thấy được/ thao tác được
        // - Có trên UI
        // - Có trong HTML - Displayed - Visibility
        // explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("")));

        // Presence: nhìn thấy/ ko nhìn thấy cũng thỏa mãn
        // - Có/ ko có trên UI
        // - Có trong HTML (bắt buộc)

        // Chờ cho tới khi tất cả element xuất hiện trong HTML
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));

        // Sau khi xuất hiện thì get tất cả các element đang có
        List<WebElement> allItems = driver.findElements(By.cssSelector("ul#number-menu div"));
        // allItems đang chứa 19 items

        // duyệt qua từng phần tử trong items
        // cú pháp for each: for (kiểu_dữ_liệu tên_biến : mảng_cần_duyệt)
        for (WebElement item : allItems){
            String textItem = item.getText();

            // String kiểm tra bằng equals không dùng == do nó là kiểu dữ liệu tham chiếu
            // cần kiểm tra cả ô nhớ để xác định đúng thông tin giá trị
            if(textItem.equals("8")){
                item.click();
                break;
            }
        }
        // 3.1 - Nếu như item cần chọn nó hiển thị thì click vào
        // 3.2 - Nếu như item cần chọn nằm bên dưới thì 1 số trường hợp cần scroll xuống để hiển thị ra rồi mới chọn (Angular/ React/ VueJS/...)

        // 4 - Trước khi click cần kiểm tra nếu như text của item bằng với text cần chọn thì click vào

    }

    @Test
    public void TC_02_jQuery() {

        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        selectItemInDropdown("span#number-button", "ul#number-menu div", "15");
        sleepInSecond(3);

        driver.navigate().refresh();

        selectItemInDropdown("span#number-button", "ul#number-menu div", "8");
        sleepInSecond(3);
    }

    @Test
    public void TC_03_jQuery() {

        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        selectItemInDropdown("span#speed-button", "ul#speed-menu div", "Faster");
        sleepInSecond(3);

        selectItemInDropdown("span#files-button", "ul#files-menu div", "ui.jQuery.js");
        sleepInSecond(3);

        selectItemInDropdown("span#number-button", "ul#number-menu div", "15");
        sleepInSecond(3);

        selectItemInDropdown("span#salutation-button", "ul#salutation-menu div", "Dr.");
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(), "Faster");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#files-button>span.ui-selectmenu-text")).getText(), "ui.jQuery.js");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(), "15");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(), "Dr.");
    }

    @Test
    public void TC_04_React() {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectItemInDropdown("i.dropdown.icon", "div.item>span", "Jenny Hess");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Jenny Hess");
        sleepInSecond(3);

        selectItemInDropdown("i.dropdown.icon", "div.item>span", "Stevie Feliciano");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Stevie Feliciano");
        sleepInSecond(3);

        selectItemInDropdown("i.dropdown.icon", "div.item>span", "Justen Kitsune");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Justen Kitsune");
        sleepInSecond(3);

    }

    @Test
    public void TC_05_VueJS() {

        driver.get("https://mikerodham.github.io/vue-dropdowns/");

        selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");
        sleepInSecond(3);

        selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "Third Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Third Option");
        sleepInSecond(3);
    }

    @Test
    public void TC_06_EditableDropdown() {

        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

        selectItemInEditableDropdown("input.search", "div.item span", "Algeria");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Algeria");
        sleepInSecond(3);

        selectItemInEditableDropdown("input.search", "div.item span", "Belarus");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Belarus");
        sleepInSecond(3);
    }

    @Test
    public void TC_07_DefaultDropdown() {

        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

        selectItemInDropdown("select[name='DateOfBirthDay']", "select[name='DateOfBirthDay']>option", "18");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']>option[value='18']")).isSelected());
        sleepInSecond(3);

        selectItemInDropdown("select[name='DateOfBirthMonth']", "select[name='DateOfBirthMonth']>option", "May");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']>option[value='5']")).isSelected());
        sleepInSecond(3);

        selectItemInDropdown("select[name='DateOfBirthYear']", "select[name='DateOfBirthYear']>option", "2010");
        Assert.assertTrue(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']>option[value='2010']")).isSelected());
        sleepInSecond(3);
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

    public void selectItemInDropdown(String parentsCss, String childItemsCss, String itemTextExpected) {
        driver.findElement(By.cssSelector(parentsCss)).click(); // "span#number-button"
        sleepInSecond(3);
        // explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemsCss))); // "ul#number-menu div"
        // List<WebElement> allItems = driver.findElements(By.cssSelector(childItemsCss)); // "ul#number-menu div"

        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemsCss)));// "ul#number-menu div"
        for (WebElement item : allItems){
            String textItem = item.getText();
            if(textItem.equals(itemTextExpected)){
                item.click();
                break;
            }
        }
    }

    public void selectItemInEditableDropdown(String parentsCss, String childItemsCss, String itemTextExpected) {
        driver.findElement(By.cssSelector(parentsCss)).clear();
        driver.findElement(By.cssSelector(parentsCss)).sendKeys(itemTextExpected);
        sleepInSecond(3);
        // explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemsCss)));
        // List<WebElement> allItems = driver.findElements(By.cssSelector(childItemsCss)); // "ul#number-menu div"

        List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childItemsCss)));
        for (WebElement item : allItems){
            String textItem = item.getText();
            if(textItem.equals(itemTextExpected)){
                item.click();
                break;
            }
        }
    }
}



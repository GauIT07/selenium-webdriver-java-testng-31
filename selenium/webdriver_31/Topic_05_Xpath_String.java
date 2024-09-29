package webdriver_31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_05_Xpath_String {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com");

    }
    @Test
    public void TC_01(){

        // text() = tuyệt đối -> lấy chính xác từng ký tự
        driver.findElement(By.xpath("//div[text()='abc']"));

        // contains(text(),'') -> lấy tương đối đoạn ký tự chứa trong element -> text nằm ở node con đầu tiên hoặc ngang hàng
        driver.findElement(By.xpath("//span[contains(text(), 'Automation')]"));

        // contains(.,'') ~ contains(string(), '') -> lấy tương đối đoạn text chứa trong element -> text nằm ở tất cả các node con ko phân biệt
        driver.findElement(By.xpath("//div[contains(., 'Automation FC')]"));
        driver.findElement(By.xpath("//div[contains(string(), 'Automation FC')]"));

        // concat() -> text vừa có dấu nháy đơn vừa có dấu nháy đôi
        // dùng nháy đôi bọc đấu đơn và ngược lại dùng nháy đơn bọc nháy đôi
        driver.findElement(By.xpath("//span[text()=concat('Hello \"John\", What',\"'s happened?\")]"));


        // And Or
        // kiểu luận lý lấy cả 2 hoặc nhiều attribute của element
        driver.findElement(By.xpath("//div[contains(text(), 'Automation FC') and @id = 'lastName']"));

        driver.findElement(By.xpath("//div[contains(text(), 'Automation FC') or @id = 'firstName']"));


        // not() - phủ định
        // chỉ dùng trong trường hợp có 2 element giống nhau
        // có 3 element sẽ không áp dụng được phủ định
        driver.findElement(By.xpath("//div[not(@style='display:none;')]/div[@class='raDiv']"));

        // dùng trong trường hợp cùng 1 thẻ cha và ngang hàng
        // position() ~ với index -> vị trí của element
        driver.findElement(By.xpath("//ol[@id='selectable']/li[position()=20]"));
        driver.findElement(By.xpath("//ol[@id='selectable']/li[20]"));

        // dùng trong trường hợp cùng 1 thẻ cha và ngang hàng
        // index cuối
        // last() -> dùng để thao tác với element cuối cùng ko truyền index
        driver.findElement(By.xpath("//ol[@id='selectable']/li[last()]"));
        // count(tagName) -> dùng để count số lượng element -> lấy số tổng truyền vào -> index cuối
        // lưu ý phải đứng trên tagname cần đếm rồi gán count(//tagName)
        driver.findElement(By.xpath("//ol[@id='selectable']/li[count(//li)]"));

        // index kế cuối cuối
        // last()-1 -> dùng để thao tác với element gần kề cuối cùng
        driver.findElement(By.xpath("//ol[@id='selectable']/li[last()-1]"));
        // count(tagName)-1 -> dùng để count số lượng element sai đó trừ đi 1 -> lấy số tổng truyền vào và trừ 1 -> index gần kề cuối
        // lưu ý phải đứng trên tagname cần đếm rồi gán count(//tagName)
        driver.findElement(By.xpath("//ol[@id='selectable']/li[count(//li)-1]"));

        // outside parent -> dùng () gom xpath lại để đánh index
        driver.findElement(By.xpath("(//span[text()='Add to cart'])[1]"));


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



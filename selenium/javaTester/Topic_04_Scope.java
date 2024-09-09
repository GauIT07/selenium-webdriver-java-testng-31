package javaTester;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_Scope {

    // Các biến được khai báo bên ngoài hàm -> phạm vi là Class
    // Biến Global (toàn cục)
    WebDriver driver;

    String homepageUrl; // Khai báo (Declare)

    String fullName = "Automation FC"; // Khai báo + khởi tạo (Initial)

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

    }
    @Test
    public void TC_01(){
        // Các biến được khai báo trong 1 hàm / block code -> phạm vi cục bộ (local)
        // Dùng trong hàm mà nó được khai báo / block code được sinh ra
        String homepageUrl = "https://facebook.com";

        // Trong 1 hàm nếu như có 2 biến cùng tên (Global/ Local) thì nó sẽ ưu tiên dùng Local
        // 1 biến Local nếu như gọi tới mà chưa được khởi tạo thì sẽ báo lỗi
        // Biến Local chưa khỏi tạo mà gọi ra dùng nó sẽ báo lỗi ngay (compile code)
        driver.get(homepageUrl);

        // Nếu trong 1 hàm có 2 biến cùng tên (Global/ Local) mà muốn lấy biến Global ra dùng
        // Từ khóa this
        // Biến Global chưa khởi tạo mà gọi ra dùng nó sẽ không thông báo lỗi ngay (compile code) -> runtime sẽ lỗi
        driver.get(this.homepageUrl);

    }

    @Test
    public void TC_02(){

    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

}

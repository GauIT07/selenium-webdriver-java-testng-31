    package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_09_Default_Dropdown {
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

        // 1. Xóa dữ liệu
        // 2. Nhập dữ liệu
        // 3. Verify
        // 4. Test tính năng Clear form

        // TextArea
        // Nhập dữ liệu xuống dòng thêm \n
        // Nhập dữ liệu tab khoảng cách thêm \t


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



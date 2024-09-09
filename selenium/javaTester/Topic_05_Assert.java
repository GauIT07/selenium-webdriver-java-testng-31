package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_05_Assert {

    WebDriver driver;
    @Test
    public void verifyTestNG() {

        driver = new FirefoxDriver();
        driver.get("https://facebook.com");
        // Trong Java có nhiều thư viện để verify dữ liệu
        // Testing Framework (Unit/ Intergration / UI Automation Test)
        // JUnit 4 / TestNG / JUnit 5 / Hamcrest / AssertJ / ...


        // Kiểu dữ liệu nhận vào là boolean (true/false)
        // Khi mong muốn điều kiện trả về là đúng thì dùng assertTrue để verify
        Assert.assertTrue(driver.getPageSource().contains("Facebook giúp bạn kết nối và chia sẻ với mọi người trong cuộc sống của bạn."));

        // Khi mong mong muốn điều kiệ trả về là sai thì dùng assertFalse để verify
        Assert.assertFalse(driver.getPageSource().contains("Create a new account"));

        // Các hàm trả về kiểu dữ liệu boolean
        // Quy tắc: bắt đầu với tiền tố isXXXX
        // WebElement
        driver.findElement(By.id("")).isDisplayed();
        driver.findElement(By.id("")).isEnabled();
        driver.findElement(By.id("")).isSelected();
        new Select(driver.findElement(By.id(""))).isMultiple();


        // Mong đợi 1 điều kiện giống thực tế (Tuyệt đối)
        // Actual = Expected
        Assert.assertEquals(driver.getCurrentUrl(), "https://facebook.com");
        Assert.assertEquals(driver.findElement(By.id("")), "Text example");


        // Unit Test
        Object name = null;
        Assert.assertNull(name);

        name = "Testing";
        Assert.assertNotNull(name);

    }
}

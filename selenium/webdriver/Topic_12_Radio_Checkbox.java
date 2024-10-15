package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_12_Radio_Checkbox {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @Test
    public void TC_01_Default_Telerik_Checkbox(){
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");

        By rearSideCheckbox = By.xpath("//label[text()='Rear side airbags']/preceding-sibling::span/input");
        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");

        // Click vào checkbox
        // Case 1: Nếu app mở ra mà checkbox đã được chọn thì sao
        checkToElement(rearSideCheckbox);
        // Case 2: Nếu app mở ra mà checkbox chưa được chọn
        checkToElement(dualZoneCheckbox);

        // Verify checkbox đã được chọn thành công
        Assert.assertTrue(driver.findElement(rearSideCheckbox).isSelected());
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());

        uncheckToElement(rearSideCheckbox);
        uncheckToElement(dualZoneCheckbox);

        // Verify checkbox đã được bỏ chọn thành công
        Assert.assertFalse(driver.findElement(rearSideCheckbox).isSelected());
        Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());

    }

    @Test
    public void TC_02_Default_Telerik_Radio() {
        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");

        By twoPetrolRadio = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");
        By twoDieselRadio = By.xpath("//label[text()='2.0 Diesel, 103kW']/preceding-sibling::span/input");

        checkToElement(twoPetrolRadio);

        Assert.assertTrue(driver.findElement(twoPetrolRadio).isSelected());
        Assert.assertFalse(driver.findElement(twoDieselRadio).isSelected());

        checkToElement(twoDieselRadio);

        Assert.assertFalse(driver.findElement(twoPetrolRadio).isSelected());
        Assert.assertTrue(driver.findElement(twoDieselRadio).isSelected());

    }

    @Test
    public void TC_03_Default_Select_All_Checkbox() {
        driver.get("https://automationfc.github.io/multiple-fields/");

        // Chọn hết tất cả các checkbox có trong màn hình

        List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));
        for (WebElement checkbox : allCheckboxes){
            if(!checkbox.isSelected()){
                checkbox.click();
            //    sleepInSecond(1);
            }
        }

        for (WebElement checkbox : allCheckboxes){
            Assert.assertTrue(checkbox.isSelected());
        }


        // Chọn 1 checkbox/ radio nào đó trong tất cả checkbox/ radio
        for (WebElement checkbox : allCheckboxes){
            if (checkbox.getAttribute("value").equals(" Emotional Disorder ") && !checkbox.isSelected()){
                checkbox.click();
                //sleepInSecond(1);
            }
        }

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();

        allCheckboxes = driver.findElements(By.cssSelector("div.form-single-column input[type='checkbox']"));

        for (WebElement checkbox : allCheckboxes){
            if (checkbox.getAttribute("value").equals(" Emotional Disorder ")) {
                Assert.assertTrue(checkbox.isSelected());
            } else {
                Assert.assertFalse(checkbox.isSelected());
            }
        }

    }


    @Test
    public void TC_04_Custom_Radio(){
        driver.get("https://login.ubuntu.com/");


    }


    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    public void checkToElement (By byxpath){
        // Nếu như element chưa được chọn thì mới click
        if (!driver.findElement(byxpath).isSelected()) {
            driver.findElement(byxpath).click();
        }
    }

    public void uncheckToElement (By byxpath){
        // Nếu như element được chọn rồi thig vào click lần nữa cho nó thành bỏ chọn
        if (driver.findElement(byxpath).isSelected()) {
            driver.findElement(byxpath).click();
        }
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}



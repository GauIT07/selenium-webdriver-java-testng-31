package webdriver_31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_12_Button_Checkbox_Radio {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Button() {
        driver.get("https://www.fahasa.com/customer/account/create");
        driver.findElement(By.cssSelector("li.popup-login-tab-login")).click();
        By loginButton = By.cssSelector("button.fhs-btn-login");
        Assert.assertFalse(driver.findElement(loginButton).isEnabled());

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(driver.findElement(loginButton))));

        //driver.findElement(loginButton).getCssValue("background-color");
        String loginButtonDisableColor = Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase();
        System.out.println(loginButtonDisableColor);
        Assert.assertEquals(loginButtonDisableColor, "#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("testing@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");
        Assert.assertTrue(driver.findElement(loginButton).isEnabled());
        String loginButtonEnableColor = Color.fromString(driver.findElement(loginButton).getCssValue("background-color")).asHex().toUpperCase();
        System.out.println(loginButtonEnableColor);
        Assert.assertEquals(loginButtonEnableColor, "#C92127");

    }

    @Test
    public void TC_02_Default_Checkbox_Radio() {
        driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");

        By dualZoneCheckbox = By.xpath("//label[text()='Dual-zone air conditioning']/preceding-sibling::span/input");
        By twoPetrol147kW = By.xpath("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::span/input");

        driver.findElement(dualZoneCheckbox).click();
        Assert.assertTrue(driver.findElement(dualZoneCheckbox).isSelected());

        driver.findElement(dualZoneCheckbox).click();
        Assert.assertFalse(driver.findElement(dualZoneCheckbox).isSelected());

        driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
        if (!driver.findElement(twoPetrol147kW).isSelected()) {
            driver.findElement(twoPetrol147kW).click();
        }
        Assert.assertTrue(driver.findElement(twoPetrol147kW).isSelected());

    }

    @Test
    public void TC_03_Default_Checkbox_Radio() throws InterruptedException {
        driver.get("https://material.angular.io/components/radio/examples");
        if (!driver.findElement(By.cssSelector("input[value='Summer']")).isSelected()) {
            driver.findElement(By.cssSelector("input[value='Summer']")).click();
            Thread.sleep(2000);
        }

        driver.get("https://material.angular.io/components/checkbox/examples");
        By checkCheckbox = By.xpath("//label[text()='Checked']/parent::div//input");
        By indetermimateCheckbox = By.xpath("//label[text()='Indeterminate']/parent::div//input");
        driver.findElement(checkCheckbox).click();
        Assert.assertTrue(driver.findElement(checkCheckbox).isSelected());
        driver.findElement(indetermimateCheckbox).click();
        Assert.assertTrue(driver.findElement(indetermimateCheckbox).isSelected());

        driver.findElement(checkCheckbox).click();
        Assert.assertFalse(driver.findElement(checkCheckbox).isSelected());
        driver.findElement(indetermimateCheckbox).click();
        Assert.assertFalse(driver.findElement(indetermimateCheckbox).isSelected());
    }

    @Test
    public void TC_04_Default_Checkbox_Radio() throws InterruptedException {
        driver.get("https://automationfc.github.io/multiple-fields/");
        By allCheckboxes = By.cssSelector("div.form-single-column span.form-checkbox-item input");
        List<WebElement> allCheckboxesValue = driver.findElements(allCheckboxes);
        for (WebElement checkbox : allCheckboxesValue) {
            if (!checkbox.isSelected()) {
                checkbox.click();
                Thread.sleep(500);
            }
        }
        for (WebElement checkbox: allCheckboxesValue){
            Assert.assertTrue(checkbox.isSelected());
        }

        for (WebElement checkbox : allCheckboxesValue) {
            if (checkbox.isSelected()) {
                checkbox.click();
                Thread.sleep(500);
            }
        }

        for(WebElement checkbox : allCheckboxesValue){
            if(checkbox.getAttribute("value").equals("Heart Attack")){
                checkbox.click();
                Thread.sleep(2000);
            }
        }

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}



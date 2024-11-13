package webdriver_31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_08_WebElement_Exercise {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @Test
    public void TC_01_isDisplayed() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        if (driver.findElement(By.cssSelector("input#mail")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#mail")).sendKeys("Automation Testing");
            System.out.println("Email textbox is displayed");
        } else {
            System.out.println("Email textbox is not displayed");
        }

        if (driver.findElement(By.cssSelector("input#under_18")).isDisplayed()) {
            driver.findElement(By.cssSelector("input#under_18")).click();
            System.out.println("Age Under_18 radio is displayed");
        } else {
            System.out.println("Age Under_18 radio is not displayed");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isDisplayed()) {
            driver.findElement(By.cssSelector("textarea#edu")).sendKeys("Automation Testing");
            System.out.println("Edu textarea is displayed");
        } else {
            System.out.println("Edu textarea is not displayed");
        }

        if (driver.findElement(By.xpath("//h5[text()='Name: User5']")).isDisplayed()) {
            System.out.println("Name User5 is displayed");
        } else {
            System.out.println("Name User5 is not displayed");
        }
    }

    @Test
    public void TC_02_isEnabled() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        if (driver.findElement(By.cssSelector("input#mail")).isEnabled()) {
            System.out.println("Email textbox is enabled");
        } else {
            System.out.println("Email textbox is disabled");
        }

        if (driver.findElement(By.cssSelector("input#under_18")).isEnabled()) {
            System.out.println("Age Under_18 radio is enabled");
        } else {
            System.out.println("Age Under_18 radio is disabled");
        }

        if (driver.findElement(By.cssSelector("textarea#edu")).isEnabled()) {
            System.out.println("Edu textarea is enabled");
        } else {
            System.out.println("Edu textarea is disabled");
        }

        if (driver.findElement(By.cssSelector("select#job1")).isEnabled()) {
            System.out.println("Select Job Role 1 is enabled");
        } else {
            System.out.println("Select Job Role 1 is disabled");
        }

        if (driver.findElement(By.cssSelector("select#job2")).isEnabled()) {
            System.out.println("Select Job Role 2 is enabled");
        } else {
            System.out.println("Select Job Role 2 is disabled");
        }

        if (driver.findElement(By.cssSelector("input#development")).isEnabled()) {
            System.out.println("Development checkbox is enabled");
        } else {
            System.out.println("Development checkbox is disabled");
        }

        if (driver.findElement(By.cssSelector("input[id='slider-1']")).isEnabled()) {
            System.out.println("Slider 01 is enabled");
        } else {
            System.out.println("Slider 01 is disabled");
        }



        if (driver.findElement(By.cssSelector("input#disable_password")).isEnabled()) {
            System.out.println("Password textbox is enabled");
        } else {
            System.out.println("Password textbox is disabled");
        }

        if (driver.findElement(By.cssSelector("input#radio-disabled")).isEnabled()) {
            System.out.println("Age Radio button is enabled");
        } else {
            System.out.println("Age Radio button is disabled");
        }

        if (driver.findElement(By.cssSelector("select#job3")).isEnabled()) {
            System.out.println("Dropdown Job Role 3 is enabled");
        } else {
            System.out.println("Dropdown Job Role 3 is disabled");
        }

        if (driver.findElement(By.cssSelector("input#check-disbaled")).isEnabled()) {
            System.out.println("Interests checkbox is enabled");
        } else {
            System.out.println("Interests checkbox is disabled");
        }

        if (driver.findElement(By.cssSelector("input[id='slider-2']")).isEnabled()) {
            System.out.println("Slider 02 is enabled");
        } else {
            System.out.println("Slider 02 is disabled");
        }

        if (driver.findElement(By.cssSelector("input#development")).isEnabled()) {
            System.out.println("Development checkbox is enabled");
        } else {
            System.out.println("Development checkbox is disabled");
        }

    }

    @Test
    public void TC_03_isSelected() {
        driver.get("https://automationfc.github.io/basic-form/index.html");

        driver.findElement(By.cssSelector("input#under_18")).click();
        driver.findElement(By.cssSelector("input#java")).click();

        if(driver.findElement(By.cssSelector("input#under_18")).isSelected()){
            System.out.println("Age under_18 radio is selected");
        } else {
            System.out.println("Age under_18 radio is de-selected");
        }

        if(driver.findElement(By.cssSelector("input#java")).isSelected()){
            System.out.println("Java checkbox is selected");
        } else {
            System.out.println("Java checkbox is de-selected");
        }

        driver.findElement(By.cssSelector("input#java")).click();

        if(driver.findElement(By.cssSelector("input#java")).isSelected()){
            System.out.println("Java checkbox is selected");
        } else {
            System.out.println("Java checkbox is de-selected");
        }
    }

    @Test
    public void TC_04_MailChimp() {
        driver.get("https://login.mailchimp.com/signup/");

        driver.findElement(By.cssSelector("input#email")).sendKeys("automationfc@gmail.net");

        // Number
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("111222");

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // lowercase
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("abcd");

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // uppercase
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("ABCD");

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

        // specialcase
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("@@@$!");

        Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li[class='8-char not-completed']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());


        // more than 8 characters
        driver.findElement(By.cssSelector("input#new_password")).clear();
        driver.findElement(By.cssSelector("input#new_password")).sendKeys("Abc@1234");

        Assert.assertFalse(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li[class='8-char completed']")).isDisplayed());
        Assert.assertFalse(driver.findElement(By.cssSelector("li.username-check.completed")).isDisplayed());

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}



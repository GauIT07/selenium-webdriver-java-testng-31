package webdriver_31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_11_Custom_Dropdown {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_jQuery() throws InterruptedException {
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");

        //salutation
        selectItemInDropdown("span#salutation-button", "ul#salutation-menu div", "Dr.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(), "Dr.");

        //speed
        selectItemInDropdown("span#speed-button", "ul#speed-menu div", "Slow");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(), "Slow");

        //files
        selectItemInDropdown("span#files-button", "ul#files-menu div", "ui.jQuery.js");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#files-button>span.ui-selectmenu-text")).getText(), "ui.jQuery.js");

        //files
        selectItemInDropdown("span#number-button", "ul#number-menu div", "2");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(), "2");


    }



    @Test
    public void TC_02_React() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectItemInDropdown("div.dropdown", "div.dropdown>div.visible span", "Jenny Hess");
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.dropdown>div.divider")).getText(), "Jenny Hess");

        selectItemInDropdown("div.dropdown", "div.dropdown>div.visible span", "Elliot Fu");
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.dropdown>div.divider")).getText(), "Elliot Fu");

        selectItemInDropdown("div.dropdown", "div.dropdown>div.visible span", "Christian");
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.dropdown>div.divider")).getText(), "Christian");
    }

    @Test
    public void TC_03_vueJS() throws InterruptedException {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");

        selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "First Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "First Option");

        selectItemInDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private void selectItemInDropdown(String dropdown, String dropdown_list, String value) throws InterruptedException {
        driver.findElement(By.cssSelector(dropdown)).click();
        Thread.sleep(3000);

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.cssSelector(dropdown_list)));

        List<WebElement> allItems = driver.findElements(By.cssSelector(dropdown_list));
        for (WebElement item : allItems)
        {
            if (item.getText().equals(value))
            {
                item.click();
                break;
            }
        }
    }
}



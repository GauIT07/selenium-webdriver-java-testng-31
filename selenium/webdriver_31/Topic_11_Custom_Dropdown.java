package webdriver_31;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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
        selectItemInSelectableDropdown("span#salutation-button", "ul#salutation-menu div", "Dr.");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(), "Dr.");

        //speed
        selectItemInSelectableDropdown("span#speed-button", "ul#speed-menu div", "Slow");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(), "Slow");

        //files
        selectItemInSelectableDropdown("span#files-button", "ul#files-menu div", "ui.jQuery.js");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#files-button>span.ui-selectmenu-text")).getText(), "ui.jQuery.js");

        //files
        selectItemInSelectableDropdown("span#number-button", "ul#number-menu div", "2");
        Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(), "2");
        
    }



    @Test
    public void TC_02_React() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");

        selectItemInSelectableDropdown("div.dropdown", "div.dropdown>div.visible span", "Jenny Hess");
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.dropdown>div.divider")).getText(), "Jenny Hess");

        selectItemInSelectableDropdown("div.dropdown", "div.dropdown>div.visible span", "Elliot Fu");
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.dropdown>div.divider")).getText(), "Elliot Fu");

        selectItemInSelectableDropdown("div.dropdown", "div.dropdown>div.visible span", "Christian");
        Thread.sleep(1000);
        Assert.assertEquals(driver.findElement(By.cssSelector("div.dropdown>div.divider")).getText(), "Christian");
    }

    @Test
    public void TC_03_vueJS() throws InterruptedException {
        driver.get("https://mikerodham.github.io/vue-dropdowns/");

        selectItemInSelectableDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "First Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "First Option");

        selectItemInSelectableDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "Second Option");
        Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");

    }

    @Test
    public void TC_04_Editable() throws InterruptedException {
        driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");

        selectItemInEditableDropdown("div.selection.dropdown>input", "div.visible.menu span", "Belarus");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Belarus");
    }

    @Test
    public void TC_05_Huawei() throws InterruptedException {
        driver.get("https://id5.cloud.huawei.com/CAS/portal/userRegister/regbyemail.html");
        Thread.sleep(3000);
        selectItemInHuaweiEditableDropdown("div.hwid-ctryDropdown", "input.hwid-search-text", "span.list-item-text", "Afghanistan");

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private void selectItemInSelectableDropdown(String parentLocator, String childLocator, String textItem) throws InterruptedException {
        driver.findElement(By.cssSelector(parentLocator)).click();
        Thread.sleep(3000);

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));

        List<WebElement> allItems = driver.findElements(By.cssSelector(childLocator));
        for (WebElement item : allItems)
        {
            if (item.getText().equals(textItem))
            {
                item.click();
                break;
            }
        }
    }

    private void selectItemInEditableDropdown(String parentLocator, String childLocator, String textItem) throws InterruptedException {
        driver.findElement(By.cssSelector(parentLocator)).clear();
        driver.findElement(By.cssSelector(parentLocator)).sendKeys(textItem);
        Thread.sleep(1000);

        driver.findElement(By.cssSelector(parentLocator)).click();
        Thread.sleep(3000);

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));

        List<WebElement> allItems = driver.findElements(By.cssSelector(childLocator));
        for (WebElement item : allItems)
        {
            if (item.getText().equals(textItem))
            {
                item.click();
                break;
            }
        }
    }

    private void selectItemInHuaweiEditableDropdown(String dropdownLocator, String parentLocator, String childLocator, String textItem) throws InterruptedException {
        driver.findElement(By.cssSelector(dropdownLocator)).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector(parentLocator)).clear();
        driver.findElement(By.cssSelector(parentLocator)).sendKeys(textItem);
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("span.hwid-search-icon")).click();
        Thread.sleep(3000);

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions
                .presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));

        List<WebElement> allItems = driver.findElements(By.cssSelector(childLocator));
        for (WebElement item : allItems)
        {
            if (item.getText().equals(textItem))
            {
                item.click();
                break;
            }
        }
    }
}



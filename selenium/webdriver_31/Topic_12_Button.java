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

public class Topic_12_Button {
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

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(loginButton)));

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
    public void TC_02_Button() throws InterruptedException {
        driver.get("https://play.goconsensus.com/u5d5156df");

        By continueButton = By.xpath("//footer//button[text()='Continue']");
        Assert.assertFalse(driver.findElement(continueButton).isEnabled());

        driver.findElement(By.cssSelector("input#firstName")).sendKeys("Automation");
        driver.findElement(By.cssSelector("input#lastName")).sendKeys("Testing");
        driver.findElement(By.cssSelector("input#email")).sendKeys("AutomationTesting@gmail.net");
        driver.findElement(By.cssSelector("input#confirmEmail")).sendKeys("AutomationTesting@gmail.net");
        driver.findElement(By.cssSelector("input#phoneNumber")).sendKeys("0909001001");
        driver.findElement(By.cssSelector("input#organization")).sendKeys("AutoTest");
        Thread.sleep(2000);
        selectItemInSelectableDropdown("label[for='country']~div", "div[data-testid='select menu item']", "VA");

        Assert.assertTrue(driver.findElement(continueButton).isEnabled());
        String loginButtonEnableColor = Color.fromString(driver.findElement(continueButton).getCssValue("background-color")).asHex().toUpperCase();
        System.out.println(loginButtonEnableColor);
        Assert.assertEquals(loginButtonEnableColor, "#673AB7");

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

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}



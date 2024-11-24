package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_18_Popup_II {
    WebDriver driver;
    Actions actions;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }

    @Test
    public void TC_01_Random_Popup_In_DOM() {
        driver.get("https://vnk.edu.vn/");
        //sleepInSecond(10);

        By contentPopup = By.cssSelector("div.pum-content.popmake-content");
        if (driver.findElement(contentPopup).isDisplayed()) {
            driver.findElement(By.cssSelector("button.pum-close.popmake-close")).click();
            sleepInSecond(2);
        }

        driver.findElement(By.xpath("//button[text()='Danh sách khóa học']")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://vnk.edu.vn/lich-khai-giang/");

    }

    @Test
    public void TC_02_Random_Popup_In_DOM() {
        driver.get("https://vnk.edu.vn/");
        //sleepInSecond(10);

        findElement(By.xpath("//button[text()='Danh sách khóa học']")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://vnk.edu.vn/lich-khai-giang/");

    }

    @Test
    public void TC_03_Random_Popup_Not_In_DOM() {
        driver.get("https://www.javacodegeeks.com/");
        sleepInSecond(10);

        By newsletterPopup = By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none'])");

        // Nếu hiển thị thì close nó đi
        // Luôn chạy được vì element luôn có trong HTML
        if (driver.findElements(newsletterPopup).size() > 0 && driver.findElements(newsletterPopup).get(0).isDisplayed()) {
            System.out.println("Popup hiển thị");
            driver.findElement(By.cssSelector("div.lepopup-popup-container>div:not([style^='display:none']) div.lepopup-element-html-content>a:not([class^='lepopup'])")).click();
            sleepInSecond(3);
        } else {
            // Nếu ko hiển thị thì qua step tiếp theo (Search dữ liệu)
            System.out.println("Popup không hiển thị");
        }

        // Nhập vào search dữ liệu
        driver.findElement(By.cssSelector("input#search-input")).sendKeys("Agile Testing Explained");
        driver.findElement(By.cssSelector("button#search-submit")).click();
        sleepInSecond(3);

        Assert.assertEquals(driver.findElement(By.xpath("//a[text()='Agile Testing Explained']")).getText(), "Agile Testing Explained");

    }

    @Test
    public void TC_03_Random_Popup_In_DOM() {
        driver.get("https://dehieu.vn/");

        By formRegisterPopup = By.xpath("//h5[text()='Form Đăng Ký']/ancestor::div[contains(@class,'modal-content')]");

        if (driver.findElements(formRegisterPopup).size() > 0 && driver.findElements(formRegisterPopup).get(0).isDisplayed()) {
            System.out.println("Popup hiển thị");
            int heightBrowser = driver.manage().window().getSize().getHeight();
            if (heightBrowser > 1920) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click;", driver.findElement(By.cssSelector("button.close")));
            } else {
                driver.findElement(By.cssSelector("button.close")).click();
            }

            sleepInSecond(3);
        } else {
            // Nếu ko hiển thị thì qua step tiếp theo (Search dữ liệu)
            System.out.println("Popup không hiển thị");
        }

    }

    @Test
    public void TC_04_Random_Popup_In_DOM() {
        driver.get("https://www.kmplayer.com/home");

        By marketingPopup = By.cssSelector("div.pop-container");
        if(driver.findElement(marketingPopup).isDisplayed()){
            driver.findElement(By.cssSelector("div.pop-container div.close")).click();
            sleepInSecond(3);
        }

        actions.moveToElement(driver.findElement(By.cssSelector("nav.gnb_wrap li.pc.pc64x"))).perform();
        driver.findElement(By.cssSelector("div.gm_sub ul.pc li.pc64x")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.sub h1 ")).getText(), "KMPlayer 64X - Media Player for PC");




    }

    public WebElement findElement(By locator) {
        if (driver.findElement(By.cssSelector("div.pum-content.popmake-content")).isDisplayed()) {
            driver.findElement(By.cssSelector("button.pum-close.popmake-close")).click();
            sleepInSecond(2);
        }
        return driver.findElement(locator);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}



package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_19_Shadow_DOM {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01() {
        driver.get("https://shopee.vn/Th%E1%BB%9Di-Trang-Nam-cat.11035567");
        sleepInSecond(5);

        WebElement shadowHost = driver.findElement(By.cssSelector("shopee-banner-popup-stateful"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        if (shadowRoot.findElement(By.cssSelector("div.home-popup__content")).isDisplayed()) {
            shadowRoot.findElement(By.cssSelector("div.shopee-popup__close-btn")).click();
        }


    }

    @Test
    public void TC_02() {
        driver.get("https://automationfc.github.io/shadow-dom/");
        WebElement shadowHost = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        Assert.assertEquals(shadowRoot.findElement(By.cssSelector("span#shadow_content>span")).getText(), "some text");

        SearchContext shadowRootChildren = shadowRoot.findElement(By.cssSelector("div#nested_shadow_host")).getShadowRoot();
        Assert.assertEquals(shadowRootChildren.findElement(By.cssSelector("div#nested_shadow_content>div")).getText(), "nested text");

    }

    @Test
    public void TC_03() {

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



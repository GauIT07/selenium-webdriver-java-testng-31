package webdriver_31;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_20_ShadowDOM {
    WebDriver driver;

    @BeforeClass
    public void initialBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void TC_01_Github() {
        driver.get("https://automationfc.github.io/shadow-dom/");
        WebElement shadowHost = driver.findElement(By.cssSelector("div#shadow_host"));
        SearchContext firstShadowRoot = shadowHost.getShadowRoot();

        Assert.assertEquals(firstShadowRoot.findElement(By.cssSelector("span.info")).getText(),"some text");

        SearchContext secondShadowRoot = firstShadowRoot.findElement(By.cssSelector("div#nested_shadow_host")).getShadowRoot();
        Assert.assertEquals(secondShadowRoot.findElement(By.cssSelector("div#nested_shadow_content")).getText(),"nested text");

        Assert.assertFalse(firstShadowRoot.findElement(By.cssSelector("input[type='checkbox']")).isSelected());
    }

    @Test
    public void TC_02_Book_pwakit() throws InterruptedException {
        driver.get("https://books-pwakit.appspot.com/");
        Thread.sleep(3000);
        SearchContext firstShadowRoot = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();

        firstShadowRoot.findElement(By.cssSelector("input#input")).sendKeys("Harry Potter");

        SearchContext secondShadow = firstShadowRoot.findElement(By.cssSelector("book-input-decorator")).getShadowRoot();
        secondShadow.findElement(By.cssSelector("div.icon")).click();
        Thread.sleep(3000);

        SearchContext thirdShadow = firstShadowRoot.findElement(By.cssSelector("main.main-content>book-explore")).getShadowRoot();
        List<WebElement> listBooks = thirdShadow.findElements(By.cssSelector("ul.books>li>book-item"));

        for(WebElement book : listBooks){
            SearchContext forthShadow = book.getShadowRoot();
            System.out.println(forthShadow.findElement(By.cssSelector("h2.title")).getText());
        }

    }

    @AfterClass
    public void cleanBrowser() {
        driver.quit();
    }
}



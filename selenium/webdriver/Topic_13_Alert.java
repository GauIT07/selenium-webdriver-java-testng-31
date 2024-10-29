package webdriver;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Headers;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class Topic_13_Alert {
    WebDriver driver;

    WebDriverWait explicitWait;

    By resultText = By.cssSelector("p#result");

    String projectLocation = System.getProperty("user.dir");

    @BeforeClass
    public void beforeClass() {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void TC_01_Accept_Alert(){

        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        // Chờ cho alert present
        // Nếu trong thời gian chờ mà xuất hiện thì tự switch vào
        // Nếu hết thời gian chờ mà chưa xuất hiện mới fail
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());

        //Alert alert = driver.switchTo().alert();

        Assert.assertEquals(alert.getText(),"I am a JS Alert");
        alert.accept();
        sleepInSecond(2);

        Assert.assertEquals(driver.findElement(resultText).getText(),"You clicked an alert successfully");

    }

    @Test
    public void TC_02_Confirm_Alert(){
        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(),"I am a JS Confirm");
        alert.dismiss();
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(resultText).getText(),"You clicked: Cancel");
    }

    @Test
    public void TC_03_Prompt_Alert(){

        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert alert = explicitWait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(alert.getText(),"I am a JS prompt");

        alert.sendKeys("Automation");
        alert.accept();
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(resultText).getText(),"You entered: Automation");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        sleepInSecond(3);
        alert.dismiss();
        sleepInSecond(2);
        Assert.assertEquals(driver.findElement(resultText).getText(),"You entered: null");
    }


    @Test
    public void TC_04_Authentication_Pass_To_URL(){
        // Thư viện Alert không áp dụng cho Authentication Alert
        // ChromeDevTools Protocol (CDP) - Chrome/Egde (Chromium)

        // Cách 1: truyền thẳng user/ pass vào url
        String username = "admin";
        String password = "admin";
        driver.get("https://" + username +":" + password + "@" + "the-internet.herokuapp.com/basic_auth");
        sleepInSecond(5);
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());


        // Cách 2: Từ page A thao tác lên 1 element nó sẽ qua page B (cần phải thao tác vs Authen Alert trước)
        driver.get("https://the-internet.herokuapp.com/");

        String authenURL = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");

        // String [] authenArray = authenURL.split("//");
        // driver.get(authenArray[0] + "//" + username + ":" + password + "@" + authenArray[1]);

        driver.get(getAuthenAlertByUrl(authenURL, username, password));

        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());


    }

    @Test
    public void TC_05_Authentication_AutoIT() throws IOException {
        // Cách 2: Chạy trên Windows(AutoIT)
        // Mac/ Linux (ko work)
        // Mỗi browser sẽ cần 1 đoạn script khác nhau
        // Thực thi đoạn code AutoIT để chờ Alert xuất hiện
        System.out.println(projectLocation);
        Runtime.getRuntime().exec(new String[]{projectLocation + "\\autoIT\\authen_firefox.exe", "admin", "admin"});

        driver.get("https://the-internet.herokuapp.com/basic_auth");
        sleepInSecond(3);
        Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]")).isDisplayed());

    }

    @Test
    public void TC_06_Authentication_Selenium_4x() {
        // Thư viện Alert không áp dụng cho Authentication Alert
        // ChromeDevTools Protocol (CDP) - Chrome/Egde (Chromium)
        // Cốc Cốc / Opera - Work Around

        // Get DevTool object
        DevTools devTools = ((HasDevTools) driver).getDevTools();

        // Start new session
        devTools.createSession();

        // Enable the Network domain of DevTools
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Encode user
        Map<String, Object> headers = new HashMap<String, Object>();
        String basicAuthen = "Basic" + new String(new Base64().encode(String.format("%s:%s", "admin", "admin").getBytes()));
        headers.put("Authorization", basicAuthen);

        // Set to Header
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));

        driver.get("https://the-internet.herokuapp.com/basic_auth");
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }

    public String getAuthenAlertByUrl (String url, String username, String password) {

        String[] authenArray = url.split("//");
        return authenArray[0] + "//" + username + ":" + password + "@" + authenArray[1];
    }

    public void sleepInSecond(long timeInSecond) {
        try {
            Thread.sleep(timeInSecond * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}



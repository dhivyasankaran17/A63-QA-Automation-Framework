import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.util.Map;

import static java.sql.DriverManager.getDriver;

public class BaseTest {
    public static WebDriver driver = null;
    public static WebDriverWait wait = null;
    public Wait<WebDriver> fluentWait;
    public static String url = null;
    public static Actions actions = null;
    public static String homePageURL = null;
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    @BeforeMethod
    @Parameters({"BaseURL", "browser"})
    public void launchBrowser(String baseURL, String browser) throws MalformedURLException, URISyntaxException {
        threadDriver.set(pickBrowser(browser));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        fluentWait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(200));
        navigateToPage(baseURL);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    public void tearDown () {
            threadDriver.get().close();
            threadDriver.remove();
        }
    public void navigateToPage(String url){
            getDriver().get(url);
    }
    public static WebDriver getDriver(){
        return threadDriver.get();
    }
    public static WebDriver pickBrowser(String browser) throws MalformedURLException, URISyntaxException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.86.23:4444";
        switch(browser){
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();
            case "Microsoft Edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);
            case "grid-edge":
                caps.setCapability("browserName","MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "grid-chrome":
                caps.setCapability("browserName", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(),caps);
            case "cloud":
                return lambdaTest();
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("profile.default_content_setting_values.notifications", 1);
                //1-Allow, 2-Block, 0-default
                chromeOptions.setExperimentalOption("prefs", prefs);
                return driver = new ChromeDriver(chromeOptions);

        }
    }
    // Class 25 on Cloud Execution below
    public static WebDriver lambdaTest() throws MalformedURLException, URISyntaxException {
        String hubUrl = "https://hub.lambdatest.com/wd/hub";
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("129");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "divvu2008");
        ltOptions.put("accessKey", "p0Sv9tqRjK7eOPcBGuRtarm2yvwRQ8dIvaEFI3h58T93pDSy6V");
        ltOptions.put("project", "Test2");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);
        return new RemoteWebDriver(new URI(hubUrl).toURL(), browserOptions);
    }

}
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait = null;
    public String url = null;
    public String homePageURL = null;
    @DataProvider(name="IncorrectLoginData")
    public static Object[][] getDataFromDataProviders(){
        return new Object[][]{
                {"invalid@testpro.io","invalidpassword"},
                {"demo@testpro.io",""},
                {"",""}
        };
    };

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchClass(String BaseURL){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        url = BaseURL;
        homePageURL = "https://qa.koel.app/#!/home";
        navigateToPage();
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
    public void navigateToPage(){
        driver.get(url);
    }
    public void provideEmail(String email){
        WebElement emailField = driver.findElement(By.cssSelector("input[type ='email']"));
        emailField.clear();
        emailField.sendKeys(email);
    }
    public void providePassword(String password){
        WebElement passwordField = driver.findElement(By.cssSelector("input[type ='password']"));
        passwordField.clear();
        passwordField.sendKeys(password);

    }
    public void clickLoginBtn() throws InterruptedException{
        WebElement loginBtn = driver.findElement(By.cssSelector("Button[type='submit']"));
        loginBtn.click();
        Thread.sleep(2000);
    }
}
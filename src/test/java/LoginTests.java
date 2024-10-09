import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword() throws InterruptedException {
        provideEmail("");
        providePassword("");
        clickLoginBtn();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        provideEmail("demo@testpro.io");
        providePassword("te$t$tudent");
        clickLoginBtn();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), url);

    }
}

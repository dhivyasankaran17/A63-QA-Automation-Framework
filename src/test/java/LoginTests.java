import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {
    @Test
    public void loginEmptyEmailPassword(String email, String password) throws InterruptedException {
        provideEmail(email);
        providePassword(password);
        clickLoginBtn();
        //Assert.assertEquals(driver.getCurrentUrl(), homePageURL);
    }

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        provideEmail("dhivya.sankaran@testpro.io");
        providePassword("v5eUH9H2");
        clickLoginBtn();
        Assert.assertEquals(driver.getCurrentUrl(), homePageURL);

    }
}

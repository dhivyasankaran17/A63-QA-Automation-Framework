import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pgFactoryPages.HomePage;
import pgFactoryPages.LoginPage;

public class LoginTests extends BaseTest {
    @Test
    public void loginValidEmailPassword() throws InterruptedException{
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        loginPage.provideEmail("dhivya.sankaran@testpro.io");
        loginPage.providePassword("v5eUH9H2");
        loginPage.clickSubmit();
        Thread.sleep(1000);
        WebElement avatarIcon = getDriver().findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";
        // Steps
        pages.LoginPage loginPage = new pages.LoginPage(getDriver());
        loginPage.login("dhivya.sankaran@testpro.io", "v5eUH9H2");
        // Expected Result
            Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl); // https://qa.koel.app/
        }


    @Test
    public void loginValidEmailEmptyPassword() throws InterruptedException {

        //navigateToPage();
        String expectedUrl = "https://qa.koel.app/";
        pages.LoginPage loginPage = new pages.LoginPage(getDriver());
        loginPage.login("dhivya.sankaran@testpro.io", "");
        // Expected Result
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl); //https://qa.koel.app/
    }
}
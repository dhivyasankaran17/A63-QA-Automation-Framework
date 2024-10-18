import POM.HomePage;
import POM.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework22 extends BaseTest {

    @Test
    public void renamePlaylist() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.login();


        homePage.doubleClickPlaylist();
        homePage.renameExistingPlaylist();

        Assert.assertEquals(homePage.renamedPlaylistMsg(), "Updated playlist \"RenamedPlaylistNew.\"");
    }
}




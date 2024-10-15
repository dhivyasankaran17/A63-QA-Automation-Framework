import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Homework20 extends BaseTest{
    @Test
    public void deletePlaylist(){
        String expectedDeletedPlaylistMsg = "Deleted playlist \"Playlist1.\"";
        provideEmail("dhivya.sankaran@testpro.io");
        providePassword("v5eUH9H2");
        clickLoginBtn();

        if(doesPlaylistExist()) {
            // If there is a playlist then delete it
            selectPlaylist();

        }
        else
        {
            createPlaylist();
            selectPlaylist();
        }
        By locator = By.xpath("//div[@class='success show']");
        Assert.assertTrue(driver.findElements(locator).size()>0, "Playlist was deleted");

    }
    public boolean doesPlaylistExist()
    {
        By playlistLocator = By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a");
        if(driver.findElements(playlistLocator).size()>0){
            return true;
        }
        return false;
    }
    public void createPlaylist() {
        WebElement createPlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//section[@id ='playlists']//i[@data-testid='sidebar-create-playlist-btn']")));
        createPlaylist.click();
        WebElement createSimplePlaylist = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']")));
        createSimplePlaylist.click();
        WebElement playlistField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='name']")));
        playlistField.clear();
        playlistField.sendKeys("Playlist1" + Keys.ENTER);

    }

    public void selectPlaylist() {

        WebElement playList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[@id='playlists']//a[contains(text(), 'Playlist1')]")));
        playList.click();
        WebElement deletePlaylistBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.del")));
        deletePlaylistBtn.click();

    }
}


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {
        //soundbarElement = "class.side player-controls";
        provideEmail("dhivya.sankaran@testpro.io");
        providePassword("v5eUH9H2");
        clickLoginBtn();

        selectPlaylist();
        clickDeletePlaylist();

    }

    public void clickDeletePlaylist() {
        WebElement deletePlaylistBtn = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        deletePlaylistBtn.click();
    }

    public void selectPlaylist()  {

        WebElement playList = driver.findElement(By.cssSelector("//section[@id='playlists'] //a[contains(text(), 'Playlist1')]"));
        playList.click();

    }
}

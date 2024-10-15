import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework19 extends BaseTest{
    @Test
    public void deletePlaylist() throws InterruptedException {
        String expectedDeletedPlaylistMsg = "Deleted playlist \"Playlist1.\"";
        provideEmail("dhivya.sankaran@testpro.io");
        providePassword("v5eUH9H2");
        clickLoginBtn();
        Thread.sleep(2000);
        if(!doesPlaylistExist()) {
            // If there is a playlist then delete it
            createPlaylist();
        }

        selectPlaylist();

        Assert.assertEquals(getDeletedPlaylistMsg(), expectedDeletedPlaylistMsg);

    }
    public boolean doesPlaylistExist()
    {
        // See if there is a playlist
        By playlistLocator = By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a");
        return !driver.findElements(playlistLocator).isEmpty();
    }
    public void createPlaylist() throws InterruptedException{
        WebElement createPlaylist = driver.findElement(By.xpath("//section[@id ='playlists']//i[@data-testid='sidebar-create-playlist-btn']"));
        createPlaylist.click();
        Thread.sleep(2000);
        WebElement createSimplePlaylist = driver.findElement(By.xpath("//li[@data-testid='playlist-context-menu-create-simple']"));
        createSimplePlaylist.click();
        Thread.sleep(2000);
        WebElement playlistField = driver.findElement(By.xpath("//input[@name='name']"));
        playlistField.clear();
        playlistField.sendKeys("Playlist1" + Keys.ENTER);
        Thread.sleep(2000);

    }

    public void selectPlaylist() throws InterruptedException {

        WebElement playList = driver.findElement(By.xpath("//section[@id='playlists']//a[contains(text(), 'Playlist1')]"));
        playList.click();
        Thread.sleep(2000);
        WebElement deletePlaylistBtn = driver.findElement(By.cssSelector("button.del"));
        deletePlaylistBtn.click();
        Thread.sleep(2000);
        /*WebElement deleteConfirmationBtn = driver.findElement(By.cssSelector("button.ok"));
        deleteConfirmationBtn.click();
        Thread.sleep(2000);*/
    }
    public String getDeletedPlaylistMsg(){
        WebElement deleteMsg = driver.findElement(By.cssSelector("div.success.show"));
        return deleteMsg.getText();
    }
}

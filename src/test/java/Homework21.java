import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework21 extends BaseTest{
    String newPlaylistName = "RenamedPlaylist";
    @Test
    public void renamePlaylist(){
        String updatedPlaylistMsg = "Updated playlist \"RenamedPlaylist.\"";
        provideEmail("dhivya.sankaran@testpro.io");
        providePassword("v5eUH9H2");
        clickLoginBtn();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        doubleClickPlaylist();
        renameExistingPlaylist();

        Assert.assertEquals(getRenamePlaylistMsg(), updatedPlaylistMsg);
    }


    public void doubleClickPlaylist(){
        Actions actions = new Actions(driver);
        WebElement playlistElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a")));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        actions.doubleClick(playlistElement).perform();

    }

    public void renameExistingPlaylist() {

        WebElement playListInputField = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[name='name']")));
        playListInputField.sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        playListInputField.sendKeys(newPlaylistName);
        playListInputField.sendKeys(Keys.ENTER);

    }
    public String getRenamePlaylistMsg(){
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }
}


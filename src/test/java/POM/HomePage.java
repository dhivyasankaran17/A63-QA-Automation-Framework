package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
    public HomePage(WebDriver giveDriver){
        super(giveDriver);
    }
    By playlistElement = By.xpath("//*[@id=\"playlists\"]/ul/li[3]/a");
    By playListInputField = By.cssSelector("[name='name']");
    By notification = By.xpath("//div[@class=\"success show\"]");
    public void doubleClickPlaylist(){
        actions.doubleClick(findElement(playlistElement)).perform();
    }
    public void renameExistingPlaylist(){
        findElement(playListInputField).sendKeys(Keys.chord(Keys.CONTROL,"A",Keys.BACK_SPACE));
        findElement(playListInputField).sendKeys("RenamedPlaylistNew" + Keys.ENTER);
    }
    public String renamedPlaylistMsg(){
        return findElement(notification).getText();
    }

}

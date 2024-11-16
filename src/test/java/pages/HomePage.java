package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver){
        super(givenDriver);
    }

    // Locators
    private final By userAvatarIcon = By.xpath("//*[@id='userBadge']/a[1]/img");
    private final By allSongsList = By.cssSelector("li a.songs");

    // PlaylistActions locators
    private final By clickPlaylist = By.cssSelector(".playlist:nth-child(3)");
    private final By deletePlaylistAction = By.cssSelector(".btn-delete-playlist");
    private final By clickOK = By.cssSelector("button.ok");
    private final By successPopUp = By.cssSelector("div.success.show");

    // Methods
    public WebElement getUserAvatar() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userAvatarIcon));
    }
    public void chooseAllSongsList() {
        findElement(allSongsList).click();
    }

    // Page Methods from PlaylistActions
    public void selectPlayList() {
        WebElement clickPlaylistElement = wait.until(ExpectedConditions.elementToBeClickable(clickPlaylist));
        scrollToElement(clickPlaylistElement); // Reusing the scrollToElement method from PlaylistActions
        clickPlaylistElement.click();
    }


    public void deletePlaylist() {
        WebElement deletePlaylistElement = wait.until(ExpectedConditions.elementToBeClickable(deletePlaylistAction));
        deletePlaylistElement.click();
    }
    public void clickOK(){
        WebElement clickOKButton = wait.until(ExpectedConditions.visibilityOfElementLocated(clickOK));
        clickOKButton.click();
    }

    public WebElement successPopUpBox() {
        WebElement successPopUpElement = wait.until(ExpectedConditions.visibilityOfElementLocated(successPopUp));
        System.out.println("Success Popup Displayed");
        return successPopUpElement;
    }

    // Utility method to scroll to element using Actions class
    private void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}


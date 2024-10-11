import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 extends BaseTest{
    @Test
    public void playSong() throws InterruptedException{
        //soundbarElement = "class.side player-controls";
        provideEmail("dhivya.sankaran@testpro.io");
        providePassword("v5eUH9H2");
        clickLoginBtn();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        playNextBtn();
        validateSoundBar();
        Assert.assertTrue(validateSoundBar());

    }

    public boolean validateSoundBar() {
        WebElement soundBar = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return soundBar.isDisplayed();
    }

    public void playNextBtn() throws InterruptedException{

        WebElement playNext = driver.findElement(By.cssSelector("//i[@data-testid ='play-next-btn']"));
        playNext.click();
        Thread.sleep(2000);

    }
}

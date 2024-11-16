package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);

    }
    // LOCATORS
    private By emailField = By.cssSelector("input[type='email']");
    private By passwordField = By.cssSelector("input[type='password']");
    private By submitBtn = By.cssSelector("button[type='submit']");
    // PAGE METHODS
    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }

    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);
    }

    public void clickSubmit() {
        findElement(submitBtn).click();
    }
    public void login(String username, String password) {
        provideEmail(username);
        providePassword(password);
        clickSubmit();
    }

    // Default login method
    public void login() {
        login("dhivya.sankaran@testpro.io", "v5eUH9H2");
    }
}

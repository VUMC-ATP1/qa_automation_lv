package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By loginUsername = By.id("user-name");
    private final By loginPassword = By.id("password");
    private final By loginButton = By.id("login-button");

    public WebElement getLoginUsername() {
        return driver.findElement(loginUsername);
    }

    public WebElement getLoginPassword() {
        return driver.findElement(loginPassword);
    }

    public WebElement getLoginButton() {
        return driver.findElement(loginButton);
    }

    public void setLoginUsername() {
        getLoginUsername().sendKeys("standard_user");
    }

    public void setLoginPassword() {
        getLoginPassword().sendKeys("secret_sauce");
    }

    public void setLoginButton() {
        getLoginButton().click();
    }
}

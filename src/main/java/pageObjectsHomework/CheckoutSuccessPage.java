package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {
    private WebDriver driver;

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By titleName = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private final By thankYouHeader = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");
    private final By ponyImg = By.xpath("//*[@id=\"checkout_complete_container\"]/img");
    private final By backButton = By.id("back-to-products");

    public WebElement getBackButton() {
        return driver.findElement(backButton);
    }
    public void setBackButton() {
        getBackButton().click();
    }

    public WebElement getTitleName() {
        return driver.findElement(titleName);
    }
    public  WebElement getThankYouHeader() {
        return driver.findElement(thankYouHeader);
    }
    public WebElement getPonyImg() {
        return driver.findElement(ponyImg);
    }


}

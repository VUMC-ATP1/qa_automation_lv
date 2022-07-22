package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By zipCode = By.id("postal-code");
    private final By cancelButton = By.id("cancel");
    private final By nextButton = By.id("continue");


    public void checkoutPageFillIn(String name, String surname, String postalCode) {
        driver.findElement(firstName).sendKeys(name);
        driver.findElement(lastName).sendKeys(surname);
        driver.findElement(zipCode).sendKeys(postalCode);
    }

    public WebElement getFirstName() {
        return driver.findElement(firstName);
    }
    public void setFirstName() {
        getFirstName().sendKeys("Laura");
    }
    public WebElement getLastName() {
        return driver.findElement(lastName);
    }
    public void setLastName() {
        getLastName().sendKeys("Valtere");
    }
    public WebElement getZipCode() {
        return driver.findElement(zipCode);
    }
    public void setZipCode() {
        getZipCode().sendKeys("LV-1084");
    }
    public WebElement getCancelButton() {
        return driver.findElement(cancelButton);
    }
    public void setCancelButton() {
        getCancelButton().click();
    }
    public WebElement getNextButton() {
        return driver.findElement(nextButton);
    }
    public void setNextButton() {
        getNextButton().click();
    }

}

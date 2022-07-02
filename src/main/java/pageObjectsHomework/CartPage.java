package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }
    private final By inventoryItem = By.id("item_2_title_link");
    private final By itemPrice = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div/text()[2]");
    private final By removeButton = By.id("remove-sauce-labs-onesie");
    private final By shoppingButton = By.id("continue-shopping");
    private final By checkoutButton = By.id("checkout");

    public WebElement getItemPrice() {
        return driver.findElement(itemPrice);
    }
    public WebElement getInventoryItem() {
        return driver.findElement(inventoryItem);
    }
    public void setInventoryItem() {
        getInventoryItem().click();
    }
    public WebElement getRemoveButton() {
        return driver.findElement(removeButton);
    }
    public void setRemoveButton() {
        getRemoveButton().click();
    }
    public WebElement getShoppingButton() {
        return driver.findElement(shoppingButton);
    }
    public void setShoppingButton() {
        getShoppingButton().click();
    }
    public WebElement getCheckoutButton() {
        return driver.findElement(checkoutButton);
    }
    public void setCheckoutButton() {
        getCheckoutButton().click();
    }








}

package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {

    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By backpack = By.id("add-to-cart-sauce-labs-backpack");
    private final By bikeLight = By.id("add-to-cart-sauce-labs-bike-light");
    private final By boltShirt = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private final By fleeceJacket = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By onesie = By.id("add-to-cart-sauce-labs-onesie");
    private final By allTheThingsShirt = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");

    private final By checkCart = By.id("shopping_cart_container");

    public WebElement getBackpack() {
        return driver.findElement(backpack);
    }
    public void setBackpack(){
        getBackpack().click();
    }
    public WebElement getBikeLight() {
        return driver.findElement(bikeLight);
    }
    public void setBikeLight(){
        getBikeLight().click();
    }
    public WebElement getBoltShirt() {
        return driver.findElement(boltShirt);
    }
    public void setBoltShirt(){
        getBoltShirt().click();
    }
    public WebElement getFleeceJacket() {
        return driver.findElement(fleeceJacket);
    }
    public void setFleeceJacket(){
        getFleeceJacket().click();
    }
    public WebElement getOnesie() {
        return driver.findElement(onesie);
    }
    public void setOnesie(){
        getOnesie().click();
    }
    public WebElement getAllTheThingsShirt() {
        return driver.findElement(allTheThingsShirt);
    }
    public void setAllTheThingsShirt(){
        getAllTheThingsShirt().click();
    }

    public WebElement getCheckCart() {
        return driver.findElement(checkCart);
    }

    public void setCheckCart() {
        getCheckCart().click();
    }



}

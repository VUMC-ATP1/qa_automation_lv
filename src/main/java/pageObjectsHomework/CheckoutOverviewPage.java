package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutOverviewPage {

    private WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By itemName = By.id("item_2_title_link");
    private final By itemPrice = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
    private final By cancelButton = By.id("cancel");
    private final By finishButton = By.id("finish");

    public WebElement getItemName() {
        return driver.findElement(itemName);
    }
   public WebElement getItemPrice() {
        return driver.findElement(itemPrice);
   }
   public WebElement getCancelButton() {
        return driver.findElement(cancelButton);
   }
   public void setCancelButton() {
        getCancelButton().click();
   }
   public WebElement getFinishButton() {
        return driver.findElement(finishButton);
   }
   public void setFinishButton() {
        getFinishButton().click();
   }



}

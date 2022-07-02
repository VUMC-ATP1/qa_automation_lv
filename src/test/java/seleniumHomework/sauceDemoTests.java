package seleniumHomework;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjectsHomework.*;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

@Log4j
public class sauceDemoTests {

    private final String SAUCE_URL = "https://www.saucedemo.com/";

    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutSuccessPage checkoutSuccessPage;

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        log.info("Initializing Chromedriver");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutSuccessPage = new CheckoutSuccessPage(driver);
    }

    @Test
    public void sauceDemoTestNo1() {
        driver.get(SAUCE_URL);
        loginPage.setLoginUsername();
        loginPage.setLoginPassword();
        loginPage.setLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
        inventoryPage.setOnesie();
        inventoryPage.setCheckCart();
        Assert.assertEquals(cartPage.getInventoryItem().getText(), "Sauce Labs Onesie");
        cartPage.setCheckoutButton();
        checkoutPage.setFirstName();
        checkoutPage.setLastName();
        checkoutPage.setZipCode();
        checkoutPage.setNextButton();
        Assert.assertEquals(checkoutOverviewPage.getItemName().getText(), "Sauce Labs Onesie");
        checkoutOverviewPage.setFinishButton();
        Assert.assertEquals(checkoutSuccessPage.getTitleName().getText(), "CHECKOUT: COMPLETE!");
        Assert.assertEquals(checkoutSuccessPage.getThankYouHeader().getText(), "THANK YOU FOR YOUR ORDER");
        checkoutSuccessPage.getPonyImg();
        checkoutSuccessPage.setBackButton();
    }

    @Test
    public void sauceDemoTestNo2() {
        driver.get(SAUCE_URL);
        loginPage.setLoginUsername();
        loginPage.setLoginPassword();
        loginPage.setLoginButton();
        inventoryPage.setCheckCart();
        cartPage.setCheckoutButton();
        checkoutPage.setNextButton();
        Assert.assertEquals("Error: First Name is required", "Error: First Name is required");
        checkoutPage.setFirstName();
        checkoutPage.setNextButton();
        Assert.assertEquals("Error: Last Name is required", "Error: Last Name is required");
        checkoutPage.setLastName();
        checkoutPage.setNextButton();
        Assert.assertEquals("Error: Postal Code is required", "Error: Postal Code is required");
        checkoutPage.setZipCode();
        checkoutPage.setNextButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
    }


    @AfterMethod
    public void tearDown() {
        log.info("Closing Chromedriver");
        log.debug("DEBUG: Closing");
        driver.close();
    }

}
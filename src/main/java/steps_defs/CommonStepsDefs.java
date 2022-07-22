package steps_defs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjectsHomework.*;
import page_object.AuthorizationPage;
import utils.WebDriverManager;

public class CommonStepsDefs {

    WebDriver driver = new WebDriverManager().getInstance();
    AuthorizationPage authorizationPage = new AuthorizationPage();
    CartPage cartPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutPage checkoutPage;
    CheckoutSuccessPage checkoutSuccessPage;
    InventoryPage inventoryPage;



    @Given("I have navigate to login page")
    public void navigateToLoginPage() {
        driver.get("https:www.saucedemo.com/");
    }

    @When("I login with {string} and {string}")
    public void authorize(String username, String password) {
        authorizationPage.authorizeUser(username, password);
    }

    @Then("I am successfully logged in")
    public void checkSuccessLogin() {
        Assertions.assertThat(driver.getCurrentUrl()).containsIgnoringCase("inventory.html");
    }

    @Then("I see login error message {string}")
    public void checkErrorMessage(String value) {
//        Assertions.assertThat(authorizationPage.getErrorMessage().getText()).isEqualTo(value);
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText(), value);
    }


    @When("I put into cart a Sauce Labs Onesie")
    public void iPutIntoCartASauceLabsBackpack() {
//        inventoryPage.setOnesie();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-onesie\"]")).click();

    }

    @Then("I go to shopping cart")
    public void iGoToShoppingCart() {
//        inventoryPage.setCheckCart();
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();

    }

    @And("I check that {string} is successfully added")
    public void iCheckThatSauceLabsBackpackIsSuccessfullyAdded(String onesie) {
//        Assertions.assertThat(cartPage.getInventoryItem().getText()).isEqualTo(onesie);
        Assertions.assertThat(driver.findElement(By.xpath("//*[@id=\"item_2_title_link\"]/div")).getText().contentEquals(onesie));

    }
    @Then("I press the Checkout button")
    public void iPressTheCheckoutButton() {
//        checkoutPage.setNextButton();
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();

    }

    @When("I fill fields with {string}, {string} and {string}")
    public void iFillFieldsWithFirstNameLastNameAndZipPostalCode(String firstName, String lastName, String postalCode) {
//        checkoutPage.checkoutPageFillIn(firstName, lastName, postalCode);
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys(firstName);
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys(lastName);
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys(postalCode);

    }

    @Then("I press the Continue button")
    public void iPressTheContinueButton() {
//        cartPage.setCheckoutButton();
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    }
    @And("I check that the added items are successfully added")
    public void iCheckThatTheAddedItemsAreSuccessfullyAdded() {
        Assertions.assertThat(driver.findElement(By.xpath("//*[@id=\"item_2_title_link\"]/div")).getText()).isEqualTo("Sauce Labs Onesie");
    }

    @When("I press the Finish button")
    public void iPressTheFinishButton() {
//        checkoutOverviewPage.setFinishButton();
        driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();

    }
    @Then("I check that {string} successfully")
    public void iCheckThatCHECKOUTCOMPLETESuccessfully(String thankYou) {
        Assertions.assertThat(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText()).isEqualTo(thankYou);
    }


    @And("I press the Back Home button")
    public void iPressTheBackHomeButton() {
//        checkoutSuccessPage.setBackButton();
        driver.findElement(By.xpath("//*[@id=\"back-to-products\"]")).click();
    }


    @When("I do not fill any of the field and I press the Continue button")
    public void iDoNotFillAnyOfTheFieldAndIPressTheContinueButton() {
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    }

    @Then("I see the error message {string}")
    public void iSeeTheErrorMessageErrorFirstNameIsRequired(String value) {
        Assertions.assertThat(driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]")).getText()).isEqualTo(value);

    }

    @When("I fill in the First Name field with {string}")
    public void iFillInTheFirstNameFieldWithLaura(String firstName) {
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys(firstName);

    }

    @When("I fill in the Last Name field with {string}")
    public void iFillInTheLastNameFieldWithValtere(String lastName) {
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys(lastName);
    }
}

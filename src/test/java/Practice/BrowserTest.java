package Practice;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_object.MainPage;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

@Log4j
public class BrowserTest {

    private final String GOOGLE_URL = "https://www.google.lv/";
    private final String LOCAL_FILE = "file://" + this.getClass().getResource("/elements.html").getPath();

    ChromeDriver driver;
    MainPage mainPage;

    WebDriverWait wait;

    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }

    @BeforeMethod(alwaysRun = true)
        public void openBrowser() {
        log.info("Initializing Chromedriver");
            driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            driver.get(GOOGLE_URL);
//            driver.get(LOCAL_FILE);
        }

    @Test(enabled = false)  //test ignored
    public void chromeDriverTest() {
        Assert.assertEquals(driver.getTitle(), "Google");
        Assert.assertEquals(driver.getCurrentUrl(), GOOGLE_URL);
    }

    @Test(enabled = false)
    public void elementTest() {
        driver.get(LOCAL_FILE);
        driver.findElement(By.id("fNameID")).sendKeys("Hello");
        driver.findElement(By.id("lNameID")).sendKeys("Brr");
        driver.findElement(By.id("aboutMeID")).sendKeys("Brr1");
        driver.findElement(By.id("checkDataID")).click();
        driver.findElement(By.id("studentID")).click();
        driver.findElement(By.id("socialLinkID")).click();
        driver.findElement(By.id("colorsID")).click();
        driver.findElement(By.id("javaID")).click();
        driver.findElement(By.id("pythonID")).click();

        WebElement nameField = driver.findElement(By.id("fNameID"));
        nameField.sendKeys("John");

        WebElement surnameField = driver.findElement(By.id("lNameID"));
        surnameField.sendKeys("Doe");


        Select universityDropDown = new Select(driver.findElement(By.name("universities")));
        universityDropDown.selectByValue("RSU");
        universityDropDown.selectByVisibleText("Rīgas Tehniskā universitāte");
        Assert.assertEquals(universityDropDown.getFirstSelectedOption().getText(), "Rīgas Tehniskā universitāte");
    }


    @Test
    public  void pageObject() {
        driver.get((LOCAL_FILE));
//        mainPage = new MainPage(driver); //this row can be deleted if add it to @BeforeMethod
        mainPage.setFirstNameField("John");
        System.out.println();
    }

    @Test
    public void testElements() {
        driver.get((LOCAL_FILE));
        mainPage.getFirstNameField().sendKeys("John");
        mainPage.selectStudentCheckBox(); //same as next one
//        mainPage.setStudentCheckBox();
        mainPage.getUniversities().selectByValue("RTU"); //same as next one
//        mainPage.setUniversities();
        Assert.assertEquals(mainPage.getUniversities().getFirstSelectedOption().getText(), "Rīgas Tehniskā universitāte");
        mainPage.setJavaRadioButton();

        //Selenium Waits: "Explicit Wait -> WebDriver Wait"
        mainPage.setClickOnMeButton();
        wait.until(ExpectedConditions.textToBePresentInElement(mainPage.getCheckResult(), "Viss ir labi!"));

        //Selenium Waits: "Implicit Wait -> Timeouts()"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertEquals(driver.findElement(By.xpath("/html/body/form/table/tbody/tr[7]/td[1]")).getText(), "Universitātes"); //checking if element exists
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Closing Chromedriver");
        log.debug("DEBUG: Closing");
//        driver.close();
    }

}

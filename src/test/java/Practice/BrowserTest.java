package Practice;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

@Log4j
public class BrowserTest {
    ChromeDriver driver;

    private final String GOOGLE_URL = "https://www.google.lv/";

    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }

    @BeforeMethod(alwaysRun = true)
        public void openBrowser() {
        log.info("Initializing Chromedriver");
            driver = new ChromeDriver();
            driver.get(GOOGLE_URL);
        }

    @Test
    public void chromeDriverTest() {
        Assert.assertEquals(driver.getTitle(), "Google");
        Assert.assertEquals(driver.getCurrentUrl(), GOOGLE_URL);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Closing Chromedriver");
        log.debug("DEBUG: Closing");
//        driver.quit();
        driver.close();
    }

//    @Test
//    public void chromeDriverTest() {
//        ChromeDriver driver = new ChromeDriver();
//        driver.get("https://google.lv"); //if test fails, add chrome driver into project directory with right version (chrome->help->about chrome->version)
//        driver.close();
//    }

    @Test
    public void chromeDriverTest2() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://google.lv");
        driver.close();
    }
}

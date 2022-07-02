package page_object;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;


public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstNameField = By.id("fNameID");
    private final By clickOnMeButton = By.id("checkDataID"); // or = By.xpath("//button[@id=CheckDataID]");
    private final By checkResult = By.id("checkDataResultID");
    private final By studentCheckBox = By.id("studentID"); // or = By.xpath("//input[@id=studentID and @type='checkbox']);
    private final By universities = By.id("universitiesID"); //or = By.name("universities");
    private final By javaRadioButton = By.id("javaID");


    public WebElement getCheckResult() {
        return driver.findElement(checkResult);
    }

    public WebElement getFirstNameField() {
        return driver.findElement(firstNameField);
    }
    public void setFirstNameField (String value) {
//        driver.findElement(firstNameField).sendKeys(value); //same as next line
        getFirstNameField().sendKeys(value);
    }

    public WebElement getClickOnMeButton() {
        return driver.findElement(clickOnMeButton);
    }

    //checkbox with click without making Getter/Setter
    public void selectStudentCheckBox() {
        WebElement element = driver.findElement(studentCheckBox);
        element.click();
        Assert.assertTrue(element.isDisplayed()); //to remove red Assert text need to remove import Assert and in prom.xml delete <scope>test</scope> in org.testng
    }

    public WebElement getStudentCheckBox() {
        return driver.findElement(studentCheckBox);
    }

    public Select getUniversities() {
        return new Select(driver.findElement(universities));
    }

    public List<WebElement> getUniversitiesList() {
        return getUniversities().getOptions();
    }

    public WebElement getJavaRadioButton() {
        return driver.findElement(javaRadioButton);
    }
    public void setClickOnMeButton() {
        getClickOnMeButton().click();
    }
    public void setStudentCheckBox() {
        getStudentCheckBox().click();
    }
    public void setUniversities() {
        getUniversities().selectByValue("RTU");
    }
    public void setJavaRadioButton() {
        getJavaRadioButton().click();
    }
}

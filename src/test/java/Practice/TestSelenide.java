package Practice;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideConfig;
import com.codeborne.selenide.webdriver.EdgeDriverFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.files.DownloadActions.click;

public class TestSelenide {
    @Test
    public void testSelenide() {
        Selenide.open("https://www.lu.lv");
//        $(By.xpath("//ul[@class='mainMenu__menu']//li//button")).click();
//        $$(By.xpath("//ul[@class='mainMenu__menu']//li//button"));
        $(By.xpath("//ul[@class='mainMenu__menu']//li//button"))
                .shouldBe(appear) // alt+enter to hide word Condition
                .shouldNot(be(disabled))
                .shouldBe(exactText("Gribu studēt"))
        .click();
        System.out.println();
    }







}

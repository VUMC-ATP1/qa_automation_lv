package hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.WebDriverManager;

public class Hooks {
    //Java Singleton pattern


    @After
    public void tearDown() {
        WebDriverManager.closeBrowser();
    }


}

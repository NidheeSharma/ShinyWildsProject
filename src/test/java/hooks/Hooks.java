package hooks;

import CommonFile.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    BasePage basePage = new BasePage();

    @Before
    public void setUp(){
        basePage.luanchURL("https://www.shinywilds5.com/en/");
    }

    @After
    public void tearDown(){
        basePage.closeDriver();
    }
}

package hooks;

import CommonFile.BasePage;
import Utils.ConfigManager;
import Utils.ExtentManager;
import Utils.JsonReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.*;
import model.LoginDataWrapper;
import model.SignupDataWrapper;

public class Hooks {

    BasePage basePage = new BasePage();
    String site = ConfigManager.getSite();
    String baseUrl = JsonReader.getValueFromConfig(site,"baseUrl","src/test/TestData/urlConfig.json");



    // Extent Report setup
    public static ExtentReports extent;
    public static ExtentTest test;
    public static LoginDataWrapper loginDataWrapper;
    public static SignupDataWrapper signupDataWrapper;

    static {
        try {
            loginDataWrapper = JsonReader.getLoginData("src/test/TestData/loginData.json");
            System.out.println("Login data loaded using POJO.");
        } catch (Exception e) {
            System.out.println("Failed to initialize loginDataWrapper: " + e.getMessage());
        }
    }

    static {
        try {
            signupDataWrapper = JsonReader.getSignupData("src/test/TestData/signupData.json");
            System.out.println("Signup data loaded using POJO.");
        }catch (Exception e){
            System.out.println("Failed to initialize signupDataWrapper: " + e.getMessage());
        }
    }


    @BeforeAll
    public static void setUpReport() {
        extent = ExtentManager.getInstance();
    }

    @Before
    public void setUpScenario(Scenario scenario) throws InterruptedException {
        basePage.luanchURL(baseUrl);

        // Start a new test in Extent Report
        test = extent.createTest(scenario.getName());
    }

    @After
    public void tearDownScenario(Scenario scenario){

        // Log pass/fail to Extent Report
        if (scenario.isFailed()) {
            test.fail("Scenario Failed: " + scenario.getName());
        } else {
            test.pass("Scenario Passed");
        }

        // Close browser
        basePage.closeDriver();
    }

    @AfterAll
    public static void tearDownReport() {
        extent.flush();
    }
}

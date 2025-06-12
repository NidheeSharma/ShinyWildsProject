import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/Features"},
        glue = {"Steps","hooks"},
        tags = "@login"
)

public class TestRunner extends AbstractTestNGCucumberTests {


}

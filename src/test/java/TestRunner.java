import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/Resource/Login.feature"},
        glue = {"Steps","hooks"}
)

public class TestRunner extends AbstractTestNGCucumberTests {


}

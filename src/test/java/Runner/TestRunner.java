package Runner;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.junit.runner.RunWith;
/**
 *
 */
//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = "StepDefination",
        tags = "@first"
//        plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
)

public class TestRunner extends AbstractTestNGCucumberTests{


}

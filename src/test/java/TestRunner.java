
import utilities.ConfigFileReader;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = {"stepdefinitions"}, monochrome = true, plugin = {"pretty", "junit:target/JUnitReports/report.xml", "json:target/JSONReports/report.json", "html:target/HtmlReports"}, tags = "@Sanity")
public class TestRunner {
    @BeforeClass
    public static void setUpBeforeClass() {
        ConfigFileReader configFileReader = new ConfigFileReader();
        System.out.println("Execution Started");
        System.out.println("Site to test: " + configFileReader.getApplicationUrl());
    }

}

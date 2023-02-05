package runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;  
import io.cucumber.junit.CucumberOptions;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // donde estan los features
    glue = "steps",
    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","json:target/cucumber-reports.json"}, 
    monochrome = true,
    // tags = "not @Search",
    // tags = "@Google and not @form",
    tags = "@Google or @form",
    // tags = "@ListPage and @Lista",
    // tags="@form",
    publish = true // donde estan los steps
)
public class Runner {
    // despues de cada ejecucion que cierre el browser
     @AfterClass
     public static void cleanDriver(){
         BasePage.closeBrowser();
     }
}

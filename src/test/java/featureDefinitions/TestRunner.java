package featureDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(

		monochrome=true,		// enable console output
		plugin= {"pretty",
					"html:test-output/cucumber.html",
					"json:target/cucumber.json",
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "src/test/java/feature",
		// tags = "@AllTest",		// Cucumber 6 syntax
		//tags = "@PositiveTest or @NegativeTest or @AddSingleProduct or @ChangeQuantityofProducts or @clearCart  or @SearchItems", 
		glue = {"featureDefinitions"})

public class TestRunner {

}


// or @SOSingleProduct or @DTMultipleProduct or @AddQuanitytoExisitngitems or @RemoveQuanitytoExisitngitems
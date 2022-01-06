package featureDefinitions;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServiceavailabilitySteps {


	@Given("^User launchs the Swiggy application$")
    public void user_launchs_the_swiggy_application() throws Throwable {
		BaseClass.applaunch();
	}

    @When("^User enters Pin code info '(.+)' and clicks the FindFood button$")
    public void user_enters_pin_code_info_(String pincode) throws Throwable {
    	BaseClass.validatePinCode(pincode);
    }

    @When("^User enters area/location name '(.+)' and clicks the FindFood button$")
    public void user_enters_arealocation_name_(String locationname) throws Throwable {
    	BaseClass.validatePinCode(locationname);
    }


    @Then("^User should be landed on the Products Page$")
    public void user_should_be_landed_on_the_products_page() throws Throwable {
    	assertTrue(BaseClass.ConfirmProductPage());
    }





}

package steps;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GooglePage;

public class GoogleStep {

    GooglePage google = new GooglePage();

    //^ inicio, $ final
    @Given("^I am on the Google search page$")
    public void navigateToGoogle(){
        google.navigateToGoogle();
    }

    @When("^I enter a search (.+)$")
    public void i_enter_a_search(String criteria){
        google.enterSearchCriteria(criteria);
    }

    @And("^click on the search button$")
    public void clickSearchButton(){
        google.clickGoogleSearch();
    }

    @Then("^the results match the criteria$")
    public void validateResult(){
        Assert.assertEquals("Welcome to Python.org", google.textResult());
    }

    @Then("^search is display$")
    public void search_is_display(){
        // Assert.assertTrue("EL buscador esta presente", google.validateDisplay());
        // Assert.assertFalse("EL buscador esta presente", google.validateDisplay());
        
    }
}

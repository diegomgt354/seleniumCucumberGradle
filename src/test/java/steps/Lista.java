package steps;

import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ListPage;

public class Lista {

    ListPage listita = new ListPage();

    @Given("^I am on the List search page$")
    public void I_am_on_the_List_search_page(){
        listita.navigateToListPage();
    }

    @When("^I search the (.+)$")
    public void I_search_the_text(String text) throws InterruptedException{
        listita.enterSearchCriteria(text);
    }

    @Then("^I can find the (.+) in the list$")
    public void I_can_find_the_text_in_the_list(String text){
        List<String> lista = listita.getAllSearchResult();
        boolean textIsThere = lista.contains(text);
        if(textIsThere){
            System.out.println("PASSED - '"+text+"' is on the list.");
        }else{
            throw new Error("FAILED - The text is not on the list.");
        }
    }
    
}

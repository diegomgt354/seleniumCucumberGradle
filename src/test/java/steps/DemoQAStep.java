package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DemoQAPage;

public class DemoQAStep {
    
    DemoQAPage demoQAPage = new DemoQAPage();

    @Given("^Since I'm on the Form page$")
    public void since_im_on_the_form_page(){
        demoQAPage.navigateToDemoQAForm();
    }

    @When("^I enter the firstname (.+)$")
    public void i_enter_the_firstname(String txtFirstName){
        demoQAPage.addFirsthName(txtFirstName);
    }

    @Then("^the results are displayed$")
    public void the_results_match_the_criteria(){
        
    }

    @And("^I enter the lastname (.+)$")
    public void i_enter_the_lastname(String txtLastName){
        demoQAPage.addLastName(txtLastName);
    }

    @And("^I enter the email (.+)$")
    public void i_enter_the_email(String txtEmail){
        demoQAPage.addEmail(txtEmail);
    }

    @And("^select gender (.+)$")
    public void select_gender(String gender){
        demoQAPage.addGender(gender);
        
    }

    @And("^I enter the mobile number (.+)$")
    public void i_enter_the_mobile_number(String txtMobile){
        demoQAPage.addMobile(txtMobile);
        
    }

    @And("^I enter the Date of Birth (.+), (.+) and (.+)$")
    public void i_enter_the_date_of_birth_and(String txtYear, String txtMonth, String txtDay ){
        demoQAPage.addBirthday(txtYear, txtMonth, txtDay);
    }

    @And("^I enter the Subjects (.+)$")
    public void i_enter_the_subjects(String txtSubject){
        // demoQAPage.addSubjects(txtSubject);
    }

    @And("^I enter the Hobbies (.+)$")
    public void i_enter_the_hobbies(String hobbies){
        
    }

    @And("^I enter the picture (.+)$")
    public void i_enter_the_picture(String ubication){
        demoQAPage.addArchive(ubication);
    }
    

    @And("^I enter the Current Address (.+)$")
    public void i_enter_the_current_address(String address){
        
    }

    @And("^I enter the State (.+)$")
    public void i_enter_the_state(String state){
        
    }

    @And("^I enter the City (.+)$")
    public void i_enter_the_city(String city){
        
    }

    @And("^click on the Submit button$")
    public void click_on_the_submit_button(){
        
    }

}

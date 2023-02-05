package pages;

public class DemoQAPage extends BasePage{

    String firstName = "//input[@id='firstName']";
    String lastName = "//input[@id='lastName']";
    String email = "//input[@id='userEmail']";
    String mobile = "//input[@id='userNumber']";
    String dateOfBirthInput = "//input[@id='dateOfBirthInput']";
    String month = "//*[@id='dateOfBirth']/div[2]//div[1]/select";
    String year = "//*[@id='dateOfBirth']/div[2]//div[2]/select";
    String subjets = "//div[@id='subjectsContainer']/div[1]/div[1]";
    String oneOption = "//div[@id='react-select-2-option-0']";
    String addArchive = "//*[@id='uploadPicture']";

    public DemoQAPage() {
        super(driver);
    }
    
    public void navigateToDemoQAForm(){
        navigateTo("https://demoqa.com/automation-practice-form");
    }
    
    public void addFirsthName(String cadena){
        sendKeysText(firstName, cadena);
    }

    public void addLastName(String cadena){
        sendKeysText(lastName, cadena);
    }

    public void addEmail(String cadena){
        sendKeysText(email, cadena);
    }

    public void addGender(String cadena){
        clickElement("//label[text()='"+cadena+"']");
    }

    public void addMobile(String cadena){
        sendKeysText(mobile, cadena);
    }

    public void addBirthday(String cadenaYear, String cadenaMonth, String cadenaDay){
        clickElement(dateOfBirthInput);
        selectFromDropdownByTextVisible(year, cadenaYear);
        selectFromDropdownByTextVisible(month, cadenaMonth);
        clickElement("//div[contains(@aria-label,'"+cadenaMonth+"') and text()='"+cadenaDay+"']");
    }

    public void addSubjects(String cadena){
        // ScrollElement(subjets);
        clickElement(subjets);
        sendKeysText(subjets, cadena);
        // clickElement(oneOption);
    }

    public void addArchive(String ubication){
        verTypeFile();
        uploadArchiveInputFile(addArchive, ubication);
    }

}

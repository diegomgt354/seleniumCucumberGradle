package pages;

public class GooglePage extends BasePage{

    private String searchTextField = "//input[@title='Buscar']";
    private String searchButton = "(//input[@value='Buscar con Google'])[1]";
    private String titleResult = "//*[@id='rso']/div[1]//div[1]/a/h3";

    public GooglePage() {
        super(driver);
    }

    public void navigateToGoogle(){
        navigateTo("https://www.google.com/");
    }
    
    public void clickGoogleSearch(){
        clickElement(searchButton);
    }

    public void enterSearchCriteria(String criteria){
        write(searchTextField, criteria);
    }

    public String textResult(){
        return textFromElement(titleResult);
    }

    public boolean validateDisplay(){
        return elementIsDisplay(searchTextField);
    }
}

package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;

public class ListPage extends BasePage{
    
    String searchFiel = "/html/body/form/input";
    String searchResult = "name";

    public ListPage(){
        super(driver);
    }
    // navegar en la pagina
    public void navigateToListPage(){
        navigateTo("https://andreidbr.github.io/JS30/06AjaxTypeAhead/index.html");
    }
    // buscar el texto en el elemento
    public void enterSearchCriteria(String text) throws InterruptedException{
        try{
            Thread.sleep(600);
            write(searchFiel,text);
        }catch(NoSuchElementException e){
            System.out.println("The WebElement Search Field couldn't be found.");
            e.printStackTrace();
        }
        
    }
    // retorna una lista de texto de los elementos encontrados
    public List<String> getAllSearchResult(){
        List<WebElement> list = bringMeAllElements(searchResult);
        List<String> stringFromList = new ArrayList<String>();
        for(WebElement e : list){
            stringFromList.add(e.getText());
        }
        return stringFromList;
    }

}

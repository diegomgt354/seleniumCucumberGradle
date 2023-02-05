package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PageFactotyPage extends BasePage {

    @CacheLookup //guarda en cache el elemento, pero si el elemento es dinámico como un contador tendremos problemas como StaleElementException
    @FindBy(id = "gbwa")
    WebElement boton;

    public PageFactotyPage() {
        super(driver);
        driver.get("https://www.google.com/");
        boton.click();
    }
    
}

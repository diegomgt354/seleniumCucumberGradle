package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.firefox.FirefoxOptions;
// import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

// import org.awt.Robot;

public class BasePage {
    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static JavascriptExecutor js;
    // private static 

    // bloque estatico
    static{
        String dirFile = System.getProperty("user.dir") +"/src/test/resources/webDriver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", dirFile);
        ChromeOptions chromeOptions = new ChromeOptions();
        // FirefoxOptions firefoxOptions = new FirefoxOptions();
        driver = new ChromeDriver(chromeOptions);
        // driver = new FirefoxDriver(firefoxOptions);
//        wait = new WebDriverWait(driver, 10); // significa que espera 10 segundos a los elementos
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // significa que espera 10 segundos a los elementos
        js = (JavascriptExecutor) driver;
    }
    // constructor
    public BasePage(WebDriver driver){
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // PageFactory.initElements(driver, this); // para usar PageFactory 
    }

    // cierra el browser
    public static void closeBrowser(){
        driver.quit();
    }

    // levantamos la pagina
    public static void navigateTo(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }
    // scroll al elemento 
    public void ScrollElement(String locator){
        js.executeScript("arguments[0].scrollIntoView()", find(locator));
        // js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.xpath(locator)));
    }
    // retornamos el webElenment despues de validar que sea visible
    private WebElement find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }
    // click al elemento
    public void clickElement(String locator){
        find(locator).click();
    }
    // escribir en el campo
    public void sendKeysText(String locator, String texto){
        find(locator).sendKeys(texto);
    }
    // limpiar y escribir en el campo
    public void write(String locator, String texto){
        find(locator).clear();
        find(locator).sendKeys(texto);
    }
    // seleccionar por value en la lista
    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(find(locator));
        dropdown.selectByValue(valueToSelect);
    }
    // seleccionar por index en la lista
    public void selectFromDropdownByIndex(String locator, int indexToSelect){
        Select dropdown = new Select(find(locator));
        dropdown.selectByIndex(indexToSelect);
    }
    // selecciona por texto visible en la lista
    public void selectFromDropdownByTextVisible(String locator, String indexToSelect){
        Select dropdown = new Select(find(locator));
        dropdown.selectByVisibleText(indexToSelect);
    }
    // agrega un archivo en un input file
    public void uploadArchiveInputFile(String locator, String ubication){
        sendKeysText(locator, ubication);
    }
    // muestra el file upload 
    public void verTypeFile(){
        js.executeScript("$(\"#fileField\").css(\"visibility\",\"visible\");");
        js.executeScript("$(\"#fileField\").css(\"display\",\"block\");");
        // js.executeScript("$(\"#fileField\").css(\"width\",\"200px\");");
        // js.executeScript("$(\"#fileField\").css(\"height\",\"200px\");");
        // js.executeScript("$(\"#fileField\").css(\"position\",\"fixed\");");
        // js.executeScript("$(\"#fileField\").css(\"overflow\",\"visible\");");
        // js.executeScript("$(\"#fileField\").css(\"zIndex\",\"999999\");");
        // js.executeScript("$(\"#fileField\").css(\"top\",\"500px\");");
        // js.executeScript("$(\"#fileField\").css(\"bottom\",\"500px\");");
        // js.executeScript("$(\"#fileField\").css(\"left\",\"500px\");");
        // js.executeScript("$(\"#fileField\").css(\"right\",\"500px\");");
        // js.executeScript("$(\"#fileField\").css(\"marginBottom\",\"100px\");");
    }
    // pasar entre frame por el index
    public void switchToIFrame(String indexFrame){
        driver.switchTo().frame(indexFrame);
    }
    // retorna al frame original o padre
    public void swithToParentFrame(){
        driver.switchTo().parentFrame();
    }
    // eliminar la alerta
    public void dismissAlert(){
        try{
            driver.switchTo().alert().dismiss();
        }catch(NoAlertPresentException e){
            e.printStackTrace();
        }
        
    }
    
    // public void validateText(String locator, String textToValidate){
    //     Assert.assertEquals(textToValidate, find(locator).getText());
    // }


    // retornar el texto del elemento
    public String textFromElement(String locator){
        return find(locator).getText();
    }
    // retorna True si se muestra el elemento - el elemento esta ahi presente
    public boolean elementIsDisplay(String locator){
        return find(locator).isDisplayed();
    }

    // retorna True si esta seleccionado  - para botones de radio
    public boolean elementIsSelect(String locator){
        return find(locator).isSelected();
    }

    // retorna True si esta habilitado el elemento 
    public boolean elementIsEnable(String locator){
        return find(locator).isEnabled();
    }

    // retorna una lista de WebElements
    public List<WebElement> bringMeAllElements(String locator){
        return driver.findElements(By.className(locator));
    }

    
}

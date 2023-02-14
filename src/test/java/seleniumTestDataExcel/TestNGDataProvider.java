package seleniumTestDataExcel;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataProvider {

    private WebDriver driver;
    private WebDriverWait wait;

    By frameGoogle = By.name("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0");
    By dismissFrame = By.id("dismiss-button");
    By firstName = By.name("firstName");
    By lastName = By.name("lastName");
    By phone = By.name("phone");
    By userName = By.name("userName");
    By address1 = By.name("address1");
    By city = By.name("city");
    By state = By.name("state");
    By postalCode = By.name("postalCode");
    By country = By.name("country");
    By email = By.name("email");
    By password = By.name("password");
    By confirmPassword = By.name("confirmPassword");
    By submit = By.name("submit");
    By confirmationMessage = By.xpath("//tbody//p[3]/font/b");

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/webDriver/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/");
        driver.manage().window().maximize();
    }


    @Test(dataProvider = "authenticationData")
    public void test(String nombre, String apellido, String telefono, String usuario, String direccion, String ciudad, String estado,
                        String codigoPostal, String pais, String correo, String contra, String confirmarContra){
        
        // ingresamos a la pagina de registro
        driver.findElement(By.linkText("REGISTER")).click();
        
        // buscamos si sale el frame de google
        List<WebElement> iframes = driver.findElements(frameGoogle);
        // si existe entramos al frame y click en el btn dismiss
        if (iframes.size() != 0) {
            WebElement frame = driver.findElement(frameGoogle);
            driver.switchTo().frame(frame); // ingresamos al frame encontrado
            driver.findElement(dismissFrame).click(); // click al btn dentro del frame
            driver.switchTo().defaultContent(); // retornamos al contenido predeterminado dejando el frame
        }

        // llenamos los campos de registro
        driver.findElement(firstName).sendKeys(nombre);
        driver.findElement(lastName).sendKeys(apellido);
        driver.findElement(phone).sendKeys(telefono);
        driver.findElement(userName).sendKeys(usuario);
        driver.findElement(address1).sendKeys(direccion);
        driver.findElement(city).sendKeys(ciudad);
        driver.findElement(state).sendKeys(estado);
        driver.findElement(postalCode).sendKeys(codigoPostal);  
        Select selectCountry = new Select(driver.findElement(country));
        selectCountry.selectByValue(pais);
        driver.findElement(email).sendKeys(correo);
        driver.findElement(password).sendKeys(contra);
        driver.findElement(confirmPassword).sendKeys(confirmarContra);
        driver.findElement(submit).click();

        // capturamos el mensaje de confirmacion
        String mensajeConfirmacion = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).getText();
        System.out.println(mensajeConfirmacion);

    }

    @DataProvider(name = "authenticationData")
    public Object[][] getData(){
        Object[][] data = new Object[2][12];

        data[0][0] = "diego";
        data[0][1] = "Gutierrez Tafur";
        data[0][2] = "987654321";
        data[0][3] = "diegomgt";
        data[0][4] = "Mz AA lote 123 calle testing";
        data[0][5] = "Lima";
        data[0][6] = "Lima";
        data[0][7] = "+051";
        data[0][8] = "PERU";
        data[0][9] = "seleniun@test.com";
        data[0][10] = "password123";
        data[0][11] = "password123";
        
        data[1][0] = "Elizeth";
        data[1][1] = "Rojas Delgado";
        data[1][2] = "999999999";
        data[1][3] = "elizethRD";
        data[1][4] = "Mz AA lote 123 calle testing";
        data[1][5] = "El Cairo";
        data[1][6] = "El Cairo";
        data[1][7] = "+051";
        data[1][8] = "EGYPT";
        data[1][9] = "seleniun2@test.com";
        data[1][10] = "password123";
        data[1][11] = "password123";

        return data;
    }

    @AfterClass
    public void afterClass(){
        // driver.close();
    }

}

package seleniumTest;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataTesting{

    private WebDriver driver;
    private WriteExcelFile writeExcelFile; // para escribir en el archivo excel
    private ReadExcelFile  ReadExcelFile; // para leer el archivo excel
    private WebDriverWait wait;

    @Before
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/webDriver/chromedriver.exe");
        driver = new ChromeDriver();
        writeExcelFile = new WriteExcelFile();
        ReadExcelFile = new ReadExcelFile();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // espera explicita - espera que se cumpla una condicion
        driver.get("https://demo.guru99.com/test/newtours/");
        driver.manage().window().maximize();
        


    }
 
    @After
    public void tearDown() throws Exception{
        driver.close();
        
    }

    @Test
    public void test() throws Exception{
        // identificamos el archivo excel
        String filePath = "src\\test\\resources\\dataExcel\\Libro1.xlsx";
        String sheetName = "guru99Demo";
        int fila = 1;
        // obtenemos los valores a utilizar
        String firstName = ReadExcelFile.getCellValue(filePath, sheetName, fila, 0);
        String lastName = ReadExcelFile.getCellValue(filePath, sheetName, fila, 1);
        String userName = ReadExcelFile.getCellValue(filePath, sheetName, fila, 2);
        String phone = ReadExcelFile.getCellValue(filePath, sheetName, fila, 3);
        String address1 = ReadExcelFile.getCellValue(filePath, sheetName, fila, 4);
        String city = ReadExcelFile.getCellValue(filePath, sheetName, fila, 5);
        String state = ReadExcelFile.getCellValue(filePath, sheetName, fila, 6);
        String postalCode = ReadExcelFile.getCellValue(filePath, sheetName, fila, 7);
        String country = ReadExcelFile.getCellValue(filePath, sheetName, fila, 8);
        String email = ReadExcelFile.getCellValue(filePath, sheetName, fila, 9);
        String password = ReadExcelFile.getCellValue(filePath, sheetName, fila, 10);
        String confirmPassword = ReadExcelFile.getCellValue(filePath, sheetName, fila, 11);
        
        // ingresamos a la pagina de registro
        driver.findElement(By.linkText("REGISTER")).click();
        // buscamos si sale el frame de google
        List<WebElement> iframes = driver.findElements(By.name("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
        // si existe entramos al frame y click en el btn dismiss
        if (iframes.size() != 0) {
            WebElement frameGoogle = driver.findElement(By.name("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
            driver.switchTo().frame(frameGoogle); // ingresamos al frame encontrado
            driver.findElement(By.id("dismiss-button")).click(); // click al btn dentro del frame
            driver.switchTo().defaultContent(); // retornamos al contenido predeterminado dejando el frame
        }
        // llenamos los campos de registro
        driver.findElement(By.name("firstName")).sendKeys(firstName);
        driver.findElement(By.name("lastName")).sendKeys(lastName);
        driver.findElement(By.name("phone")).sendKeys(phone);
        driver.findElement(By.name("userName")).sendKeys(userName);
        driver.findElement(By.name("address1")).sendKeys(address1);
        driver.findElement(By.name("city")).sendKeys(city);
        driver.findElement(By.name("state")).sendKeys(state);
        driver.findElement(By.name("postalCode")).sendKeys(postalCode);
        Select pais = new Select(driver.findElement(By.name("country")));
        pais.selectByValue(country);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("confirmPassword")).sendKeys(confirmPassword);
        driver.findElement(By.name("submit")).click();

        // capturamos el mensaje de confirmacion
        String mensajeConfirmacion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody//p[3]/font/b"))).getText();
        System.out.println(mensajeConfirmacion);
        writeExcelFile.writeCellValue(filePath, sheetName, fila, 12, mensajeConfirmacion);

        // ingresamos a la pagina principal
        driver.findElement(By.linkText("SIGN-OFF")).click();

        // llenamos los campos de login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("userName"))).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("submit")).click();

        // capturamos el mensaje de login
        String mensajeLogin = driver.findElement(By.xpath("//tr[3]/td/p[1]/font/b")).getText();
        System.out.println(mensajeLogin);
        writeExcelFile.writeCellValue(filePath, sheetName, fila, 13, mensajeLogin);
        
        // fail("Esto no esta implementado XD");
        
    }

}
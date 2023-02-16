package multiplesNavegadoresTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class multipleBrowser {
    
    private WebDriver driver;

    @BeforeClass
    @Parameters({"URL","BrowserType"})
    public void beforeClass(String url, String browsertype){
        if(browsertype.equalsIgnoreCase("Chrome")){
            System.setProperty("webdriver.chrome.driver", "./src/test/resources/webDriver/chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browsertype.equalsIgnoreCase("Firefox")){
            System.setProperty("webdriver.gecko.driver", "./src/test/resources/webDriver/geckodriver.exe");
            driver = new FirefoxDriver();
        }else if(browsertype.equalsIgnoreCase("Edge")){
            System.setProperty("webdriver.edge.driver", "./src/test/resources/webDriver/msedgedriver.exe");
            driver = new InternetExplorerDriver();
        }

        driver.manage().window().maximize();
        driver.get(url);

        System.out.println("Opening: " + browsertype);

    }

    @Test
    public void testClass(){
        
    }

    @AfterClass
    public void afterClass(){
        // driver.close();
    }
}

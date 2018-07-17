import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.assertEquals;

public class WebDriverTest {

    public static WebDriver driver;
    public static String baseURL ="http://amazon.com";

    @BeforeClass
    public static void checkSeleniumHQinFirefox(){

        System.setProperty("webdriver.gecko.driver", "libs/geckodriver");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
        assertEquals(expectedTitle,actualTitle);

        driver.manage().timeouts().pageLoadTimeout(100, SECONDS);


       if(driver.getTitle().contains(expectedTitle))
            //Pass
            System.out.println("Anasayfa açıldı. ");
        else
            //Fail
            System.out.println("Anasayfa açılamadı."+ expectedTitle);
            //driver.quit();
    }
}

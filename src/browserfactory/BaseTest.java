package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    static String browser = "Chrome";

    public void openBrowser(String baseUrl) {

        // Launch the Chrome Browser
        if(browser.equalsIgnoreCase("Chrome")) {

//            ChromeOptions options = new ChromeOptions();
//            Map<String, Object> prefs = new HashMap<String, Object>();
//            prefs.put("autofill.profile_enabled", false);
//            prefs.put("autofill.credit_card_enabled", false);
//            options.setExperimentalOption("prefs", prefs);

            driver = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("Firefox"))
            driver = new FirefoxDriver();
        else if(browser.equalsIgnoreCase("Edge"))
            driver = new EdgeDriver();
        else
            System.out.println("Invalid browser name");


        // Open the URL into Browser
        driver.get(baseUrl);
        //Maximise Browser
        driver.manage().window().maximize();
        // We give Implicit wait to Driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closeBrowser() {
        driver.quit();
    }
}

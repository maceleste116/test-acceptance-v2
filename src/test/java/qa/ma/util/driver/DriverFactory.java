package qa.ma.util.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import qa.ma.enums.Browser;


public class DriverFactory {

    public static WebDriver get(Browser browser) {
        if (Browser.chrome == browser) {
            new DesiredCapabilities();
            System.setProperty("webdriver.chrome.driver", "C:/Users/berdinas/IdeaProjects/test-acceptance-v2/src/test/resources/drivers/windows/chromedriver.exe");
            return new ChromeDriver();
        }

        if (Browser.chrome == browser){
            System.out.println("No está instalado");
        }

        throw new IllegalArgumentException("Driver not found for browser: " + browser);
    }
}
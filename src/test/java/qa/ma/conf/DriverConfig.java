package qa.ma.conf;

import org.openqa.selenium.WebDriver;
import qa.ma.enums.Browser;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import qa.ma.util.driver.DriverFactory;

import java.time.Duration;

@PropertySource(value = "classpath:/application.properties")
@Configuration
@ComponentScan(basePackages = "qa.ma")
public class DriverConfig {

    @Value("${driver.type}")
    private Browser driverType;

    @Value("${element.wait.timeout.seconds}")
    private int webDriverWaitTimeOut;

    @Bean
    public WebDriver webDriver(){
        return DriverFactory.get(driverType);
    }

    @Bean
    public WebDriverWait waitFor(){
        return new WebDriverWait(webDriver(),Duration.ofSeconds(webDriverWaitTimeOut));
    }


}

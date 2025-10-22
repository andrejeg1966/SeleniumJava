package selenium.org.basic;



import java.time.Duration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseTest;

public class SeleniumManagerUsageDemo extends BaseTest{

	@BeforeEach
	  public void createSession() {
	    ChromeOptions options = getDefaultChromeOptions();
		options.setBrowserVersion("136");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  }
	
    @Test
    @Disabled("This test is just for demo purposes and should not be run in CI")
    public void testSetupWithoutManager() {
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver.get("https://www.selenium.dev/documentation/selenium_manager/");
        driver.quit();
    }

    @Test
    public void testSetupWithManager() {
    	
        driver.get("https://www.selenium.dev/documentation/selenium_manager/");
        driver.quit();
    }

}

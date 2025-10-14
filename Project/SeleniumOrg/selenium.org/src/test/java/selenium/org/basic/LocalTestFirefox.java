package selenium.org.basic;

import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import Base.BaseTest;
import org.junit.jupiter.api.Test;

public class LocalTestFirefox extends BaseTest {
	  private FirefoxDriver driver;
	  
	  @AfterEach
	  public void clearProperties() {
	    System.clearProperty(GeckoDriverService.GECKO_DRIVER_LOG_PROPERTY);
	    System.clearProperty(GeckoDriverService.GECKO_DRIVER_LOG_LEVEL_PROPERTY);driver.quit();
	  }
	  
	  @Test
	  public void Test () {
		  driver = startFirefoxDriver();
		  driver.get("file:///C:/Dev/HTML/Table%20example.html");
		  String Title = driver.getTitle();
		  System.out.println(Title);
	  }

}

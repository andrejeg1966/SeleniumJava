package Drivers;




import java.io.File;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.service.DriverFinder;

import Base.BaseTest;

public class ServiceTest extends BaseTest {
  
  //To start a driver with a default service instance:
  @Test
  public void defaultService() {
    ChromeDriverService service = new ChromeDriverService.Builder().build();
    driver = new ChromeDriver(service);
  }
  //If you are using Selenium 4.6 or greater, you shouldn’t need to set a driver location. 
  //If you cannot update Selenium or have an advanced use case, here is how to specify the driver location:
  @Test
  public void setDriverLocation() {
    setBinaryPaths();
    ChromeOptions options = getDefaultChromeOptions();
    options.setBinary(browserPath);

    ChromeDriverService service =
        new ChromeDriverService.Builder().usingDriverExecutable(driverPath).build();

    driver = new ChromeDriver(service, options);
    try {
        // Navigate to Url
        driver.get("https://selenium.dev");
      } finally {
        driver.quit();
      }
  }

  @Test
  public void setPort() {
    ChromeDriverService service = new ChromeDriverService.Builder().usingPort(1234).build();

    driver = new ChromeDriver(service);
  }

  private void setBinaryPaths() {
    ChromeOptions options = getDefaultChromeOptions();
    options.setBrowserVersion("stable");
    DriverFinder finder = new DriverFinder(ChromeDriverService.createDefaultService(), options);
    driverPath = new File(finder.getDriverPath());
    System.out.println(driverPath);
    browserPath = new File(finder.getBrowserPath());
    System.out.println(browserPath);
  }
}

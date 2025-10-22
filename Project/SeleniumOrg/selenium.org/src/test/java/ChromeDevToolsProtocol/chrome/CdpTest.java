package ChromeDevToolsProtocol.chrome;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.HasCdp;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import Base.BaseTest;

/*
 * Chrome DevTools Protocol (CDP)
 * Chrome and Edge have a method to send basic CDP commands. 
 * This does not work for features that require bidirectional communication, 
 * and you need to know what domains to enable when and the exact names and types of domains/methods/parameters.
 */
public class CdpTest extends BaseTest {
  @BeforeEach
  public void createSession() {
	    ChromeOptions options = getDefaultChromeOptions();
	    options.setBrowserVersion("136");
	    driver = new ChromeDriver(options);
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  @Test
  public void setCookie() {
    Map<String, Object> cookie = new HashMap<>();
    cookie.put("name", "cheese");
    cookie.put("value", "gouda");
    cookie.put("domain", "www.selenium.dev");
    cookie.put("secure", true);
    ((HasCdp) driver).executeCdpCommand("Network.setCookie", cookie);

    driver.get("https://www.selenium.dev");
    Cookie cheese = driver.manage().getCookieNamed("cheese");
    Assertions.assertEquals("gouda", cheese.getValue());
    Assertions.assertEquals("cheese", cheese.getName());
    Assertions.assertEquals("www.selenium.dev", cheese.getDomain());
   
  }
}

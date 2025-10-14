package Drivers;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

import Base.BaseTest;

public class OptionsTest extends BaseTest {

  @Test
  public void setPageLoadStrategyNormal() {
    ChromeOptions chromeOptions = getDefaultChromeOptions();
    //normal	complete	Used by default, waits for all resources to download
    chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
    WebDriver driver = new ChromeDriver(chromeOptions);
    try {
      // Navigate to Url
      driver.get("https://selenium.dev");
    } finally {
      driver.quit();
    }
  }
  /*
   * If a page takes a long time to load as a result of downloading assets (e.g., images, css, js) that aren’t important to the automation, 
   * you can change from the default parameter of normal to eager or none to speed up the session.
   */
  @Test
  public void setPageLoadStrategyEager() {
    ChromeOptions chromeOptions = getDefaultChromeOptions();
    //eager	interactive	DOM access is ready, but other resources like images may still be loading
    chromeOptions.setPageLoadStrategy(PageLoadStrategy.EAGER);
    WebDriver driver = new ChromeDriver(chromeOptions);
    try {
      // Navigate to Url
      driver.get("https://selenium.dev");
    } finally {
      driver.quit();
    }
  }
  
  @Test
  public void setPageLoadStrategyNone() {
    ChromeOptions chromeOptions = getDefaultChromeOptions();
    //none	Any	Does not block WebDriver at all
    chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
    WebDriver driver = new ChromeDriver(chromeOptions);
    try {
      // Navigate to Url
      driver.get("https://selenium.dev");
    } finally {
      driver.quit();
    }
  }
  
  @Test
  public void getBrowserName() {
	ChromeOptions chromeOptions = getDefaultChromeOptions();
	String nameActual = chromeOptions.getBrowserName();
	String versionActual = chromeOptions.getBrowserVersion();
	Assertions.assertFalse(nameActual.isEmpty(), "Browser name should not be empty");
	String nameExpected = "chrome";
	String versionExpected = "136";
	Assertions.assertEquals(nameExpected, nameActual);
	Assertions.assertEquals(versionExpected, versionActual);
	
	chromeOptions.setCapability(CapabilityType.BROWSER_VERSION, true);
	Object capabilityObject = chromeOptions.getCapability(CapabilityType.BROWSER_VERSION);
	Boolean capability = (Boolean) capabilityObject;
	Assertions.assertTrue(capability, "The capability BROWSER_VERSION should be set to true.");
	
	String versionActual2 = chromeOptions.getBrowserVersion();
	String versionExpected2 = "136";
	Assertions.assertEquals(versionActual2, versionExpected2);
  }
  //This identifies the operating system at the remote-end, fetching the platformName returns the OS name.
  @Test
  public void setPlatformName() {
	ChromeOptions chromeOptions = getDefaultChromeOptions();
	String platform = "OS X 10.6";
	chromeOptions.setPlatformName(platform);
	String platformName = chromeOptions.getPlatformName().toString();
	Assertions.assertEquals(platform, platformName);
	System.out.println("The platformName is " +platformName);
  }
  
  @Test
  public void setAcceptInsecureCerts() {
    ChromeOptions chromeOptions = getDefaultChromeOptions();
    chromeOptions.setAcceptInsecureCerts(false);
    WebDriver driver = new ChromeDriver(chromeOptions);
    try {
      // Navigate to Url
      driver.get("https://selenium.dev");
    } finally {
      driver.quit();
    }
  }
  /*
   * Script Timeout
   Specifies when to interrupt an executing script in a current browsing context. The default timeout 30,000 is imposed when a new session is created by WebDriver.
   */
  @Test
  public void setScriptTimeout() {
	ChromeOptions chromeOptions = getDefaultChromeOptions();
	Duration duration = Duration.of(5, ChronoUnit.SECONDS);
	chromeOptions.setScriptTimeout(duration);
	WebDriver driver = new ChromeDriver(chromeOptions);
	try {
	  Duration timeout = driver.manage().timeouts().getScriptTimeout();
	  Assertions.assertEquals(timeout, duration, "The script timeout should be set to 5 seconds.");
	} finally {
	  driver.quit();
	}
  }
  /*
   * Page Load Timeout
   * Specifies the time interval in which web page needs to be loaded in a current browsing context. 
   * The default timeout 300,000 is imposed when a new session is created by WebDriver. 
   * If page load limits a given/default time frame, the script will be stopped by TimeoutException.
   */
  @Test
  public void setPageLoadTimeout() {
	ChromeOptions chromeOptions = getDefaultChromeOptions();
	Duration duration = Duration.of(5, ChronoUnit.SECONDS);
	chromeOptions.setPageLoadTimeout(duration);

	WebDriver driver = new ChromeDriver(chromeOptions);
	try {
	  Duration timeout = driver.manage().timeouts().getPageLoadTimeout();
	  Assertions.assertEquals(timeout, duration, "The page load timeout should be set to 5 seconds.");
	} finally {
	  driver.quit();
	}
  }
  /*
  Implicit Wait Timeout
  This specifies the time to wait for the implicit element location strategy when locating elements. 
  The default timeout 0 is imposed when a new session is created by WebDriver.
   */
  @Test
  public void setImplicitWaitTimeout() {
	ChromeOptions chromeOptions = getDefaultChromeOptions();
	Duration duration = Duration.of(5, ChronoUnit.SECONDS);
	chromeOptions.setImplicitWaitTimeout(duration);

	WebDriver driver = new ChromeDriver(chromeOptions);
	try {
	  Duration timeout = driver.manage().timeouts().getImplicitWaitTimeout();
	  Assertions.assertEquals(timeout, duration, "The implicit wait timeout should be set to 5 seconds.");
	} finally {
	  driver.quit();
	}
  }
  /*
   * User Prompt Handler
	This defines what action must take when a user prompt encounters at the remote-end. 
	This is defined by unhandledPromptBehavior capability and has the following states:

	dismiss
	accept
	dismiss and notify
	accept and notify
	ignore
   */
  
  @Test
  public void setUnhandledPromptBehaviour() {
	ChromeOptions chromeOptions = getDefaultChromeOptions();
	chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY);
	//verify the capability object is not null
	Object capabilityObject = chromeOptions.getCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR);
	Assertions.assertNotNull(capabilityObject, "Capability UNHANDLED_PROMPT_BEHAVIOUR should not be null.");
	Assertions.assertEquals(capabilityObject.toString(), UnexpectedAlertBehaviour.DISMISS_AND_NOTIFY.toString());
  }

  
  
  /*
   * setWindowRect
	Indicates whether the remote end supports all of the resizing and repositioning commands.
   */
  @Test
  public void setWindowRect() {
	  ChromeOptions chromeOptions = getDefaultChromeOptions();
	  WebDriver driver = new ChromeDriver(chromeOptions);
	  chromeOptions.setCapability(CapabilityType.SET_WINDOW_RECT, true);
	  Object capabilityObject = chromeOptions.getCapability(CapabilityType.SET_WINDOW_RECT);
	 
	  try {
		driver.manage().window().fullscreen();
	    driver.get("https://selenium.dev");
	  } finally {
	    driver.quit();
	  }
	}
  /*
   strictFileInteractability
This new capability indicates if strict interactability checks should be applied to input type=file elements. 
As strict interactability checks are off by default, there is a change in behaviour when using Element Send Keys with hidden file upload controls.
   */
  @Test
  public void setStrictFileInteractability() {
	    ChromeOptions chromeOptions = getDefaultChromeOptions();
	    chromeOptions.setCapability(CapabilityType.STRICT_FILE_INTERACTABILITY, true);
		//verify the capability object is not null
	    Object capabilityObject = chromeOptions.getCapability(CapabilityType.STRICT_FILE_INTERACTABILITY);
	    Assertions.assertNotNull(capabilityObject, "Capability STRICT_FILE_INTERACTABILITY should not be null.");

	    Boolean capability = (Boolean) capabilityObject;
	    Assertions.assertTrue(capability, "The capability STRICT_FILE_INTERACTABILITY should be set to true.");
	  }
  
  @Test
  public void ProxyTest() {
	  Proxy proxy = new Proxy();
	    proxy.setHttpProxy("<HOST:PORT>");
	    ChromeOptions options = new ChromeOptions();
	    options.setCapability("proxy", proxy);
	    WebDriver driver = new ChromeDriver(options);
	    driver.get("https://www.google.com/");
	    driver.manage().window().maximize();
	    driver.quit();
  }
}

package Drivers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Pdf;
import org.openqa.selenium.PrintsPage;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.browsingcontext.BrowsingContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriverLogLevel;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.print.PageMargin;
import org.openqa.selenium.print.PageSize;
import org.openqa.selenium.print.PrintOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.pagefactory.ByAll;

import com.google.common.io.Files;

import Base.BaseTest;

public class Testbox extends BaseTest{
	
	
	 @BeforeEach
	  public void setup() {
		    startFirefoxDriver();
	  }
	  @Test
	    public void PrintWithBrowsingContextTest() 
	    {
	        BrowsingContext browsingContext = new BrowsingContext(driver, driver.getWindowHandle());
	        driver.get("https://www.selenium.dev/selenium/web/formPage.html");
	        PrintOptions printOptions = new PrintOptions();
	        printOptions.setOrientation(PrintOptions.Orientation.LANDSCAPE);
	        PageMargin margins = new PageMargin(1.0,1.0,1.0,1.0);
	        printOptions.setPageMargin(margins);
	        
	        String printPage = browsingContext.print(printOptions);
	        System.out.println("printPage");
	        System.out.println(printPage);
	        Assertions.assertTrue(printPage.length() > 0);
	    }
}

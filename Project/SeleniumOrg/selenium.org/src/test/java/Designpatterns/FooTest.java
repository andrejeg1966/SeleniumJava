package Designpatterns;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FooTest {
	  private EditIssue editIssue;

	  @Before
	  public void prepareComponents() {
		FirefoxOptions options = new FirefoxOptions();
	    //options.setCapability("webSocketUrl", true);
	    //driver = new FirefoxDriver(options);
	    FirefoxDriver driver = new FirefoxDriver();
	    ProjectPage project = new ProjectPage(driver, "selenium");
	    SecuredPage securedPage = new SecuredPage(driver, project, "example", "top secret");
	    editIssue = new EditIssue(driver);
	  }

	  @Test
	  public void demonstrateNestedLoadableComponents() {
	    editIssue.get();

	    //editIssue.title.sendKeys("Title");
	    //editIssue.body.sendKeys("What Happened");
	    editIssue.setHowToReproduce("How to Reproduce");
	    editIssue.setLogOutput("Log Output");
	    editIssue.setOperatingSystem("Operating System");
	    editIssue.setSeleniumVersion("Selenium Version");
	    editIssue.setBrowserVersion("Browser Version");
	    editIssue.setDriverVersion("Driver Version");
	    editIssue.setUsingGrid("I Am Using Grid");
	  }

	}


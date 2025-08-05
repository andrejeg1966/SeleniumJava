package PageObjectModel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import bidirectional.firefox.BaseTest;

/***
 * Tests login feature
 */
public class TestLogin extends BaseTest{

	 @BeforeEach
	    public void setup() throws InterruptedException {
	      FirefoxOptions options = new FirefoxOptions();
	      driver = new FirefoxDriver(options);
	      driver.get("https://www.facebook.com");
	      Thread.sleep(3000);
	    }
  @Test
  public void testLogin() {
    SignInPage signInPage = new SignInPage(driver);
    String userName = "goran.andrejevic@web.de";
    String password = "Velesnica1966?";
    HomePage homePage = signInPage.loginValidUser(userName, password);
    Assertions.assertEquals("Hello facebook", homePage.getMessageText());
    Assertions.assertEquals("Facebook - log in or sign up", driver.getTitle());
  }

}


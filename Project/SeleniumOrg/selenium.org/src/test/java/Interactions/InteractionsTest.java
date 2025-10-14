package Interactions;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Base.BaseTest;

public class InteractionsTest extends BaseTest {
	
	@BeforeEach
	public void setup() {
	    startFirefoxDriver();
	}
	
  
  @Test
  public void getTitle() {
    try {
      driver.get("https://www.selenium.dev/");
      // get title
      String title = driver.getTitle();
      Assertions.assertEquals(title, "Selenium");
    } finally {
      driver.quit();
    }
  }
  @Test
  public void getCurrentUrl() {
    try {
      driver.get("https://www.selenium.dev/");
      // get current url
      String url = driver.getCurrentUrl();
      Assertions.assertEquals(url, "https://www.selenium.dev/");
    } finally {
      driver.quit();
    }
  }
}
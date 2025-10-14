package Interactions;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Base.BaseTest;

public class NavigationTest extends BaseTest{
    
	@BeforeEach
	public void setup() {
	    startFirefoxDriver();
	}
	
	@Test
    public void navigateBrowser() {
        
        //Convenient
        driver.get("https://selenium.dev");
            
        //Longer way
        driver.navigate().to("https://selenium.dev");
        String title = driver.getTitle();
        assertEquals(title, "Selenium");
        
        //Back
        driver.navigate().back();
        title = driver.getTitle();
        assertEquals(title, "Selenium");
        
        //Forward
        driver.navigate().forward();
        title = driver.getTitle();
        assertEquals(title, "Selenium");

        //Refresh
        driver.navigate().refresh();
        title = driver.getTitle();
        assertEquals(title, "Selenium");

        driver.quit();
    }
}

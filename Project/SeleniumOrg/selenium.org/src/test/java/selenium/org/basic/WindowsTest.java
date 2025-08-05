package selenium.org.basic;



import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WindowsTest  extends BaseTest {

	  @BeforeEach
	  public void setup() {
		    startFirefoxDriver();
	  }
	  @Test
    public void windowsExampleCode() throws InterruptedException {
        
    	
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        // Navigate to Url
        driver.get("https://www.selenium.dev/selenium/web/window_switching_tests/page_with_frame.html");
        //fetch handle of this
        String currHandle=driver.getWindowHandle();
        assertNotNull(currHandle);
        
        //click on link to open a new window
        driver.findElement(By.linkText("Open new window")).click();
        //fetch handles of all windows, there will be two, [0]- default, [1] - new window
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        //assert on title of new window
        String title=driver.getTitle();
        assertEquals("Simple Page",title);
        Thread.sleep(3000);
        
        //closing current window
        driver.close();
        //Switch back to the old tab or window
        driver.switchTo().window((String) windowHandles[0]);
        Thread.sleep(3000);
        
        //Opens a new tab and switches to new tab
        driver.switchTo().newWindow(WindowType.TAB);
        assertEquals("",driver.getTitle());
        Thread.sleep(3000);
        
        //Opens a new window and switches to new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        assertEquals("",driver.getTitle());
        Thread.sleep(3000);
        //quitting driver
        driver.quit(); //close all windows
	   
   	}
}

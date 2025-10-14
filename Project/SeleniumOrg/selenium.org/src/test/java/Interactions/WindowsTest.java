package Interactions;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.time.Duration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WindowType;
import Base.BaseTest;

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
        System.out.println(String.format("%s", currHandle));
        String hello = "Hello";
        System.out.println(String.format("%s", hello));
        //If you want a minimum of 4 characters, for instance,
        System.out.println(String.format("%4d", 5));
        assertNotNull(currHandle);
        
        //Get window size
        //Access each dimension individually
        int width = driver.manage().window().getSize().getWidth();
        int height = driver.manage().window().getSize().getHeight();
        System.out.printf("%,d :: %d", width, height);
        
        //Set window size
        driver.manage().window().setSize(new Dimension(1024, 768));

        //Or store the dimensions and query them later
        Dimension size = driver.manage().window().getSize();
        int width1 = size.getWidth();
        int height1 = size.getHeight();
        System.out.printf("\n%,d :: %d", width1, height1);
        
        //click on link to open a new window
        driver.findElement(By.linkText("Open new window")).click();
        //fetch handles of all windows, there will be two, [0]- default, [1] - new window
        Object[] windowHandles=driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        //assert on title of new window
        String title=driver.getTitle();
        assertEquals("Simple Page",title);
        Thread.sleep(3000);
        
        //Get window position
        //Fetches the coordinates of the top left coordinate of the browser window.
        // Access each dimension individually
        int x = driver.manage().window().getPosition().getX();
        int y = driver.manage().window().getPosition().getY();
        System.out.printf("\n%,d :: %d", x, y);
       
        // Or store the dimensions and query them later
        Point position = driver.manage().window().getPosition();
        int x1 = position.getX();
        int y1 = position.getY();
        System.out.printf("\n%,d :: %d", x1, y1);
        //Set window position
        // Move the window to the top left of the primary monitor
        driver.manage().window().setPosition(new Point(0, 0));
        
        //closing current window
        driver.close();
        
        //Switch back to the old tab or window
        driver.switchTo().window((String) windowHandles[0]);
        driver.manage().window().setPosition(new Point(100, 100));
        Thread.sleep(3000);
        
        //Opens a new tab and switches to new tab
        driver.switchTo().newWindow(WindowType.TAB);
        assertEquals("",driver.getTitle());
        Thread.sleep(3000);
        driver.manage().window().setPosition(new Point(0, 0));
        //Opens a new window and switches to new window
        driver.switchTo().newWindow(WindowType.WINDOW);
        assertEquals("",driver.getTitle());
        Thread.sleep(3000);
        //quitting driver
        driver.switchTo().newWindow(WindowType.TAB);
        assertEquals("",driver.getTitle());
        Thread.sleep(3000);
        driver.manage().window().minimize();
        driver.quit(); //close all windows
	   
   	}
}

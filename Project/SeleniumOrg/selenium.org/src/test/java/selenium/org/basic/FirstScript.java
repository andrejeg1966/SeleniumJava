package selenium.org.basic;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class FirstScript {
	
	@Test
	public void Test() throws InterruptedException
	{
		System.out.println("Execution after setting driver path in system variables");
		FirefoxOptions options = new FirefoxOptions(); 
	    options.setCapability("marionette", false);
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		String title = driver.getTitle();
		System.out.println("The page title is " +title);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		
		WebElement textBox = driver.findElement(By.name("my-text"));
		textBox.sendKeys("Selenium");
		Thread.sleep(3000);
        WebElement submitButton = driver.findElement(By.cssSelector("button"));
        submitButton.click();
        
        WebElement message = driver.findElement(By.id("message"));
        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
        
        String sMessage = message.getText();
        System.out.println("The message title is " +sMessage);
		
		
		
		driver.quit();
		System.out.println("Execution complete");
	}

}

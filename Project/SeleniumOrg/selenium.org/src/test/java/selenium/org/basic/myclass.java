package selenium.org.basic;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class myclass {
	 @Test
	  public void testLogin() throws InterruptedException {
		 
		 FirefoxOptions options = new FirefoxOptions();
	     WebDriver driver = new FirefoxDriver(options);
	     driver.get("http://www.google.com"); 
         WebElement element = driver.findElement(By.name("q"));
         Thread.sleep(3000);
         element.sendKeys("Cheese!");
         Thread.sleep(3000);
         element.submit();
	 }

}
	
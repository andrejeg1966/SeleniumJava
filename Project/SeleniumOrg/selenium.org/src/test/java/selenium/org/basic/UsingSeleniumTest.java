package selenium.org.basic;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UsingSeleniumTest  {
	
	
	WebDriver driver;

	@BeforeTest
	public void setup() {
		FirefoxOptions options = new FirefoxOptions(); 
	    options.setCapability("marionette", false);
		driver = new FirefoxDriver();
	}

	@Test
	public void eightComponents() {
		System.out.println("Execution after setting driver path in system variables");

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
		driver.get("https://www.selenium.dev/selenium/web/web-form.html");

		String title = driver.getTitle();
		assertEquals("Web form", title);

		WebElement textBox = driver.findElement(By.name("my-text"));
		WebElement submitButton = driver.findElement(By.cssSelector("button"));

		textBox.sendKeys("Selenium");
		submitButton.click();

		WebElement message = driver.findElement(By.id("message"));
		String value = message.getText();
		AssertJUnit.assertEquals("Received!", value);

	}

	@AfterTest
	public void teardown() {
		driver.quit();
		System.out.println("Execution complete");
	}

}

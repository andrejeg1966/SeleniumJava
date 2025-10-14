package selenium.org.basic;



import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Base.BaseTest;

public class FirstScriptChrome extends BaseTest{
    
	@BeforeEach
	public void createSession() {
		    ChromeOptions options = getDefaultChromeOptions();
		    options.setBrowserVersion("136");
		    driver = new ChromeDriver(options);
		    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  }
	@Test
	public void Test() throws InterruptedException
	{
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        driver.getTitle();

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

        WebElement textBox = driver.findElement(By.name("my-text"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        //WebElement submitButton = driver.findElement(By.cssSelector("button"));
        
        textBox.sendKeys("Selenium");
        submitButton.click();

        WebElement message = driver.findElement(By.id("message"));
        message.getText();
    }
	
	@AfterEach
	public void teardown() {
		driver.quit();
	}
}

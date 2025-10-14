package selenium.org.basic;

import java.time.Duration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Base.BaseTest;

public class NopComerceChrome extends BaseTest{

	@BeforeEach
	  public void createSession() {
		    ChromeOptions options = getDefaultChromeOptions();
		    options.setBrowserVersion("136");
		    driver = new ChromeDriver(options);
		    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    driver.manage().window().maximize();
	  }
	
	@Test
	public void loginToApplication() throws InterruptedException {
		driver.get("https://demo.nopcommerce.com");
		WebElement LogInButton = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
		LogInButton.click();
		Thread.sleep(3000);
		WebElement TextEmail = driver.findElement(By.id("Email"));
		TextEmail.sendKeys("goran.andrejevic@web.de");
		Thread.sleep(3000);
		WebElement TextPassword = driver.findElement(By.id("Password"));
		TextPassword.sendKeys("Velesnica1966?");
		Thread.sleep(3000);
		WebElement LogInLink = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));
		LogInLink.click();
		Thread.sleep(10000);
	}

}

package Interactions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.BaseTest;

public class AlertsTest extends BaseTest {

	  @BeforeEach
	  public void setup() {
		    startFirefoxDriver();
	  }
	  
	  @AfterEach
	    public void endSession() {
	        driver.quit();
	    }
	  
	  @Test
	    public void alertInformationTest() {
	        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");

	        driver.findElement(By.id("alert")).click();

	        //wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        Assertions.assertEquals("cheese", alert.getText());
	        alert.accept();

	    }
	  
	  @Test
	    public void alertEmptyInformationTest() {
	        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
	        driver.findElement(By.id("empty-alert")).click();


	        //wait.until(ExpectedConditions.alertIsPresent());

	        Alert alert = driver.switchTo().alert();
	        Assertions.assertEquals("", alert.getText());
	        alert.accept();

	    }
	  @Test
	    public void promptDisplayAndInputTest() throws InterruptedException {
	        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
	        driver.findElement(By.id("prompt")).click();

	        //Wait for the alert to be displayed and store it in a variable
	        //wait.until(ExpectedConditions.alertIsPresent());

	        Alert alert = driver.switchTo().alert();
	        Assertions.assertEquals("Enter something", alert.getText());

	        alert.sendKeys("Selenium");
	        Thread.sleep(3000);
	        alert.accept();

	    }
	  
	  @Test
	    public void promptDefaultInputTest() {
	        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");

	        driver.findElement(By.id("prompt-with-default")).click();

	        //wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        Assertions.assertEquals("Enter something", alert.getText());
	        alert.accept();
	    }
	  
	  @Test
	    public void multiplePromptInputsTest() {
	        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
	        driver.findElement(By.id("double-prompt")).click();

	        //wait.until(ExpectedConditions.alertIsPresent());

	        Alert alert1 = driver.switchTo().alert();
	        Assertions.assertEquals("First", alert1.getText());

	        alert1.sendKeys("first");
	        alert1.accept();


	        Alert alert2 = driver.switchTo().alert();
	        Assertions.assertEquals("Second", alert2.getText());
	        alert2.sendKeys("second");
	        alert2.accept();

	    }
	  
	  @Test
	    public void slowAlertTest() {
	        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
	        driver.findElement(By.id("slow-alert")).click();

	        //wait.until(ExpectedConditions.alertIsPresent());

	        Alert alert = driver.switchTo().alert();
	        Assertions.assertEquals("Slow", alert.getText());

	        alert.accept();

	    }
	  @Test
	    public void confirmationAlertTest() {
	        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");

	        driver.findElement(By.id("confirm")).click();

	        //wait.until(ExpectedConditions.alertIsPresent());
	        Alert alert = driver.switchTo().alert();
	        Assertions.assertEquals("Are you sure?", alert.getText());

	        alert.accept();
	        Boolean Url = driver.getCurrentUrl().endsWith("simpleTest.html");
	        System.out.println(Url);
	        Assertions.assertTrue(driver.getCurrentUrl().endsWith("simpleTest.html"));

	    }
	  
	  @Test
	    public void iframeAlertTest() {
	        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
	        WebElement iframe = driver.findElement(By.name("iframeWithAlert"));
	        driver.switchTo().frame(iframe);

	        driver.findElement(By.id("alertInFrame")).click();


	        //wait.until(ExpectedConditions.alertIsPresent());

	        Alert alert = driver.switchTo().alert();
	        Assertions.assertEquals("framed cheese", alert.getText());

	        alert.accept();

	    }
	  @Test
	    public void nestedIframeAlertTest() {
	        driver.get("https://www.selenium.dev/selenium/web/alerts.html#");
	        WebElement iframe1 = driver.findElement(By.name("iframeWithIframe"));
	        driver.switchTo().frame(iframe1);

	        WebElement iframe2 = driver.findElement(By.name("iframeWithAlert"));
	        driver.switchTo().frame(iframe2);

	        driver.findElement(By.id("alertInFrame")).click();


	        wait.until(ExpectedConditions.alertIsPresent());

	        Alert alert = driver.switchTo().alert();
	        Assertions.assertEquals("framed cheese", alert.getText());

	        alert.accept();

	    }



	 
	 @Test
	 public void testForAlerts() throws InterruptedException {
	
	     driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
	     driver.get("https://www.selenium.dev/documentation/webdriver/interactions/alerts/");
	     Thread.sleep(3000);
	     JavascriptExecutor js = (JavascriptExecutor) driver;
	     js.executeScript("alert('Sample Alert');");
	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	     wait.until(ExpectedConditions.alertIsPresent());
	     Alert alert = driver.switchTo().alert();
	     Thread.sleep(3000);
	     assertEquals("Sample Alert", alert.getText());
	     alert.accept(); 
	
	     js.executeScript("confirm('Are you sure?');");
	     wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	     wait.until(ExpectedConditions.alertIsPresent());
	     alert = driver.switchTo().alert();
	     Thread.sleep(3000);
	     assertEquals("Are you sure?", alert.getText());
	     alert.dismiss();
	     
	
	     js.executeScript("prompt('What is your name?');");
	     wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	     wait.until(ExpectedConditions.alertIsPresent());
	     alert = driver.switchTo().alert();
	     Thread.sleep(3000);
	     assertEquals("What is your name?", alert.getText());
	     alert.sendKeys("Selenium");
	     Thread.sleep(3000);
	     alert.accept();
	     
	     driver.quit();
	 }
}

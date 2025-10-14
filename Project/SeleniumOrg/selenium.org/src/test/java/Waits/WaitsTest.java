package Waits;


import java.time.Duration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsTest extends Base.BaseTest {
  @Test
  public void fails() {
    startChromeDriver(new ChromeOptions());

    driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
    driver.findElement(By.id("adder")).click();
 
    Assertions.assertThrows(
        NoSuchElementException.class,
        () -> {
          driver.findElement(By.id("box0"));
        });
  }

  @Test
  public void sleep() throws InterruptedException {
    startChromeDriver(new ChromeOptions());

    driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
    driver.findElement(By.id("adder")).click();

    Thread.sleep(1000);

    WebElement added = driver.findElement(By.id("box0"));

    Assertions.assertEquals("redbox", added.getDomAttribute("class"));
    Assertions.assertEquals("box0", added.getDomAttribute("id"));
  }
  /*
   This is a global setting that applies to every element location call for the entire session. 
   The default value is 0, which means that if the element is not found, it will immediately return an error. 
   If an implicit wait is set, the driver will wait for the duration of the provided value before returning the error. 
   Note that as soon as the element is located, the driver will return the element reference and the code will continue executing, 
   so a larger implicit wait value won’t necessarily increase the duration of the session.
   */
  @Test
  public void implicit() {
    startChromeDriver(new ChromeOptions());

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
    driver.findElement(By.id("adder")).click();

    WebElement added = driver.findElement(By.id("box0"));

    Assertions.assertEquals("redbox", added.getDomAttribute("class"));
  }
/*
 Explicit waits are loops added to the code that poll the application for a specific condition to evaluate as true before 
 it exits the loop and continues to the next command in the code. 
 If the condition is not met before a designated timeout value, the code will give a timeout error. 
 Since there are many ways for the application not to be in the desired state, 
 explicit waits are a great choice to specify the exact condition to wait for in each place it is needed. 
 Another nice feature is that, by default, the Selenium Wait class automatically waits for the designated element to exist. 
 */
  @Test
  public void explicit() {
    startChromeDriver(new ChromeOptions());

    driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
    WebElement revealed = driver.findElement(By.id("revealed"));
    driver.findElement(By.id("reveal")).click();

    Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    wait.until(d -> revealed.isDisplayed());

    revealed.sendKeys("Displayed");
    Assertions.assertEquals("Displayed", revealed.getDomProperty("value"));
  }

  @Test
  public void explicitWithOptions() {
    startChromeDriver(new ChromeOptions());

    driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
    WebElement revealed = driver.findElement(By.id("revealed"));
    driver.findElement(By.id("reveal")).click();

    Wait<WebDriver> wait =
        new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(2))
            .pollingEvery(Duration.ofMillis(300))
            .ignoring(ElementNotInteractableException.class);

    wait.until(
        d -> {
          revealed.sendKeys("Displayed");
          return true;
        });

    Assertions.assertEquals("Displayed", revealed.getDomProperty("value"));
  }
}
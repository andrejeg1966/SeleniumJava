package selenium.org.basic;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByAll;

public class LocatorsTest extends BaseTest {

	@BeforeEach
	  public void setup() {
	    startFirefoxDriver();
	  }
	
	@Test
    public void ByAllTest() {
        
        driver.get("https://www.selenium.dev/selenium/web/login.html");

        // get both logins
        By example = new ByAll(By.id("password-field"), By.id("username-field"));
        List<WebElement> login_inputs = driver.findElements(example);

        //send them both input
        login_inputs.get(0).sendKeys("username");
        login_inputs.get(1).sendKeys("password");
    }
	/*
	@Test
    public String ByChainedTest() {
        
        // Navigate to Url
        driver.get("https://www.selenium.dev/selenium/web/login.html");

        // Find username-field inside of login-form
        By example = new ByChained(By.id("login-form"), By.id("username-field"));
        WebElement username_input = driver.findElement(example);

        //return placeholder text
        String placeholder = username_input.getAttribute("placeholder");
        return placeholder;
    }
	*/
	@Test
	public void FindByCSSSelector () throws InterruptedException{
		// Navigate to Url
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement testInput = driver.findElement(By.cssSelector("#my-text-id")); 
        testInput.sendKeys("abcd");
        Thread.sleep(3000);
	}
	
	@Test
	public void FindByXpath () throws InterruptedException{
		// Navigate to Url
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        WebElement checkButton = driver.findElement(By.xpath("//*[@id=\"my-radio-2\"]")); 
        checkButton.click();
        Thread.sleep(3000);
	}
	
	@Test 
	public void findElementsFromElement() {
		try {
            driver.get("https://example.com");

            // Get element with tag name 'div'
            WebElement element = driver.findElement(By.tagName("div"));

            // Get all the elements available with tag name 'p'
            List<WebElement> elements = element.findElements(By.tagName("p"));
            for (WebElement e : elements) {
                System.out.println(e.getText());
            }
        } finally {
            driver.quit();
        }
	}
	
	@Test
	public void activeElementTest () throws InterruptedException {
		try {
	        driver.get("http://www.google.com");
	        driver.findElement(By.cssSelector("[name='q']")).sendKeys("webElement");

	        // Get attribute of current active element
	        String attr = driver.switchTo().activeElement().getAttribute("title");
	        System.out.println(attr);
	        Thread.sleep(3000);
	      } finally {
	        driver.quit();
	      }
	}
	
}

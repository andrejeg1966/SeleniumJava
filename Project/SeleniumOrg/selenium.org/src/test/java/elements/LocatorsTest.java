package elements;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;

import Base.BaseTest;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsTest extends BaseTest {
/*
 *  ByAll class enables you to utilize two By locators at once, finding elements that mach either of your By locators. 
 * For example, instead of having to utilize two FindElement() functions to find the username and password input fields seperately, 
 * you can instead find them together in one clean FindElements()
 */
	
	@Test
    public void ByAllTest() {
        // Create instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        // Navigate to Url
        driver.get("https://www.selenium.dev/selenium/web/login.html");

        // get both logins
        By example = new ByAll(By.id("password-field"), By.id("username-field"));
        List<WebElement> login_inputs = driver.findElements(example);

        //send them both input
        login_inputs.get(0).sendKeys("username");
        login_inputs.get(1).sendKeys("password");
        //WebElement button = driver.findElement(By.id("login-form-submit"));
        WebElement button = driver.findElement(By.cssSelector("#login-form-submit"));
        button.click();
        driver.quit();
    }
/*
 * ByChained
The ByChained class enables you to chain two By locators together. 
For example, instead of having to locate a parent element, and then a child element of that parent, you can instead combine those two FindElement() functions into one.
 */
	
	
	@Test
    public void ByChainedTest() {
        // Create instance of ChromeDriver
        WebDriver driver = new ChromeDriver();
        // Navigate to Url
        driver.get("https://www.selenium.dev/selenium/web/login.html");

        // Find username-field inside of login-form
        By example = new ByChained(By.id("login-form"), By.id("username-field"));
        WebElement username_input = driver.findElement(example);
        String placeholder = username_input.getAttribute("placeholder");
        System.out.println(placeholder);
       
        WebElement button = driver.findElement(By.cssSelector("#login-form-submit"));
        button.click();
        driver.quit();
        //return placeholder text
       //String placeholder = username_input.getAttribute("placeholder");
        //return placeholder;
    }
	
	@Test
	public void ByCSSSelector_Test() {
		WebDriver driver = new ChromeDriver();
		driver.get("C:/Dev/Selenium/Project/SeleniumOrg/selenium.org/src/test/resources/Locators.html");
		driver.manage().window().maximize();
		WebElement InputText = driver.findElement(By.cssSelector("#fname"));
		InputText.clear();
		InputText.sendKeys("Goran");
		driver.quit();
	}
	
	@Test
	public void ByClass_Test() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/login.html");
		driver.manage().window().maximize();
		WebElement InputText = driver.findElement(By.className("information"));
		InputText.clear();
		InputText.sendKeys("Goran");
		driver.quit();
	}
	
	@Test
	public void ById_Test() {
		WebDriver driver = new ChromeDriver();
		driver.get("C:/Dev/Selenium/Project/SeleniumOrg/selenium.org/src/test/resources/Locators.html");
		driver.manage().window().maximize();
		WebElement InputText = driver.findElement(By.id("fname"));
		InputText.clear();
		InputText.sendKeys("Goran");
		driver.quit();
	}
	
	@Test
	public void ByName_Test() {
		WebDriver driver = new ChromeDriver();
		driver.get("C:/Dev/Selenium/Project/SeleniumOrg/selenium.org/src/test/resources/Locators.html");
		driver.manage().window().maximize();
		WebElement Label = driver.findElement(By.name("newsletter"));
		driver.quit();
	}
	
	@Test
	public void ByLinkTest_Test() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("C:/Dev/Selenium/Project/SeleniumOrg/selenium.org/src/test/resources/Locators.html");
		driver.manage().window().maximize();
		WebElement Link = driver.findElement(By.linkText("Selenium Official Page"));
		Link.click();
		Thread.sleep(3);
		driver.quit();
	}
	
	@Test
	public void ByPartialLink_Test() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("C:/Dev/Selenium/Project/SeleniumOrg/selenium.org/src/test/resources/Locators.html");
		driver.manage().window().maximize();
		WebElement Link = driver.findElement(By.partialLinkText("Official Page"));
		Link.click();
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test
	public void ByTagName_Test() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("C:/Dev/Selenium/Project/SeleniumOrg/selenium.org/src/test/resources/Locators.html");
		driver.manage().window().maximize();
		WebElement Tag = driver.findElement(By.tagName("a"));
		Tag.click();
		Thread.sleep(3000);
		driver.quit();
	}
	
	
/*
* xpath
A HTML document can be considered as a XML document, and then we can use xpath which will be the path traversed to reach the element of interest to locate the element. 
The XPath could be absolute xpath, which is created from the root of the document. 
Example - /html/form/input[1]. This will return the male radio button. 
Or the xpath could be relative. 
Example- //input[@name=‘fname’]. This will return the first name text box.*/
	@Test
	public void ByXPath_TextInput_Test() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("C:/Dev/Selenium/Project/SeleniumOrg/selenium.org/src/test/resources/Locators.html");
		driver.manage().window().maximize();
		WebElement InputText = driver.findElement(By.xpath("//input[@value='Jane']"));
		InputText.clear();
		InputText.sendKeys("Goran");
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test
	public void ByXPath_RadioButtonF_Test() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("C:/Dev/Selenium/Project/SeleniumOrg/selenium.org/src/test/resources/Locators.html");
		driver.manage().window().maximize();
		WebElement RadioButton = driver.findElement(By.xpath("//input[@value='f']"));
		RadioButton.click();
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test
	public void ByXPath_RadioButtonM_Test() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("C:/Dev/Selenium/Project/SeleniumOrg/selenium.org/src/test/resources/Locators.html");
		driver.manage().window().maximize();
		WebElement RadioButton = driver.findElement(By.xpath("//input[@value='m']"));
		RadioButton.click();
		Thread.sleep(3000);
		driver.quit();
	}
	//Find eoements by abs path
	@Test
	public void ByXPath_absolue_Test() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/web/login.html");
		driver.manage().window().maximize();
		
		// get both logins
        By example = new ByAll(By.xpath("/html[1]/body[1]/main[1]/form[1]/input[1]"), By.xpath("/html[1]/body[1]/main[1]/form[1]/input[2]"));
        List<WebElement> login_inputs = driver.findElements(example);
        
        //send them both input
        login_inputs.get(0).sendKeys("username");
        login_inputs.get(1).sendKeys("password");
        
        WebElement button = driver.findElement(By.xpath("/html[1]/body[1]/main[1]/form[1]/input[3]"));
        button.click();
		Thread.sleep(3000);
		driver.quit();
	}
   
}

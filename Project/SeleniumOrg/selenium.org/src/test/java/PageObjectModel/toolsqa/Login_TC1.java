package PageObjectModel.toolsqa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import pages.Dashboard;
//import pages.HomePage;
//import pages.LoginPage;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Login_TC1 {
	
	
	 @Test
	  public void testLogin() {
		 
		 FirefoxOptions options = new FirefoxOptions();
	      WebDriver driver = new FirefoxDriver(options);
	      driver.get("https://demoqa.com/books");
	     
	      String Title = driver.getTitle();
	      System.out.println("Title");
	      System.out.println(Title);
	      
	      
		//Creating object of home page
			HomePage home = new HomePage(driver);
			
			//Creating object of Login page
			LoginPage login = new LoginPage(driver);
			
			//Creating object of Dashboard
			Dashboard dashboard = new Dashboard(driver);
			
			//Click on Login button
			home.clickLogin();
			
			//Enter username & password
			login.enterUsername("testuser");
			login.enterPassword("Password@123");
			
			//Click on login button
			login.clickLogin();
			
			
			
			//Capture the page heading and print on console
			//System.out.println("The page heading is --- " +dashboard.getHeading());
			
			//Click on Logout button
			dashboard.clickLogout();

	        //Close browser instance
	        driver.quit();
	 }
	
	/*
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "---Exact path to chromedriver.exe---");
		FirefoxOptions options = new FirefoxOptions();
		WebDriver driver = new FirefoxDriver();

		driver.get("https://demoqa.com/books");
		
		//Creating object of home page
		HomePage home = new HomePage(driver);
		
		//Creating object of Login page
		LoginPage login = new LoginPage(driver);
		
		//Creating object of Dashboard
		Dashboard dashboard = new Dashboard(driver);
		
		//Click on Login button
		home.clickLogin();
		
		//Enter username & password
		login.enterUsername("testuser-");
		login.enterPassword("Password@123");
		
		//Click on login button
		login.clickLogin();
		Thread.sleep(3000);
		
		
		//Capture the page heading and print on console
		System.out.println("The page heading is --- " +dashboard.getHeading());
		
		//Click on Logout button
		dashboard.clickLogout();

               //Close browser instance
               driver.quit();
	}*/

}

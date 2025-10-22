package Interactions;

import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import Base.BaseTest;

public class CookiesTest extends BaseTest{

	  @BeforeEach
	  public void setup() {
		    startFirefoxDriver();
	  }
	@Test
	  public void addCookie() {
	      driver.get("https://www.selenium.dev/selenium/web/blank.html");
	      // Add cookie into current browser context
	      driver.manage().addCookie(new Cookie("key", "value"));
	      driver.quit();
	}
	    @Test
	    public void getNamedCookie() throws InterruptedException {
	     
	        driver.get("https://www.selenium.dev/selenium/web/blank.html");
	        // Add cookie into current browser context
	        driver.manage().addCookie(new Cookie("foo", "bar"));
	        // Get cookie details with named cookie 'foo'
	        Cookie cookie = driver.manage().getCookieNamed("foo");
	        Assertions.assertEquals(cookie.getValue(), "bar");
	        Thread.sleep(3000);
	        driver.quit();
	      }
	  

	    @Test
	    public void getAllCookies() {
	      
	        driver.get("https://www.selenium.dev/selenium/web/blank.html");
	        // Add cookies into current browser context
	        driver.manage().addCookie(new Cookie("test1", "cookie1"));
	        driver.manage().addCookie(new Cookie("test2", "cookie2"));
	        // Get cookies
	        Set<Cookie> cookies = driver.manage().getCookies();
	         for (Cookie cookie : cookies) {
	            if (cookie.getName().equals("test1")) {
	                Assertions.assertEquals(cookie.getValue(), "cookie1");
	            }

	            if (cookie.getName().equals("test2")) {
	                Assertions.assertEquals(cookie.getValue(), "cookie2");
	            }
	         }
	         driver.quit();
	      }
	   

	    @Test
	    public void deleteCookieNamed() {
	     
	        driver.get("https://www.selenium.dev/selenium/web/blank.html");
	        driver.manage().addCookie(new Cookie("test1", "cookie1"));
	        // delete cookie named
	        driver.manage().deleteCookieNamed("test1");
	        driver.quit();
	    }

	    @Test
	    public void deleteCookieObject() {
	     
	        driver.get("https://www.selenium.dev/selenium/web/blank.html");
	        Cookie cookie = new Cookie("test2", "cookie2");
	        driver.manage().addCookie(cookie);
	        /*
	        Selenium Java bindings also provides a way to delete
	        cookie by passing cookie object of current browsing context
	        */
	        driver.manage().deleteCookie(cookie);
	      
	        driver.quit();
	      }
	  

	    @Test
	    public void deleteAllCookies() {
	     
	        driver.get("https://www.selenium.dev/selenium/web/blank.html");
	        // Add cookies into current browser context
	        driver.manage().addCookie(new Cookie("test1", "cookie1"));
	        driver.manage().addCookie(new Cookie("test2", "cookie2"));
	        // Delete All cookies
	        driver.manage().deleteAllCookies();
	     
	        driver.quit();
	      }

		  @Test
		  public void sameSiteCookie() {
		    driver.get("http://www.example.com");

		  	    Cookie cookie = new Cookie.Builder("key", "value").sameSite("Strict").build();
		        Cookie cookie1 = new Cookie.Builder("key", "value").sameSite("Lax").build();
		
		         driver.manage().addCookie(cookie);
		         driver.manage().addCookie(cookie1);
		
		         System.out.println(cookie.getSameSite());
		         System.out.println(cookie1.getSameSite());
		
		         driver.quit();
		  }
		  
		  @Test
		    public void getAllCookiesMundoDeportivo1() {
		      
		        driver.get("https://www.mundodeportivo.com/");
		        // Get cookies
		        Set<Cookie> cookies = driver.manage().getCookies();
		         for (Cookie cookie : cookies) {
		            System.out.println("cookie:");
		            System.out.println(cookie);
		         }
		         driver.quit();
		      }
		  
		  @Test
		    public void deleteAllCookiesMundoDeportivo() {
		     
			  	driver.get("https://www.mundodeportivo.com/");
		        // Delete All cookies
		        driver.manage().deleteAllCookies();
		     
		        driver.quit();
		      }
		  
		  @Test
		    public void getAllCookiesMundoDeportivo2() {
		      
		        driver.get("https://www.mundodeportivo.com/");
		        System.out.println("**************after delete cookies:*******************");
		        // Get cookies
		        Set<Cookie> cookies = driver.manage().getCookies();
		         for (Cookie cookie : cookies) {
		            System.out.println("cookie:");
		            System.out.println(cookie);
		         }
		         driver.quit();
		      }
		  
}

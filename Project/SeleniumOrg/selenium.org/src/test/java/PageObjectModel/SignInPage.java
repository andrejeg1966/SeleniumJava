package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Page Object encapsulates the Sign-in page.
 */
public class SignInPage {
  protected WebDriver driver;

  // <input name="user_name" type="text" value="">
  //private By usernameBy = By.name("user_name");
  private By usernameBy = By.name("email");
  // <input name="password" type="password" value="">
  //private By passwordBy = By.name("password");
  private By passwordBy = By.name("pass");
  // <input name="sign_in" type="submit" value="SignIn">
  //private By signinBy = By.name("sign_in");
  private By signinBy = By.name("login");

  public SignInPage(WebDriver driver){
    this.driver = driver;
     if (!driver.getTitle().equals("Facebook - log in or sign up")) {
      throw new IllegalStateException("This is not Sign In Page," +
            " current page is: " + driver.getCurrentUrl());
    }
  }

  /**
    * Login as valid user
    *
    * @param userName
    * @param password
    * @return HomePage object
    */
  public HomePage loginValidUser(String userName, String password) {
    driver.findElement(usernameBy).sendKeys(userName);
    driver.findElement(passwordBy).sendKeys(password);
    //driver.findElement(signinBy).click();
    driver.findElement(signinBy).submit();;
    return new HomePage(driver);
  }
}


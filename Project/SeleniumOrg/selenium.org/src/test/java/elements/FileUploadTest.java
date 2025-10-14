package elements;


import java.io.File;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Base.BaseTest;

public class FileUploadTest extends BaseTest {
	
  //private FirefoxDriver driver;

  @BeforeEach
  public void setup() {
    startFirefoxDriver();
  }
  
  @Test
  public void fileUploadTest() {
	//FirefoxOptions options = new FirefoxOptions();
	//driver = new FirefoxDriver(options);

    driver.get("https://the-internet.herokuapp.com/upload");
    File uploadFile = new File("src/test/resources/selenium-snapshot.png");
    String path = uploadFile.getAbsolutePath();
    System.out.println(path);

    WebElement fileInput = driver.findElement(By.cssSelector("input[type=file]"));
    
    fileInput.sendKeys(uploadFile.getAbsolutePath());
    driver.findElement(By.id("file-submit")).click();

    WebElement fileName = driver.findElement(By.id("uploaded-files"));
    Assertions.assertEquals("selenium-snapshot.png", fileName.getText());
  }
}

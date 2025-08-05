package bidirectional.chrome;



import static org.openqa.selenium.devtools.events.CdpEventTypes.domMutation;



import java.time.Duration;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.HasLogEvents;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScriptTest extends BaseTest {

  @BeforeEach
  public void createSession() {
    ChromeOptions options = getDefaultChromeOptions();
	options.setBrowserVersion("136");
	driver = new ChromeDriver(options);
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  @Test
  public void pinScript() {
    driver.get("https://www.selenium.dev/selenium/web/xhtmlTest.html");
    WebElement element = driver.findElement(By.id("id1"));
    System.out.println(element);
    ScriptKey key = ((JavascriptExecutor) driver).pin("return arguments;");
    System.out.println(key);
    List<Object> arguments =
        (List<Object>) ((JavascriptExecutor) driver).executeScript(key, 1, true, element);
    System.out.println(arguments);

    Assertions.assertEquals(List.of(1L, true, element), arguments);
  }

  @Test
  public void mutatedElements() {
    driver.get("https://www.selenium.dev/selenium/web/dynamic.html");
    CopyOnWriteArrayList<WebElement> mutations = new CopyOnWriteArrayList<>();

    ((HasLogEvents) driver).onLogEvent(domMutation(e -> mutations.add(e.getElement())));

    driver.findElement(By.id("reveal")).click();

    wait.until(_d -> !mutations.isEmpty());
    System.out.println(mutations.size());
    System.out.println(mutations.get(0));
    Assertions.assertEquals(mutations.get(0), driver.findElement(By.id("revealed")));
    
  }
}
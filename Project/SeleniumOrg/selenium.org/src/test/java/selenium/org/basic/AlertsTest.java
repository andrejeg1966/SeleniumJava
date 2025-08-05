package selenium.org.basic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;

//Licensed to the Software Freedom Conservancy (SFC) under one
//or more contributor license agreements.  See the NOTICE file
//distributed with this work for additional information
//regarding copyright ownership.  The SFC licenses this file
//to you under the Apache License, Version 2.0 (the
//"License"); you may not use this file except in compliance
//with the License.  You may obtain a copy of the License at
//
//http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing,
//software distributed under the License is distributed on an
//"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
//KIND, either express or implied.  See the License for the
//specific language governing permissions and limitations
//under the License.


import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsTest extends BaseTest {

  @BeforeEach
  public void setup() {
	    startFirefoxDriver();
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

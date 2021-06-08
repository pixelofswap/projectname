package comp.start.projectname;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class NewTestBrowsers {
	 WebDriver driver;
  @Test
  public void f() throws InterruptedException  {
	  
	  WebElement username=driver.findElement(By.id("txtUsername"));
	  username.sendKeys("Admin");
	  WebElement password=driver.findElement(By.id("txtPassword"));
	  password.sendKeys("admin123");
	  WebElement loginButton=driver.findElement(By.id("btnLogin"));
	  loginButton.click();
	  driver.quit();
	
	    }
	  
  
 @Parameters("myBrowser")
 @BeforeClass
  public void beforeClass(String comingBrowserType) 
  {
	 String browser=comingBrowserType;
		
		if (browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
			driver= new ChromeDriver();
		} 
		else if(browser.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
			driver= new InternetExplorerDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "Resource/geckodriver.exe");
			driver= new FirefoxDriver();
		}	
		else {
        throw new RuntimeException("The  browser specified is not available");
		}
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  System.out.println("After method");
		
    	driver.quit();
  }

}

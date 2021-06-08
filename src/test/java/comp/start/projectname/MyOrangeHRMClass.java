package comp.start.projectname;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyOrangeHRMClass {
	WebDriver driver;

	
	@BeforeTest
	  public void beforeClass() throws InterruptedException {
		  System.out.println("before method");
		  System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
			driver= new ChromeDriver();
		    driver.get("http://output.jsbin.com/usidix/1");
		    driver.manage().window().maximize();

		    
	  }
  @Test
  public void f() {
	  
		
		WebElement username=driver.findElement(By.id("txtUsername"));
		username.sendKeys("Admin");
		WebElement password=driver.findElement(By.id("txtPassword"));
		password.sendKeys("admin123");
		WebElement loginButton=driver.findElement(By.id("btnLogin"));
		loginButton.click();
		
	}
  
  @AfterTest
	public void afterTest() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}
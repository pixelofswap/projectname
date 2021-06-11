package comp.start.projectname;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;

public class AlertHandleClass {
	 WebDriver driver;
  @Test
  public void f() throws InterruptedException  {
	  System.out.println("My fst method");
	  driver.findElement(By.xpath("//input[@type='button']")).click();
	    
	   	Thread.sleep(5000);
	    	
	    Alert alt=driver.switchTo().alert();
	    System.out.println(alt.getText());
	    alt.accept();
	    
	   
	  
  }
  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  System.out.println("before method");
	  System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		driver= new ChromeDriver();
	    driver.get("http://output.jsbin.com/usidix/1");
	    driver.manage().window().maximize();

	    
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  System.out.println("After method");
		
    	driver.quit();
  }

}

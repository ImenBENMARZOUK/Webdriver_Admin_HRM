package Projet_CAIT.Webdriver_Admin_HRM;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class Connexion_TC {
	
	public static WebDriver driver;
	
	
	@BeforeTest  //Pre-conditions annotations commencent toujours par @Before
	  public static void OpenBrowser() {
			
		    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		    driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/");
			//driver.get("http://127.0.0.1/orangehrm-4.3.5/symfony/web/index.php/auth/login/");
			
			driver.manage().window().maximize();
			System.out.println(driver.getTitle());
			String title = driver.getTitle();
			Assert.assertEquals(title, "OrangeHRM");
		
	}
	
	
	@Test 
	  public static void Connexion(){
	   	
		       driver.findElement(By.id("txtUsername")).sendKeys("Admin");	       
		       driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		       driver.findElement(By.id("btnLogin")).click(); 
			   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   	
	      
	   }
  
  
  

}

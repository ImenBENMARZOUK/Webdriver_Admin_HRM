package Projet_CAIT.Webdriver_Admin_HRM;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CodeModulaire {
	
    static String browser="Firefox";
    static WebDriver driver;
	
	public static void main(String [] args)throws InterruptedException {
		

OpenBrowser();
//Login();	    
//ajoutTitre();
//Logout();
Thread.sleep(2000);
CloseBrowser();


	}
 
	       
    public static void OpenBrowser(){
   		
		if(browser.contains("Chrome")) {
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		}
		
		if(browser.contains("Firefox")) {
			
	   System.setProperty("webdriver.gecko.driver","C:\\geckodriver\\geckodriver.exe");
	   driver = new FirefoxDriver();	
	   driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	   driver.manage().window().maximize();
	   
}
    }
    public static void Login(){
   		

	       driver.findElement(By.id("txtUsername")).sendKeys("Admin");	       
	       driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	       driver.findElement(By.id("btnLogin")).click(); 
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		   
}
    
    public static void ajoutTitre(){
   		
	       int i = 12;
	       
	       driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     

	     driver.findElement(By.id("menu_admin_Job")).click(); 
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		     
		 driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	       
		 
	       driver.findElement(By.id("btnAdd")).click();
	       driver.findElement(By.id("jobTitle_jobTitle")).click();
	       driver.findElement(By.id("jobTitle_jobTitle")).click();
	       driver.findElement(By.id("jobTitle_jobTitle")).clear();
	       
	       
	       driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("bbbb");
	       driver.findElement(By.id("btnSave")).click();
	       i=i+1;
	      
	       
}
    
    
    
    public static void Logout(){
   		
	       driver.findElement(By.id("welcome")).click();

	       driver.findElement(By.linkText("Logout")).click();
    }
    public static void CloseBrowser(){
   		
        driver.close();
 }
}

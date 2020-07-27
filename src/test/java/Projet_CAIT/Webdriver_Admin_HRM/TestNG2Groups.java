package Projet_CAIT.Webdriver_Admin_HRM;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class TestNG2Groups {
	protected static WebDriver driver;

	
	@BeforeSuite (groups = {"live"})  //Pre-conditions annotations commencent toujours par @Before
  public static void OpenBrowser() {
		
	    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
}	
  
	@Test (priority =1, groups = {"regression"})
  public static void Connexion(){
   	
	       driver.findElement(By.id("txtUsername")).sendKeys("Admin");	       
	       driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	       driver.findElement(By.id("btnLogin")).click(); 
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   	
   	
   }
   
   @Test (priority =2,groups = {"live"})
  public static void AjouterTitre(){

	   

	       
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
	       
	       
	       driver.findElement(By.id("jobTitle_jobTitle")).sendKeys("ffff");
	       driver.findElement(By.id("btnSave")).click();

	       
	       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   }
   
  @Test (priority =3, enabled=false)
  
  public static void SupprimerTitre(){

	       driver.findElement(By.id("ohrmList_chkSelectRecord_11")).click();
	       driver.findElement(By.id("btnDelete")).click();
	       driver.findElement(By.id("dialogDeleteBtn")).click(); 	
   	
   }
  
   @Test (priority =4,groups = {"regression"})
  public static void Deconnexion(){

	       driver.findElement(By.id("welcome")).click();

	       driver.findElement(By.linkText("Logout")).click();
   	
   }  
  
   @AfterTest (groups = {"live"})  //Post-conditions annotations commencent toujours par @After
  public void CloseBrowser() {
       driver.close();
   } 
	
}

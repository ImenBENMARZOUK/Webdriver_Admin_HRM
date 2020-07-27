package Projet_CAIT.Webdriver_Admin_HRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class AjoutTitre_TC {
	protected static WebDriver driver;
	static int IdTitre=12;
	
	@DataProvider(name ="testTitre")
	
	 public static Object[] [] TitreData()
		{
			return new Object[] [] {
				
					{"TM" }	,
					{"ING DEV" }
			};
				
		}	
		
	   @Test (priority =2, dependsOnMethods = {"Connexion"},dataProvider ="testTitre" )
	  public static void AjouterTitre(String titre){

	  //String titre= "TF";   

		       
		       driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		     

		     driver.findElement(By.id("menu_admin_Job")).click(); 
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			     
			 driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
			 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		       
			 
		       driver.findElement(By.id("btnAdd")).click();
		       //driver.findElement(By.id("jobTitle_jobTitle")).click();
		      // driver.findElement(By.id("jobTitle_jobTitle")).click();
		       //driver.findElement(By.id("jobTitle_jobTitle")).clear();
		       
		       
		       driver.findElement(By.id("jobTitle_jobTitle")).sendKeys(titre);
		       driver.findElement(By.id("btnSave")).click();
		       IdTitre++;
		       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  
		       boolean present;
		       try {
		    	   driver.findElement(By.id("ohrmList_chkSelectRecord_"+IdTitre));
		          present = true;
		       } catch (NoSuchElementException e) {
		          present = false;
		       }
		       
		       
	   }
	   


}

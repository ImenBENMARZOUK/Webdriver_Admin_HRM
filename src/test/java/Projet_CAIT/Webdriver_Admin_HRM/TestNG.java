package Projet_CAIT.Webdriver_Admin_HRM;

import org.testng.annotations.Test;

import junit.framework.Assert;

import static org.testng.Assert.fail;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class TestNG {
	protected static WebDriver driver;
    static  int IdUtilisateur =21;
	static int IdTitre=11;
    
	@BeforeSuite   //Pre-conditions annotations commencent toujours par @Before
  public static void OpenBrowser() {
		
	    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
	
}	

	
	@Test (priority =0)
  public static void Connexion(){
   	
	       driver.findElement(By.id("txtUsername")).sendKeys("Admin");	       
	       driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	       driver.findElement(By.id("btnLogin")).click(); 
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   	
      
   }
   
	@Test (priority =1,dependsOnMethods = {"Connexion"})
	  public static void AjouterUtilisateurAdminActif(){

    String Utilisateur1 = "Steven Edwards";
    String Username1 = "01234";
      
		  driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	      driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      
		  driver.findElement(By.id("menu_admin_UserManagement")).click(); 
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  
		  driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      driver.findElement(By.id("btnAdd")).click();
	      
	      //sélectionner le role Admin
	        WebElement User_Role_select= driver.findElement(By.id("systemUser_userType"));
	        Select details_User_Role = new Select(User_Role_select);
	        
	        details_User_Role.selectByValue("1");
	        
	      //Récupérer la valeur de l'option sélectionnée
	        WebElement selected_value1 =details_User_Role.getFirstSelectedOption();
	        System.out.println("Voici le role qui a été sélctionnée =" + selected_value1.getText());
	      
	        //remplir les champs nom emloyé et username
	        driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(Utilisateur1);
	        driver.findElement(By.id("systemUser_userName")).sendKeys(Username1);
	        
	      //sélectionner le statut
	        WebElement statut_select= driver.findElement(By.id("systemUser_status"));
	        Select details_statut = new Select(statut_select);
	        
	        details_statut.selectByValue("1");
	        
	      //Récupérer la valeur de l'option sélectionnée
	        WebElement selected_value2 =details_statut.getFirstSelectedOption();
	        System.out.println("Voici le statut qui a été sélctionnée =" + selected_value2.getText());
	        
	        
	        driver.findElement(By.id("btnSave")).click();  
	        IdUtilisateur++;
	        
		       boolean present;
		       try {
		    	   driver.findElement(By.id("ohrmList_chkSelectRecord_"+IdUtilisateur));
		          present = true;
		       } catch (NoSuchElementException e) {
		          present = false;
		       }
	   }
	
   @Test (priority =2, dependsOnMethods = {"Connexion"})
  public static void AjouterTitre(){

  String titre= "TM";   

	       
	       driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     

	     driver.findElement(By.id("menu_admin_Job")).click(); 
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		     
		 driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	       
		 
	       driver.findElement(By.id("btnAdd")).click();
	       driver.findElement(By.id("jobTitle_jobTitle")).click();
	       driver.findElement(By.id("jobTitle_jobTitle")).click();
	       driver.findElement(By.id("jobTitle_jobTitle")).clear();
	       
	       
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
   
   @Test (priority =3, enabled=false)
  
  public static void SupprimerTitre(){

	       driver.findElement(By.id("ohrmList_chkSelectRecord_11")).click();
	       driver.findElement(By.id("btnDelete")).click();
	       driver.findElement(By.id("dialogDeleteBtn")).click(); 	
   	
   }
/**
   @Test (priority =4,dependsOnMethods = {"AjouterTitre"})
  public static void Deconnexion(){

	       driver.findElement(By.id("welcome")).click();

	       driver.findElement(By.linkText("Logout")).click();
   	
   }  
  
   @AfterTest   //Post-conditions annotations commencent toujours par @After
  public void CloseBrowser() {
       driver.close();
   } 
**/
}

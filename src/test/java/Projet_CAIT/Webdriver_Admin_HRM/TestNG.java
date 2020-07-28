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
import org.testng.annotations.DataProvider;


import java.io.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class TestNG {
	protected static WebDriver driver;
    static  int IdUtilisateur =34;
	static int IdTitre=34;
	static int IdStatut=27;
    
	@BeforeSuite   //Pre-conditions annotations commencent toujours par @Before
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

	
	@Test (priority =0)
  public static void Connexion(){
   	
	       driver.findElement(By.id("txtUsername")).sendKeys("Admin");	       
	       driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	       driver.findElement(By.id("btnLogin")).click(); 
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   	
      
   }

	@Test (priority =1,enabled=false, dependsOnMethods = {"Connexion"})
	 public static void AjouterUtilisateurAdminActif(){

	 	       JSONParser jsonP = new JSONParser();
		         try {
		        	 JSONArray jsonAA = (JSONArray)jsonP.parse(new FileReader("C:\\Users\\lenovo\\eclipse-workspace\\Webdriver_Admin_HRM\\GestionUtilisateur.json"));
		        	 for(int i=0; i<jsonAA.size(); i++) {
		 String Utilisateur1 = (String) ((JSONObject)jsonAA.get(i)).get("NomdelEmploye");
		 String NomUtilisateur = (String) ((JSONObject)jsonAA.get(i)).get("NomdelUtilisateur");
		 String MotDePasse = (String) ((JSONObject)jsonAA.get(i)).get("MotdePasse");
		 String ConfirmerMotDePasse = (String) ((JSONObject)jsonAA.get(i)).get("confirmerMotdePasse");


	          driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	          
	          driver.findElement(By.id("menu_admin_UserManagement")).click(); 
	          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	          
	          driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
	          driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	          driver.findElement(By.id("btnAdd")).click();
	          
	          //sÃ©lectionner le role Admin
	            WebElement User_Role_select= driver.findElement(By.id("systemUser_userType"));
	            Select details_User_Role = new Select(User_Role_select);
	            
	            details_User_Role.selectByValue("1");
	            
	          //RÃ©cupÃ©rer la valeur de l'option sÃ©lectionnÃ©e
	            WebElement selected_value1 =details_User_Role.getFirstSelectedOption();
	            System.out.println("Voici le role selectionne =" + selected_value1.getText());
	          

	            //remplir les champs obligatoire : nom emloyÃ© ,  non utilisateur , mot de passe , confirmer mot de passe 
	            driver.findElement(By.id("systemUser_employeeName_empName")).sendKeys(Utilisateur1);
	            driver.findElement(By.id("systemUser_userName")).sendKeys(NomUtilisateur);
	            driver.findElement(By.id("systemUser_password")).sendKeys(MotDePasse);
	            driver.findElement(By.id("systemUser_confirmPassword")).sendKeys(ConfirmerMotDePasse);
	            
	          //sélectionner le statut
	            WebElement statut_select= driver.findElement(By.id("systemUser_status"));
	            Select details_statut = new Select(statut_select);
	            
	            details_statut.selectByValue("1");
	 

	          //Récuperer la valeur de l'option sélectionné
	            
	            WebElement selected_value2 =details_statut.getFirstSelectedOption();
	            System.out.println("Voici le statut selectionne =" + selected_value2.getText());
	            
	            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	            driver.findElement(By.id("btnSave")).click();  
	            
	            IdUtilisateur++;
	               boolean present;
	               try {
	                   driver.findElement(By.id("ohrmList_chkSelectRecord_"+IdUtilisateur));
	                  present = true;
	               } catch (NoSuchElementException e) {
	                  present = false;
	               }
	            
			
				
				if(i < jsonAA.size() - 1) {
		  	  	    	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		  	  	    	driver.findElement(By.id("btnAdd")).click();
		  	  	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		  	  	       }
					 }/////ici fin du boucle for
					 }
		         
		         
					  catch (FileNotFoundException e) {
		             e.printStackTrace();
		          } catch (IOException e) {
		             e.printStackTrace();
		          } catch (ParseException e) {
		             e.printStackTrace();
		          }
		      		
		}

	@DataProvider(name ="testTitre")
	
 public static Object[] [] TitreData()
	{
		return new Object[] [] {
			
				{"ING QALITE" }	,
				{"ING DEVELOPPEMENT" },
				{"à supprimé" }
		};
			
	}	
	
   @Test (priority =2,enabled=false,dependsOnMethods = {"Connexion"},dataProvider ="testTitre" )
   
  public static void AjouterTitre(String titre){
    
	       driver.findElement(By.id("menu_admin_viewAdminModule")).click();
	       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     

	     driver.findElement(By.id("menu_admin_Job")).click(); 
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		     
		 driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	       
		 
	       driver.findElement(By.id("btnAdd")).click();
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

   @Test (priority =3,enabled=false,dependsOnMethods = {"Connexion"})
 
  public static void SupprimerTitre(){

	   
	       driver.findElement(By.id("ohrmList_chkSelectRecord_"+IdTitre)).click();
	       driver.findElement(By.id("btnDelete")).click();
	       driver.findElement(By.id("dialogDeleteBtn")).click(); 	

	       boolean notpresent;
	       try {
	          notpresent = true;
	       } catch (NoSuchElementException e) {
	    	   driver.findElement(By.id("ohrmList_chkSelectRecord_"+IdTitre));
	          notpresent = false;

	       } 
	       
   }

   
	@DataProvider(name ="testStatut")
	
    public static Object[] [] StatutData()
	{
		return new Object[] [] {
			
				{"CDD" }	,
				{"CDI" },
				//{"" }
				{"à supprimer" }
		};
			
	}	
	 @Test (priority =4,dependsOnMethods = {"Connexion"},dataProvider ="testStatut" )
	 
   public static void AjouterStatutEmploi(String statut){
	    
       driver.findElement(By.id("menu_admin_viewAdminModule")).click();
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
     

     driver.findElement(By.id("menu_admin_Job")).click(); 
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     
	 driver.findElement(By.id("menu_admin_employmentStatus")).click();
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       
	 
       driver.findElement(By.id("btnAdd")).click();
       driver.findElement(By.id("empStatus_name")).sendKeys(statut );
       driver.findElement(By.id("btnSave")).click();
       IdStatut++;
       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       boolean present;
       try {
    	   driver.findElement(By.id("ohrmList_chkSelectRecord_"+IdStatut));
          present = true;
       } catch (NoSuchElementException e) {
          present = false;

       }     
}

	 
	 
	 
	 
	 @Test (priority =5,dependsOnMethods = {"Connexion"})
	 
	  public static void SupprimerStatut(){

		       driver.findElement(By.id("ohrmList_chkSelectRecord_"+IdStatut)).click();
		       driver.findElement(By.id("btnDelete")).click();
		       driver.findElement(By.id("dialogDeleteBtn")).click(); 	

		       boolean notpresent;
		       try {
		          notpresent = true;
		       } catch (NoSuchElementException e) {
		    	   driver.findElement(By.id("ohrmList_chkSelectRecord_"+IdTitre));
		          notpresent = false;

		       } 
		       
	   } 
   
   
   
	 
	 
	 
	 
   /**
   @Test (priority =5,dependsOnMethods = {"AjouterTitre"})
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

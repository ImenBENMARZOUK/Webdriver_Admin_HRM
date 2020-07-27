package Projet_CAIT.Webdriver_Admin_HRM;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import Projet_CAIT.Webdriver_Admin_HRM.Connexion_TC;





public class AjouterUtilisateurAdminActif_TC {
	public static WebDriver driver;
	
    static  int IdUtilisateur =19;

	@Test
	
	
	 public static void AjouterUtilisateurAdminActif(){

			System.out.println("ici erreur");
			
		    String Utilisateur1 = "Steven Edwards";
		    String NomUtilisateur = "steven steven";
		    String MotDePasse  = "Azerty77*+";
		    String ConfirmerMotDePasse = "Azerty77*+";
	      
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   
		   
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
		        driver.findElement(By.id("systemUser_userName")).sendKeys(NomUtilisateur);
		        
		      //sélectionner le statut
		        WebElement statut_select= driver.findElement(By.id("systemUser_status"));
		        Select details_statut = new Select(statut_select);
		        
		        details_statut.selectByValue("1");
		        
		      //Récupérer la valeur de l'option sélectionnée
		        WebElement selected_value2 =details_statut.getFirstSelectedOption();
		        System.out.println("Voici le statut qui a été sélctionnée =" + selected_value2.getText());
		        
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
		   }



}

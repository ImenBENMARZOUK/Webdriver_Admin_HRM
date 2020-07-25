package Projet_CAIT.Webdriver_Admin_HRM;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Emploi_Ajout_suppression_Titre {
	public static void main(String [] args)throws InterruptedException {
		
		
		 System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");//Entrer l'url à tester 
	     //driver.get(""http://127.0.0.1/orangehrm-4.3.5/symfony/web/index.php/auth/login"");
		 driver.manage().window().maximize();//Agrandir la fenetre du navigateur



/****************************************Fonction login********************************/

	       driver.findElement(By.id("txtUsername")).sendKeys("Admin");	       
	       driver.findElement(By.id("txtPassword")).sendKeys("admin123");
	       driver.findElement(By.id("btnLogin")).click(); 
		   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	       
/****************************************Fonction Ajout Titre********************************/	
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
	      
	     
/****************************************Fonction suppression Titre********************************/	
	 
	       
	       driver.findElement(By.id("ohrmList_chkSelectRecord_"+i)).click();
	       driver.findElement(By.id("btnDelete")).click();
	       driver.findElement(By.id("dialogDeleteBtn")).click();
	       
/****************************************Fonction suppression plusieursTitre********************************/	       
	        
	       
	       
	       
/****************************************Fonction Logout********************************/	       
	       
	       driver.findElement(By.id("welcome")).click();

	       driver.findElement(By.linkText("Logout")).click();
		
		
	}
}

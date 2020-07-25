package Projet_CAIT.Webdriver_Admin_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Connexion {
	
 static WebDriver driver;
	
	public static void Login(String idUserName,String UserName,String idPasseword,String Passeword,String bntLogin){
		
		    driver.findElement(By.id(idUserName)).sendKeys(UserName); 
		    driver.findElement(By.id(idPasseword)).sendKeys(Passeword);
		    driver.findElement(By.id(bntLogin)).click();
}
	

	public static void Logout() {
		
    driver.findElement(By.id("welcome")).click();

   driver.findElement(By.linkText("Logout")).click();
	
	}
}

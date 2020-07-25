package Projet_CAIT.Webdriver_Admin_HRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {

		
	Browser.open();
	System.out.println("Start OK");

	
	Connexion.Login("txtUsername", "Admin", "txtPassword", "admin123", "btnLogin");
	
	System.out.println("Connexion OK");	

	//Connexion.Logout();
	
	
	//Browser.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}

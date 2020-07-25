package Projet_CAIT.Webdriver_Admin_HRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

 static WebDriver driver;
	
	
	public static void open() {
		
		    System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		    driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/");
			driver.manage().window().maximize();
	}
	
	
	public static void close() {
    	
        driver.close();
        
    }
	
	
}

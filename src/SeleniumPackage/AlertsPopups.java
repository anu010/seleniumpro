package SeleniumPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsPopups {

	public static void main(String[] args) throws InterruptedException, IOException {
Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip); 
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverpath"));
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
			
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi"); // enter url
		
		driver.manage().window().maximize();
		
		driver.findElement(By.name("proceed")).click(); // Clicking on Signin button without entering any values.
		
		Thread.sleep(3000);
		
		Alert alert = driver.switchTo().alert(); // switch to: Switching from main Webpage to alert area.
		
		System.out.println(alert.getText()); // to get the text that si shown on the alert page.
		
		alert.accept(); // clicks on 'ok btn'
		
	    System.out.println("clicked on 'ok button'");
		
		//alert.dismiss(); used for 'cancel btn'

		Thread.sleep(3000);
		
		driver.quit();
				
				
				
	}

}

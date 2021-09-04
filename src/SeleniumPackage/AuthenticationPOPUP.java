package SeleniumPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPOPUP {

	public static void main(String[] args) throws IOException, InterruptedException {
		
Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip); 
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverpath"));
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
			
				String username = "admin";
				String password = "admin";
				Thread.sleep(2000);
		
				driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
				System.out.println("credentials entered");
//				Alert alert = driver.switchTo().alert();
//				alert.accept();
				Thread.sleep(2000);
				driver.quit();
				
	}

}

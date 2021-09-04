package SeleniumPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowPopUp {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip); 
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverpath"));				WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
						
				driver.manage().window().maximize();
				
				driver.get("https://html.com/input-type-file/"); // enter url
				
				
				Thread.sleep(2000);
				
				driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("C:\\Users\\anush\\Desktop\\examplepic.png");
				System.out.println("file uploaded");
				Thread.sleep(2000); 
				
				driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
				System.out.println("Submitted");
				
				Thread.sleep(2000);
				
				driver.navigate().back();
				
				Thread.sleep(2000);
				
				System.out.println( driver.manage().window().getSize());
				
				Dimension d = new Dimension(350,530); // to decrease the size of the window.
				
				
			    driver.manage().window().setSize(d);
				
				
				Thread.sleep(4000);
				
				
				
				driver.quit();
	}

}

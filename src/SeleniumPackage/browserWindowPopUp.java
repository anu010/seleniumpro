package SeleniumPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class browserWindowPopUp {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//types of PopUp's?
		//	1. alerts --  JavaScript PopUps -- Alert API (accept,dismiss)
		//2. File Upload Pop up -- BrowseButton (type = file, sendKeys(path))
		//3. Browser Window Pop Up -- Advertisement Pop Up (WindowHandler API - getWindowHandles() )
	  
		
		//WindowHandler is an API which handles the window popups  
		
		
Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip); 
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromedriverpath"));		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		
		
		driver.findElement(By.xpath(" //a[contains(text(),'Follow On Twitter')]")).click();
		
		Thread.sleep(2000);
		
		//to get parent and child window id's we use WindowHandles method & it gives u one Set object of string type (Set<String>).
		Set<String> handler = driver.getWindowHandles();
		//there is a set object where two window id's are available.
		//Set object doesnt store values on the basis of indexes like arraylist. they iterate.
		
		Iterator<String> it = handler.iterator();
		
		String parentWindowId = it.next();
		
		System.out.println("parentWindowId" + parentWindowId);
		
		String childWindowId = it.next();
		
		System.out.println("childWindowId" + childWindowId);
		
		//as of now we got the id's of both the windows we have to switch it .
		
		driver.switchTo().window(childWindowId);
		
		System.out.println("childWindowPopup title" +driver.getTitle());
	
		driver.close(); // after closing the extra window the control gets lost . so, we have again switch to parent window id.
		
		System.out.println("finished");
		
		driver.switchTo().window(parentWindowId);
		
		System.out.println("parentWindowPopup title" +driver.getTitle());

		
		
		Thread.sleep(2000);
		
		driver.quit();
		
		
	}

}

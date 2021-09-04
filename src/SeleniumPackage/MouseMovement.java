package SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Stuff\\Selenium jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.

		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://ridgeschools.org/");
		
		// MouseOver -- for mouseover actions class is used.

		Actions action = new Actions(driver); // Actions class will ask for driver to pass.
		
		action.moveToElement(driver.findElement(By.linkText("Achievements"))).build().perform(); // moveToElement() method will move the cursor to the targeted element.
				
		Thread.sleep(3000);
		
		action.moveToElement(driver.findElement(By.linkText("Results"))).build().perform();
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("CBSE")).click();
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		
		Thread.sleep(2000);
		
		driver.quit();
		
	}

}

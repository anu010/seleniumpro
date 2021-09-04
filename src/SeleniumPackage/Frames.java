package SeleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {
	
	//switchTo().frame(int) – Switch to a frame with its index
	//switchTo().frame(“name of the frame”) – Switch to a frame with its name
	//switchTo().frame (WebElement) – Switch to a frame with its web element location
	//switchTo().defaultContent() – Switch back to default page


	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Stuff\\Selenium jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
				
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("https://www.freecrm.com"); // enter url
		
		driver.findElement(By.name("username")).sendKeys("helloworld");
		driver.findElement(By.name("password")).sendKeys("hello");
		driver.findElement(By.xpath("//input[@type = 'submit']")).click();
		
		Thread.sleep(2000);
		
		driver.switchTo().frame("mainpanel");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		driver.quit();
		
		

	}

}

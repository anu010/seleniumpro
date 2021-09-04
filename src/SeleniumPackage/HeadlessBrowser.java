package SeleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowser {
	
																				//ASK ABHI

	public static void main(String[] args) throws InterruptedException {
		
		
		//mandatory options
		//1. chrome version should be greater than 59 on mac & greater than 60 on windows.
		
		
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Stuff\\Selenium jars\\chromedriver_win32\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("window-size = 1400,800"); 
		options.addArguments("headless");					//showing error
		
		
		
		WebDriver driver = new ChromeDriver(options); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
			
		//Dynamic Waits		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //it says to selenium atleast to wait for 40 seconds until the whole page gets loaded.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //it is applicable for all the elements that are available on the page to get loaded.

		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		System.out.println("before login title is ==  " + driver.getTitle());
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("testcaseselenium");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test@2021");
		driver.findElement(By.xpath("//input[@name= 'proceed']")).click();
		
		System.out.println("before login title is ==  " + driver.getTitle());
		 
		
	}

}

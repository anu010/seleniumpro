package SeleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Stuff\\Selenium jars\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
			
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		//Dynamic Waits		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //it says to selenium atleast to wait for 40 seconds until the whole page gets loaded.
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //it is applicable for all the elements that are available on the page to get loaded.

		
		
		//we have to use driver.navigate().back() to move to last seen page and forward() to move forward
		
		driver.get("https://www.google.com");
		
		System.out.println("Hey! it's me Google");
		
		Thread.sleep(2000);
		
		
		
		driver.navigate().to("https://www.flipkart.com/");
		
		System.out.println("Hey! I'm a Kart with flip");
		
		Thread.sleep(2000);
		
		
		
		driver.navigate().back();
		
		Thread.sleep(2000);
		
		System.out.println("I'm back to Google");
		
		driver.navigate().to("https://www.amazon.com/");
		
		Thread.sleep(2000);
		
		System.out.println("Amazingly... AMAZON");
		
		driver.navigate().refresh(); // to refresh the page.
		
		Thread.sleep(2000);
		
		driver.navigate().to("https://www.snapdeal.com/");
		
		System.out.println("Let's have a snapping Deal");
		
		Thread.sleep(2000);
		
		driver.navigate().back(); // amazon
		
		Thread.sleep(1000);
		
		driver.navigate().back(); //google
		
		Thread.sleep(1000);
		
		driver.navigate().forward(); // amazon
		
		Thread.sleep(1000);
		
		driver.navigate().back(); //google
		
		System.out.println("Reached Google Home");
		
		
		driver.quit();
	}

}

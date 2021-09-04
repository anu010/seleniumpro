package SeleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {

	public static void main(String[] args) throws InterruptedException{
		
        System.setProperty("webdriver.chrome.driver", "D:\\Selenium Stuff\\Selenium jars\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
			
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		//Dynamic Waits		
		driver.manage().timeouts().pageLoadTimeout(70, TimeUnit.SECONDS); //it says to selenium atleast to wait for 40 seconds until the whole page gets loaded.
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS); //it is applicable for all the elements that are available on the page to get loaded.

		driver.get("https://html.com/input-type-file/");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("hello world");
		
		Thread.sleep(3000);
		
		System.out.println("entered the value in search bar");
		
//		driver.quit();
		
        driver.get("https://html.com/input-type-file/");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("hello another world");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[contains(@value, 'Search')]"));
		
		System.out.println("entered");
		
		
		// dynamic id: input here numbers can change contains as given below
		// id = test_123
		// By.id("test_123")
		//use starts-with
		// id=test_456
		// id= test_789
		// id= test_test_7890_test
		// ends-with
		// id =1234_test_t
		// id = 2345_test_t
		// id = 678_test_t
		 		
		
		//driver.findElement(By.xpath("//input[starts-with(@id,'test_')]"));
		//driver.findElement(By.xpath("//input[contains(@id,'test_')]"));
		//driver.findElement(By.xpath("//input[ends-with(@id, 'test_t')]"));
		
		driver.quit();
		

	}

}

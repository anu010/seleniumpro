package SeleniumPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class BootstrapDrpdown {

	public static void main(String[] args) throws InterruptedException {
		
		
//		System.setProperty("webdriver.chrome.silentOutput","true");
		
		//ChromeDriverService is a class -- mainly responsible to manage the lifecycle of chrome driver server
	    System.setProperty("	ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY", "true" );
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Stuff\\Selenium jars\\chromedriver_win32\\chromedriver.exe");
		
		
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
			
//		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		//Dynamic Waits		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //it says to selenium atleast to wait for 40 seconds until the whole page gets loaded.
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //it is applicable for all the elements that are available on the page to get loaded.

		
//		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		
		driver.get("https://www.codehim.com/demo/bootstrap-multiselect-dropdown/");
		
		driver.findElement(By.xpath("//button[@class='multiselect dropdown-toggle btn btn-default']")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class=\"multiselect-container dropdown-menu\"]//li//a//label"));

		System.out.println(list.size());
		
		Thread.sleep(2000);
		
		
//		  driver.findElement(By.xpath("//ul[@class=\"multiselect-container dropdown-menu\"]//li//a//label[@class='checkbox' and @title = 'Cheese']")).click();
//		System.out.println("clicked");
		
		
		//to select all the list elements given
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			list.get(i).click();
			
		}
		
		
		
		//to select a particular element name.
		
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).getText());
//			if(list.get(i).getText().contains("Angular")) {
//			list.get(i).click();
//			break;
//			}
//		} 
		
		
	}

}

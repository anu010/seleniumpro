package SeleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalendarSelectByJSExecutor {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.silentOutput","true"); //as it is showing timout exception
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Stuff\\Selenium jars\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
			
//		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		//Dynamic Waits		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //it says to selenium atleast to wait for 40 seconds until the whole page gets loaded.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //it is applicable for all the elements that are available on the page to get loaded.

		
		driver.get("https://www.spicejet.com/"); //URL
		
		System.out.println("hi");
//		driver.findElement(By.className("ui-datepicker-trigger")).click();
		Thread.sleep(2000);
		
		//creating the element
		//WebElement date =  driver.findElement(By.id("ctl00_mainContent_view_date1").sendKeys(30-06-2021));
		//String dateVal = "30-06-2021";
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).sendKeys("30-06-2021");
		
		//selectDateByJS(driver, date,dateVal);
		System.out.println("finished");
		Thread.sleep(3000);
				
		
		
	}
	
	//JS Executor writing outside of the main method()
	
	//webDriver driver -- when ever we JS executor we cast webDriver into it.
	//WebElement element -- on which element we want to perform the action
	// String dateVal -- what exactly you want to pass
	
	public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal)  throws InterruptedException  {
		JavascriptExecutor js = ((JavascriptExecutor)driver);

		js.executeScript ("document.getElementById('ctl00_mainContent_view_date1').removeAttribute('readonly',0);");
		
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');",element);
		System.out.println("getting entered");
		
	}
	
	
	
	
	

}

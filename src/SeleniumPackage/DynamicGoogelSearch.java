package SeleniumPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicGoogelSearch {

	public static void main(String[] args) throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver", "D:\\Selenium Stuff\\Selenium jars\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
			
//		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		//Dynamic Waits		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //it says to selenium atleast to wait for 40 seconds until the whole page gets loaded.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //it is applicable for all the elements that are available on the page to get loaded.

		driver.get("https://www.google.co.in/");
		
		driver.findElement(By.xpath("//input[@class = 'gLFyf gsfi']")).sendKeys("testing");
		Thread.sleep(2000);
		
		//we findelement's becoz there are many elements..,  //double slash in xpath means -- total nbr of child elements
		// decendant mean child of 'li'
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role = 'listbox']//li/descendant::div[@class='wM6W7d']"));
		
		System.out.println("total number of suggestions in search box :::  " + list.size());
		
		
		//when ever we have to iterate the list we use 'For Loop'
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			
			if(list.get(i).getText().contains("testing methodologies")) {
				list.get(i).click();
				System.out.println("clicked");
				break;
				
			}
		}
		
		
		
		
//		driver.quit();
		
		
		
		

	}

}

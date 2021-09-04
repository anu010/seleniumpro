package SeleniumPackage;

import java.util.concurrent.TimeUnit;                  //  ASK ABHI  //

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTable {

	public static void main(String[] args)  {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Stuff\\Selenium jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.

//		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://ui.cogmento.com/");
		
		driver.findElement(By.xpath("//input[@placeholder = 'E-mail address']")).sendKeys("user3pro7@gmail.com");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("Freecrm@2021");
		
		driver.findElement(By.xpath("//div[contains(text(), 'Login')]")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
		
//		driver.findElement(By.xpath("//input[@type = 'checkbox']")).click();
		
		//Method 1.
			// - Iterate row & column & get the cell value.
			// - Using FOR Loop
			// - Get total rows & iterate table
			// - put if(srting matches) then select thee value
			// - lengthy method
		
		
		
		//tbody/tr[1]/td[2]
		//tbody/tr[2]/td[2]
		//tbody/tr[3]/td[2]
		//tbody/tr[4]/td[2]
		//tbody/tr[5]/td[2]
		
//		String before_xpath = "//tbody/tr[";
//		String after_xpath = "]/td[2]";
//		
//		for(int i=1; i<=5; i++) {
//			String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
//			System.out.println(name);
//			if(name.contains("test 3 third")) {
//				
//				driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[1]")).click();
//				
//			}
//			
//			
//			
//		}
		
		
		
		//METHOD - 2
			//- using the custom x-path
			//- using parent & preceding sibling tags
			//- no need to write for loop
			//- no full iteration of table
			//- Single line statement
			//- more dynamic
			//- efficient & fast
//		Thread.sleep(2000);
		
		
														// ASK ABHI //
		   
//		driver.findElement(By.xpath("//a[contains(text(), 'test 1 first')]//parent::td//parent::tr//preceding-sibling::td/div/label")).click();
		
		
		driver.get("https://datatables.net/extensions/select/examples/initialisation/checkbox.html");
		
		driver.findElement(By.xpath("//td[@class='sorting_1' and text() = 'Ashton Cox']//parent::tr[@class='odd']//preceding-sibling::td")).click();
		
	}

}

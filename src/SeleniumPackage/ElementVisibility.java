package SeleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibility {

	public static void main(String[] args) throws InterruptedException {
		
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Stuff\\Selenium jars\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();//launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		//Dynamic Waits		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //it says to selenium atleast to wait for 40 seconds until the whole page gets loaded.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //it is applicable for all the elements that are available on the page to get loaded.

		driver.get("https://www.google.com");
		
		System.out.println("Hey! it's me Google");
		
		Thread.sleep(2000);
		
		
		driver.navigate().to("https://register.rediff.com/register/register.php?FormName=user_details"); //enter url

		
		// isDisplayed() - applicable for all webElements.
		boolean b1 = driver.findElement(By.xpath("//input[contains(@value , 'Check availability')]")).isDisplayed();
		System.out.println("isDisplayed() -- " + b1); //it should return TRUE
		 
		
		
		
		 driver.navigate().to("https://verifalia.com/validate-email");
		 		 
		 Thread.sleep(2000);
		
		 //isEnabled() -- 
		boolean b3 = driver.findElement(By.xpath("//button[contains(text(),'Validate')]")).isEnabled();
		System.out.println("before entering mail id  - isEnabled() -- " + b3); //returns FALSE becoz validate button is not enabled(not working when clicked)
		
		//entering mailid to enable the validate button
		driver.findElement(By.name("inputData")).sendKeys("abcd@gmail.com");

		
		boolean b5 = driver.findElement(By.xpath("//button[contains(text(),'Validate')]")).isEnabled();
		System.out.println("after entering mail id - isEnabled() -- " + b5); //returns FALSE becoz validate button is not enabled(not working when clicked)
		
		
		driver.navigate().back();
		
		boolean b7 = driver.findElement(By.id("Register")).isEnabled();
		System.out.println("isEnabled() -- " + b7); // returns TRUE becoz button is Enabled
		
		Thread.sleep(2000);
		
		
		//isSelected() method: only applicable for checkbox, dropdown, radiobutton.
		boolean b9 = driver.findElement(By.xpath("//input[@type = 'checkbox']")).isSelected();
		System.out.println("before clicking - isSelected() --" + b9); //False
		
		//de-select the checkbox:
		driver.findElement(By.xpath("//input[@type = 'checkbox']")).click();
		
		Thread.sleep(2000);
		
		boolean b11 = driver.findElement(By.xpath("//input[@type = 'checkbox']")).isSelected();
		System.out.println("after clicking - isSelected() --" + b11); //TRUE

		
		
		
		
		driver.quit();
		

		
		
	}

}

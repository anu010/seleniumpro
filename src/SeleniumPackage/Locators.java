package SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "D:\\\\Selenium Stuff\\\\Selenium jars\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		 driver.manage().window().maximize();
		
		driver.get("https://accounts.google.com/signup/v2/webcreateaccount?hl=en&flowName=GlifWebSignIn&flowEntry=SignUp");
		
		// Total 8 locators are present.
		
		// 1. Using x-path locator:
		
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Hello");
		
		// 2. Using id locator:
		
		driver.findElement(By.id("lastName")).sendKeys("World");
		
		// 3. Using name locator:
		driver.findElement(By.name("Username")).sendKeys("Welcome123");
		
		// 4. Using linkText locator:
		//driver.findElement(By.linkText("Help")).click();
		
		// 5. partialLinkText: Eg: do you want to create a business account . From this Whole link text you can select few words like example "account" as given below:
		//driver.findElement(By.partialLinkText("account")).click();
		
		// 6.CSSselector:
		driver.findElement(By.cssSelector("#passwd > div.aCsJod.oJeWuf > div > div.Xb9hP > input")).sendKeys("google@2021");
		
		System.out.println("password entered");
		
		// 7.className: better not use , Becoz classnamee could be "Duplicate".
		//driver.findElement(By.className("confirmpassword")).sendKeys("google@2021"); //className if available
		
		
		
		Thread.sleep(3000);
		
		driver.quit();

	}

}

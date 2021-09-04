package SeleniumPackage;

import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class addFolerClass {

	public static void main(String[] args) throws InterruptedException {
	
				System.setProperty("webdriver.chrome.driver", "D:\\Selenium Stuff\\Selenium jars\\chromedriver_win32\\chromedriver.exe");
				
				WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
					
				driver.manage().window().maximize();
				
				driver.manage().deleteAllCookies();
				
				//Dynamic Waits		
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //it says to selenium atleast to wait for 40 seconds until the whole page gets loaded.
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //it is applicable for all the elements that are available on the page to get loaded.

				
				//Static Wait --  Thread.sleep();
			
				driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
	
				driver.findElement(By.id("login1")).sendKeys("testcaseselenium");
			       driver.findElement(By.id("password")).sendKeys("Test@2021");
			       driver.findElement(By.xpath("//input[@title = 'Sign in' and @name='proceed']")).click();
					Thread.sleep(2000);
			       //add folder
			       driver.findElement(By.xpath("//span[@title='Add a new folder']")).click();
			       Thread.sleep(2000);
			       driver.findElement(By.xpath("//input[@id='folder_name']")).sendKeys("MyFolders");
			       Thread.sleep(2000);
			       driver.findElement(By.xpath("//input[@id='folder_submit']")).click();
			       Thread.sleep(2000);
			       driver.findElement(By.xpath("//button[@id='jqi_state0_buttonOk']")).click();
//			       Alert alert = driver.switchTo().alert();
			       System.out.println("ok button clicked");
//			       alert.accept();
			       
			       driver.quit();
	}

		


	}



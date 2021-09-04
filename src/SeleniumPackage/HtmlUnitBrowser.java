package SeleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class HtmlUnitBrowser {
	
	//htmlunitdriver is not available in Selenium 3.x version.
	//htmlUnitDriver -- to use this concept, we have to download htmlunitdriver JAR file

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Stuff\\Selenium jars\\chromedriver_win32\\chromedriver.exe");
		
		//WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
		
		
		//Advantages of HtmlUnitDriver: 
		//1. testing is happening behind the scene -  no browser is launched.
		//2. Very Fast -- execution of test cases -- very fast -- performance of the script.
		
		//3. not suitable for Action Class -- user actions like -- mouseMovement , double click, drag and drop .
		//  also called "Ghost Driver" r "Headless Browser":
			//-- HtmlUnitDriver == Java
			//-- PhantomJS -- JavaScript
		
		WebDriver driver = new HtmlUnitDriver();  //headless driver used to write the code without opening a browser.
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		//Dynamic Waits		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //it says to selenium atleast to wait for 40 seconds until the whole page gets loaded.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //it is applicable for all the elements that are available on the page to get loaded.

		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		System.out.println("before login title is ==  " + driver.getTitle());
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='login1']")).sendKeys("testcaseselenium");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test@2021");
		driver.findElement(By.xpath("//input[@name= 'proceed']")).click();
		
		Thread.sleep(2000);
		
		System.out.println("after login title is ==  " + driver.getTitle());

	}

}

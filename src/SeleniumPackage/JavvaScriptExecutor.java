package SeleniumPackage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class JavvaScriptExecutor {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Stuff\\Selenium jars\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
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
//		driver.findElement(By.xpath("//input[@name= 'proceed']")).click();
		
		Thread.sleep(2000);
		
		WebElement loginbtn = driver.findElement(By.xpath("//input[@name= 'proceed']"));
		
		//flash method is static so no need to create the object simply call it.
		flash(loginbtn, driver); //highlight the element
		 System.out.println("flashed");
	
		Thread.sleep(2000);
		
		drawBorder(loginbtn, driver); //draw a border
		System.out.println("bordered");
		
		//take screenshot

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(src, new File("\\D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\element.png"));
			
		//generate alert
//		generateAlert(driver, "There is an issue with Login Button");
		
		//click  any element by using JS Executor
//		specificElement(loginbtn , driver);
		
		// to refresh the page using JS Executor
		//driver.navigate().refresh(); this is normal selenium
		refreshBrowser(driver);
		
		//gettitle of webpage
		System.out.println(getTitleByJS(driver));
		
		//get InnerText of webpage 
		System.out.println(getPageInnerText(driver));
		
		//scroll Page down - complete to the bottom of the page
		//scrollDown(driver);
		
		//scroll into view - scrolls upto particular given element
		WebElement scrollpage = driver.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]"));
		scrollIntoView(scrollpage, driver);
		
		Thread.sleep(2000);
		
//		driver.quit();
		
		

	}
	
	//to highlight specific thing we use JavaScriptExecutor
	
	
	//method-flash
	//javascriptExecutor - class - to handle javascript calls or code. - import from selenium . and we have to cast our driver into  JavascriptExecutor
	//after casting we have a method executeScript used to execute javascript code. 
	//changeColor - method
	
	public static void flash(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = element.getCssValue("background");
		for (int i = 0; i < 50; i++) {  //to blink the element 10 times
			changeColor("rgb(0,0,255)",element,driver); //we want the color is given , and which element like login btn is passed, and driver element
			changeColor(bgcolor, element, driver); // again calling this to execute its default color.
		}
	}
	
	
	
	public static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.background = ' "+color+"'",element); // we pass arguments[0] becoz only single element we are passing
		
		try {
			Thread.sleep(20);
		}catch (InterruptedException e) {
		}
	}

	//Draw a Border
	
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border = '3px solid red' ", element);
	}
	
	//generate Alert
	
	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("alert('"+ message +"')");
	}
	
	//click on specific element, link or button etc..,
	
	public static void specificElement(WebElement element, WebDriver driver ) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();",element);
	}
	
	//to Refresh 
	public static void refreshBrowser(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("history.go(0)"); // 0 means it will go to browser first history.
	}
	
	//pageTitle
	public static String getTitleByJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
//		return js.executeScript("return document.title; ").toString();     (or)
		String title = js.executeScript("return document.title; ").toString();
		return title;
		
	}
	
	//to get text present in the page
	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		return js.executeScript("return document.documentElement.innerText;").toString();
		
	}
	
	//scroll page
	public static void scrollDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true)", element); // scrollIntoView is an method which scrolls the page upto given specified element.
	}
	
	
}

package SeleniumPackage;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverBasics {

	
	
	public static void main(String[] args) throws InterruptedException {
         //FireFox(Mozilla FireFox)
		//System.setProperty("webdriver.gecko.driver", "D:\\Selenium Stuff\\Selenium jars\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//driver.get("https://www.mozilla-firefox.com");
		
		
		//chrome browser
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Stuff\\Selenium jars\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
		
		driver.get("https://www.google.co.in"); // enter url
		
		String title = driver.getTitle();  // get the Title of the page
		
		System.out.println(title);
		
		// Comparing Title of the Web Page is right or wrong
		
		//These are Validation Points (Actual thing vs Expected Thing)
		
		if(title.equals("Google")) {
			System.out.println("Correct title");
		}else {
			System.out.println("in-correct title");
		}
		
		System.out.println(driver.getCurrentUrl());
//		System.out.println(driver.getPageSource()); // to get page source of the webpage
		
		Thread.sleep(5000); // static wait -- it waits for 5 seconds and then closes.
		
		driver.quit();

		
	}

}

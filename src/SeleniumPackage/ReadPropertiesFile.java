package SeleniumPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropertiesFile {
	
	static WebDriver driver;  // we are making it global to use anywhere.

	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		//to read the properties file we have to create an object.
		//In Java, we have a class named Properties 

		
		Properties prop = new Properties();
		
		//in this FileInputStream - we have to mention where the file is exactly located.
		
		FileInputStream ip = new FileInputStream("D:\\Selenium Stuff\\Selenium Sessions\\src\\SeleniumPackage\\config.properties");
		
		// now we have to load this file by using properties object reference(prop) & by using a method name 'load'.
		
		prop.load(ip); 
		
		System.out.println(prop.getProperty("name")); 
		
		System.out.println(prop.getProperty("age"));
		
		
		String url = prop.getProperty("URL");// here prop.getProperty will read the given property and stores in the given URL variable
		
		System.out.println(url);
		
		String browserName = prop.getProperty("browser");
		
		System.out.println(browserName);
		
		if(browserName.equals("chrome")) {
		
		
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium Stuff\\Selenium jars\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
	
		}else if(browserName.equals("FF")) {
			
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium Stuff\\Selenium jars\\chromedriver_win32\\geckodriver.exe");
			driver = new FirefoxDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
	
			
		}
		
		
		driver.get(url); // visibles the url on the search bar
		
		driver.findElement(By.xpath(prop.getProperty("fullname_xpath"))).sendKeys(prop.getProperty("fullname"));
		driver.findElement(By.xpath(prop.getProperty("mailid_xpath"))).sendKeys(prop.getProperty("mailid"));
		//for dropdown
		driver.findElement(By.xpath(prop.getProperty("city_xpath"))).sendKeys(prop.getProperty("city")); 
	}

}

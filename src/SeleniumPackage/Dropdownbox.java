package SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdownbox {

	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\\\Selenium Stuff\\\\Selenium jars\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://register.rediff.com/register/register.php?FormName=user_details"); // url
		
		//Selenium select class checks if the HTML web element we are using it with is a <select> tag or not. If not, Selenium WebDriver throws UnexpectedTagNameException.
		Thread.sleep(2000);
		
		
		Select select = new Select(driver.findElement(By.id("country")));

		select.selectByVisibleText("Italy");
		Thread.sleep(2000);
		
		Select select1 = new Select(driver.findElement(By.xpath("//tbody/tr[22]/td[3]/select[1]")));

		select1.selectByVisibleText("15");
		Thread.sleep(2000);
		
		Select select2 = new Select(driver.findElement(By.xpath("//tbody/tr[22]/td[3]/select[2]")));

		select2.selectByVisibleText("JUL");
		Thread.sleep(2000);
		
		Select select3 = new Select(driver.findElement(By.xpath("//tbody/tr[22]/td[3]/select[3]")));

		select3.selectByVisibleText("1995");
		Thread.sleep(3000);
		
		driver.quit();
		

	}

}

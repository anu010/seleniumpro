package SeleniumPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalendarSelect {

	

	public static void main(String[] args) {
		
		
		
		
		//Handle Calendar using selenium
			//with the help of dynamic webtable xpath concept
			//iterate the entire calendar grid by row and column
			// match the value and select the day
			//Handle NOSuchElementException in case of 31st day
		
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Stuff\\Selenium jars\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
			
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		//Dynamic Waits		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //it says to selenium atleast to wait for 40 seconds until the whole page gets loaded.
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //it is applicable for all the elements that are available on the page to get loaded.
	    
		driver.get("http://dotnetlearners.com/blogs/show-month-and-year-dropdown-in-jquery-datepicker");
	    
		
		driver.findElement(By.id("txtdate")).click();
		
		
		String date = "15-Sep-2021";
		String dateArr[] = date.split("-"); 
		String day = dateArr[0];
		String month = dateArr[1];
		String year = dateArr[2];
		
		Select month1 = new Select( driver.findElement(By.xpath("//select[@data-handler='selectMonth']")));
		
		month1.selectByVisibleText("Sep");
		
		//tbody/tr[1]/td[1]
		
		//tbody/tr[2]/td[5]/a[1] //8
		
		//tbody/tr[3]/td[5] //15
		
		String beforeXpath = "//tbody/tr[";
		String afterXpath = "]/td[";
		
		final int totalWeekDays = 7; //make it 'final' becoz no one can change it
		
		
		
		//loop starts like -- 2-1 2-2 2-3 2-4 2-5 2-6 2-7 
		//3-1 3-2 3-3 3-4 3-5 3-6 3-7
		
		boolean flag = false;
		String days = null;
		String colNum = null;
		for(int rowNum=1; rowNum<=7; rowNum++) {
			for(int colNum1 = 1; colNum1<=totalWeekDays; colNum1++) {
				
				try {
				
				 days =	driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum1+"]")).getText();
				}catch (NoSuchElementException e) {
					System.out.println("enter a correct date value");
					flag=false;
					break;
				}
				
				System.out.println(days);
					if(days.equals(day)) {
						
						driver.findElement(By.xpath(beforeXpath+rowNum+afterXpath+colNum1+"]")).click();
						flag = true;
						break;
					}
			
						
			
			
			}
			
			if(flag) {
				break;
				}
			
		}

		
//		driver.quit();
}
}


package SeleniumPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium Stuff\\Selenium jars\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(); //launch chrome // here WebDriver is the Interface and ChromeDriver is a Class.
			
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://jqueryui.com/droppable/");
		
//		driver.switchTo().frame(0); // if single frame available pass zero(0). If there are multiple frames we have to test all frames by passing 1,2,3 etc.,
		
//		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
  
//		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		
//		Actions action = new Actions(driver);
		
//		action.dragAndDrop(drag, drop).perform();
		

		//another type to drop the element ===
		
//		action.clickAndHold(driver.findElement(By.xpath("//div[@id='draggable']"))).moveToElement(driver.findElement(By.xpath("//div[@id='droppable']"))).release(driver.findElement(By.xpath("//div[@id='droppable']"))).build().perform(); //when Actions class is there.. always use build and perform methods actually it performs the action & moves mouse to element.


        WebElement iFrame = driver.findElement(By.tagName("iframe"));
        System.out.println(iFrame.getSize());
        driver.switchTo().frame(iFrame);

        WebElement draggable = driver.findElement(By.id("draggable"));
        System.out.println(draggable.getLocation());
        new Actions(driver).dragAndDropBy(draggable, 157, 19).perform();
		
	}

}

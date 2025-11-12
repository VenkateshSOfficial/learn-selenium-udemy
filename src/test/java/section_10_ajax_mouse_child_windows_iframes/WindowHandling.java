package section_10_ajax_mouse_child_windows_iframes;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class WindowHandling {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser(){
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	@Test
	public  void execute(){
		driver.findElement(By.cssSelector(".blinkingText")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		String firstPage = iterator.next();
		String secondPage = iterator.next();
		driver.switchTo().window(secondPage);
		String username = driver.findElement(By.cssSelector(".im-para.red a")).getText();
		System.out.println(username);
		String[] splitName = username.split("@");
		String finalUserName=splitName[1].trim();
		System.out.println(finalUserName);
		driver.switchTo().window(firstPage);
		driver.findElement(By.cssSelector("#username")).sendKeys(finalUserName);
		while(iterator.hasNext()){
			System.out.println("hello");
		}
	}
	@AfterTest
	public void tearDown(){
		try{
			Thread.sleep(3000);
			driver.quit();
		}catch(Exception ae){
			ae.printStackTrace();
		}
		finally {
			driver.quit();
		}
	}
}

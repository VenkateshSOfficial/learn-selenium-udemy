package section_10_ajax_mouse_child_windows_iframes;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;


public class LearnActions {
	WebDriver driver;
	Actions action;

	public void mouseHover(WebElement ele){
		action=new Actions(driver);
		action.moveToElement(ele).build().perform();
	}
	public void enterCaps(WebElement ele,String val){
		action=new Actions(driver);
		action.moveToElement(ele).
				click().
				keyDown(Keys.SHIFT).
				sendKeys(val).
				build().
				perform();
	}
	public void rightClick(WebElement ele){
		action=new Actions(driver);
		action.moveToElement(ele).contextClick().build().perform();
	}
	@BeforeTest
	public void launchBrowser(){
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	@Test
	public void execute() throws InterruptedException {
		WebElement loginOption = driver.findElement(By.cssSelector("#nav-link-accountList"));
		mouseHover(loginOption);
		WebElement searchBox = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
		enterCaps(searchBox,"hello world");
		rightClick(loginOption);
	}
	@AfterTest
	public void tearDown(){
		try{
			Thread.sleep(5000);
			driver.quit();
		}catch(Exception ae){
			ae.printStackTrace();
		}
		finally {
			driver.quit();
		}
	}
}

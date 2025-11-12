package section_10_ajax_mouse_child_windows_iframes;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class LearnFrames {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser(){
		driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	@Test
	public void execute(){
		WebElement frame = driver.findElement(By.cssSelector(".demo-frame"));
		driver.switchTo().frame(frame);
		String text = driver.findElement(By.cssSelector("#draggable p")).getText();
		System.out.println(text);
		driver.switchTo().defaultContent();
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

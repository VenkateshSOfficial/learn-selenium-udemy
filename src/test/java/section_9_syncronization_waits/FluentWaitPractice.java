package section_9_syncronization_waits;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;


public class FluentWaitPractice {
	WebDriver driver;
	public void fluentWait(){
	Wait <WebDriver>wait=new FluentWait<WebDriver>(driver).
			withTimeout(Duration.ofSeconds(30)).
			pollingEvery(Duration.ofSeconds(3)).
			ignoring(NoSuchElementException.class);
	}

	@BeforeTest
	public void launchBrowser(){
		driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	@Test
	public void execute() throws InterruptedException {
		driver.findElement(By.cssSelector("#start button")).click();

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

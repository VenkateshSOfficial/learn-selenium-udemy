package section_7_automate_techniques;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class HandlingCalenders {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser(){
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	@Test
	public void execute(){
		driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-active")).click();
	}
	@AfterTest
	public void tearDown(){
		try{
			Thread.sleep(2000);
			driver.quit();
		}catch(Exception ae){
			ae.printStackTrace();
		}
		finally {
			driver.quit();
		}
	}
}

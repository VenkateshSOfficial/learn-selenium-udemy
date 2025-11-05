package section_7_automate_techniques;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class LearnAlerts {
	WebDriver driver;

	public Alert alert(){
		return driver.switchTo().alert();
	}
	@BeforeTest
	public void launchBrowser(){
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	@Test
	public void execute() throws InterruptedException {
		driver.findElement(By.cssSelector("#alertbtn")).click();
		System.out.println("The alert text is : " + alert().getText());
		Thread.sleep(3000);
		alert().accept();
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

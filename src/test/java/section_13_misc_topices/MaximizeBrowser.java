package section_13_misc_topices;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;


public class MaximizeBrowser {
	WebDriver driver;
	ChromeOptions options;
	@BeforeTest
	public void launchBrowser(){
		options=new ChromeOptions();
		options.addArguments("start-maximized");
		driver=new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	@Test
	public void execute(){
		System.out.println(driver.getTitle());
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

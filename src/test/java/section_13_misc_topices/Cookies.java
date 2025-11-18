package section_13_misc_topices;

import java.time.Duration;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;


public class Cookies {
	WebDriver driver;
	ChromeOptions options;
	Cookie cookie=new Cookie("browserType","hello");
	@BeforeTest
	public void launchBrowser(){
		options=new ChromeOptions();
		options.addArguments("start-maximized");
		driver=new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("asdf");
		driver.manage().addCookie(cookie);
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

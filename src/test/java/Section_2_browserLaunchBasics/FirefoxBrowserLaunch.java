package Section_2_browserLaunchBasics;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class FirefoxBrowserLaunch {
	WebDriver driver;
	@Test
	public void launchFirefoxBrowser(){
		driver=new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		System.out.println("The obtained title is : " + driver.getTitle());
	}
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}

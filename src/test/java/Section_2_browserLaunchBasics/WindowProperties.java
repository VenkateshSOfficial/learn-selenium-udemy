package Section_2_browserLaunchBasics;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class WindowProperties {
	WebDriver driver;
	ChromeOptions options;
	@Test
	public void launchChromeBrowser(){
		options=new ChromeOptions();
		options.addArguments("--start-maximized");
		driver=new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println(driver.getTitle());
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		// to run the tests in maximized mode
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		System.out.println("The obtained title is : " + driver.getTitle());
	}
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
}

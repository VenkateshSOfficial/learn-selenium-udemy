package section_16_framework.testNG;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class ParameterizedTestNG {
	WebDriver driver;
	@Parameters({"browser","url"})
	@BeforeTest
	public void launchBrowser(String browser,String url){
		switch (browser){
			case "chrome":
				driver=new ChromeDriver();
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
				break;
			case "firefox":
				driver=new FirefoxDriver();
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
				break;
			default:
				throw new IllegalArgumentException("unsupported browser type : " + browser);
		}
	}
	@Test
	public void execute(){
		System.out.println("The title is : " + driver.getTitle());
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

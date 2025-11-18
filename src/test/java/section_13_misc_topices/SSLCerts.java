package section_13_misc_topices;

import java.time.Duration;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;


public class SSLCerts {
	WebDriver driver;
	ChromeOptions options;
	Proxy proxy;
	@BeforeTest
	public void launchBrowser(){
		options=new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		proxy=new Proxy();
		proxy.setHttpProxy("ipaddress:4444");
		options.setCapability("proxy",proxy);
		driver=new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();
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

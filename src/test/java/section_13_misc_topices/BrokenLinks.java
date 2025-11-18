package section_13_misc_topices;

import java.io.IOException;
import java.net.*;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;


public class BrokenLinks {
	WebDriver driver;
	ChromeOptions options;
	@BeforeTest
	public void launchBrowser(){
		options=new ChromeOptions();
		options.addArguments("start-maximized");
		driver=new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	@Test
	public void execute() throws IOException {
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='gf-BIG']//table/tbody/tr/td/ul/li/a"));
		for(WebElement link:links){
			HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(link.getAttribute("href")).openConnection();
			httpURLConnection.setRequestMethod("HEAD");
			httpURLConnection.connect();
			int responseCode = httpURLConnection.getResponseCode();
			if(responseCode>400){
				System.out.println(link.getText() + " is broken link");
			}else{
				System.out.println(link.getText() + " is not broken");
			}
		}
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

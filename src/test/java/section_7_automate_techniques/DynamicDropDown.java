package section_7_automate_techniques;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class DynamicDropDown {
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
		/*driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("a[value='MAA']:nth-of-type(1)")).click();*/

		driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.cssSelector("#glsctl00_mainContent_ddl_originStation1_CTNR a[value='MAA']")).click();
		driver.findElement(By.cssSelector("#glsctl00_mainContent_ddl_destinationStation1_CTNR a[value='BLR']")).click();
	}
	@AfterTest
	public void tearDown(){
		try{
			Thread.sleep(3000);
			driver.quit();
		}catch(Exception ae){
			ae.printStackTrace();
		}
		finally {
			driver.quit();
		}
	}
}

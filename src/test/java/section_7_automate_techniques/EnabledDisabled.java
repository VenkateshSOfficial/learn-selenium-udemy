package section_7_automate_techniques;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class EnabledDisabled {
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
		List<WebElement> radioButtons = driver.findElements(By.cssSelector("#travelOptions input[type='radio']"));
		for(WebElement radioButton:radioButtons){
			if(radioButton.getText().equalsIgnoreCase("One Way")){
				radioButton.click();
			}
		}
		Assert.assertFalse(driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2")).isEnabled());
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

package section_7_automate_techniques;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class AutoSuggestiveDropDowns {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser(){
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	@Test
	public void execute() throws InterruptedException {
		driver.findElement(By.cssSelector("#autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> allPlaces = driver.findElements(By.cssSelector(".ui-menu-item a"));
		for(WebElement place :allPlaces){
			System.out.println(place.getText());
			if(place.getText().equalsIgnoreCase("india")){
				place.click();
				break;
			}
		}
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

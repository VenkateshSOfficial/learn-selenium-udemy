package section_7_automate_techniques;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class CheckboxesValidations {
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
		List<WebElement> allCheckboxes = driver.findElements(By.cssSelector("#discount-checkbox input[type='checkbox']"));
		System.out.println("Total checkboxes count : " + allCheckboxes.size());
		for(WebElement checkbox : allCheckboxes){
			String checkboxName=checkbox.getText();
			checkbox.click();
			Assert.assertTrue(checkbox.isSelected());
			Thread.sleep(2000);
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

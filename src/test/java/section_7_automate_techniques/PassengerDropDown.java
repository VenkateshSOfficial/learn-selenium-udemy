package section_7_automate_techniques;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class PassengerDropDown {
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
		WebElement passengerSelect = driver.findElement(By.cssSelector("#divpaxinfo"));
		passengerSelect.click();
		WebElement adultCountButton = driver.findElement(By.cssSelector("#hrefIncAdt"));
		for(int i=0;i<4;i++){
			Thread.sleep(1000);
			adultCountButton.click();
		}
		WebElement totalAdultCount = driver.findElement(By.xpath("//span[@id='hrefDecAdt']/following-sibling::span[1]"));
/*
		System.out.println("Total adults selected : " + totalAdultCount.getText());
*/
		System.out.println("Total adults selected : " +passengerSelect.getText());
	}
	@AfterTest
	public void tearDown(){
		try{
			driver.quit();
		}catch(Exception ae){
			ae.printStackTrace();
		}
		finally {
			driver.quit();
		}
	}
}

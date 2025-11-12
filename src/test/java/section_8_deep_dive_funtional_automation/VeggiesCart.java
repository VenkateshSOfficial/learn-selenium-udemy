package section_8_deep_dive_funtional_automation;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class VeggiesCart {
	WebDriver driver;

	String[] vegetables={"Tomato","Beans","Apple","Banana"};

	@BeforeTest
	public void launchBrowser(){
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	@Test
	public void execute() throws InterruptedException {
		List<String> requiredVeggies = Arrays.asList(vegetables);
		List<WebElement> allVeggies = driver.findElements(By.cssSelector(".product-name"));
		for(int i=0;i<allVeggies.size();i++){
			String[] fullName=allVeggies.get(i).getText().split(" -");
			String actualName=fullName[0].trim();
			System.out.println(actualName);
			if(requiredVeggies.contains(actualName)){
				driver.findElements(By.cssSelector(".product-action button")).get(i).click();
			}
		}
		driver.findElement(By.cssSelector(".cart-icon img")).click();
		Thread.sleep(2000);
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

package section_9_syncronization_waits;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class ExplicitWaitPractice {
	WebDriver driver;
	WebDriverWait wait;

	String[] vegetables={"Tomato","Beans","Apple","Banana"};


	public void explicitlyWait(String data,WebElement ele){
		wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		switch (data){
			case "visibilityOfElement":
				System.out.println("executing explicit");
				wait.until(ExpectedConditions.visibilityOf(ele));
		}
	}
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
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		WebElement promoInfo = driver.findElement(By.cssSelector(".promoInfo"));
		explicitlyWait("visibilityOfElement",promoInfo);
		System.out.println(promoInfo.getText());
		Assert.assertTrue(promoInfo.isDisplayed());
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

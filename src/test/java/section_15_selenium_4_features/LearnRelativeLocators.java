package section_15_selenium_4_features;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;


public class LearnRelativeLocators {
	WebDriver driver;
	ChromeOptions options;
	@BeforeTest
	public void launchBrowser(){
		options=new ChromeOptions();
		options.addArguments("--start-maximized");
		driver=new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/angularpractice/");
	}
	@Test
	public void test() throws InterruptedException {
		WebElement ele = driver.findElement(By.xpath("//div[@class='form-group']/input[@name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(ele)).getText());
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']"));
		System.out.println(driver.findElement(with(By.tagName("label")).below(dropDown)).getText());
		WebElement checkBoxMsg = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
		WebElement checkBox = driver.findElement(with(By.tagName("input")).toLeftOf(checkBoxMsg));
		checkBox.click();
		System.out.println(checkBox.isSelected());
		WebElement ele2 = driver.findElement(By.xpath("//label[@for='exampleFormControlRadio1']"));
		WebElement chk = driver.findElement(with(By.tagName("label")).toRightOf(ele2));
		Thread.sleep(3000);
		chk.click();
		System.out.println(chk.isSelected());
	}
	@AfterTest
	public void tearDown(){
		try{
			Thread.sleep(3000);
			driver.quit();
		}catch (Exception ae){
			ae.printStackTrace();
		}
		finally {
			driver.quit();
		}
	}
}

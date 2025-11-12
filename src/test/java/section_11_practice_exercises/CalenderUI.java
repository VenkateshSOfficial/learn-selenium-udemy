package section_11_practice_exercises;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class CalenderUI {
	WebDriver driver;

	@BeforeTest
	public void launchBrowser(){
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	@Test
	public void execute(){
		WebElement calenderIcon = driver.findElement(
				By.cssSelector(".react-date-picker__calendar-button.react-date-picker__button"));
		calenderIcon.click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label span")).click();
		String currentYear = driver.findElement(By.cssSelector(".react-calendar__navigation__label span")).getText();
		WebElement yearNextButton = driver.findElement(
				By.cssSelector(".react-calendar__navigation__arrow.react-calendar__navigation__next-button"));

		WebElement yearPreviousButton  = driver.findElement(
				By.cssSelector(".react-calendar__navigation__arrow.react-calendar__navigation__prev-button"));

		System.out.println(currentYear);
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

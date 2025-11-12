package section_11_practice_exercises;

import java.time.Duration;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;


public class ScopeWebDriver {
	WebDriver driver;
	Actions actions;
	@BeforeTest
	public void launchBrowser(){
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	@Test
	public void execute() throws InterruptedException {
		WebElement footerDriver = driver.findElement(By.cssSelector("#gf-BIG"));
		List<WebElement> taglinks = footerDriver.findElements(By.tagName("a"));
		System.out.println(taglinks.size());
		WebElement firstColumn = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		List<WebElement> firstColumnLinks = firstColumn.findElements(By.tagName("a"));
		System.out.println(firstColumnLinks.size());

		for(int i=1;i<firstColumnLinks.size();i++){
			String chord = Keys.chord(Keys.CONTROL, Keys.ENTER);
			firstColumnLinks.get(i).sendKeys(chord);
		}
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> iterator = windowHandles.iterator();
		while (iterator.hasNext()){
			Thread.sleep(3000);
			driver.switchTo().window(iterator.next());
			System.out.println("The title is : " + driver.getTitle());

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

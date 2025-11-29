package section_14_pagination_java_streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;


public class PaginationAndStreams {
	WebDriver driver;
	ChromeOptions options;
	@BeforeTest
	public void launchBrowser(){
		options=new ChromeOptions();
		options.addArguments("--start-maximized");
		driver=new ChromeDriver(options);
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	}
	@Test
	public void execute() throws InterruptedException {
		List<String> finalPrice;
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".table thead tr th:first-of-type")).click();
		Thread.sleep(3000);
		do{
			List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));
			finalPrice = items.stream().filter(item -> item.getText().equalsIgnoreCase("Dragon fruit")).
					                      map(price -> getVeggiePrice(price)).collect(Collectors.toList());
			finalPrice.forEach(System.out::println);
			if(finalPrice.size()<1){
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		}while (finalPrice.size()<1);
	}
	public String getVeggiePrice(WebElement price){
		return price.findElement(By.xpath("following-sibling::td[1]")).getText();
	}
	@AfterTest
	public void tearDown(){
		try{
			driver.quit();
		}catch (Exception ae){
			ae.printStackTrace();
		}
		finally {
			driver.quit();
		}
	}
}

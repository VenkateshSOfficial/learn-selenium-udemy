package section_12_practical_problems;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class HandleTableGrid {
	WebDriver driver;
	@BeforeTest
	public void launchBrowser(){
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	@Test
	public void execute() throws InterruptedException {
		List<WebElement> amounts = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
		int sum=0;
		for(WebElement amount:amounts){
			int val=Integer.parseInt(amount.getText());
			sum+=val;
		}
		/*for(int i=0;i<amounts.size();i++){
			System.out.println(amounts.get(i).getText());
			int val=Integer.parseInt(amounts.get(i).getText());
			sum+=val;
		}*/
		System.out.println("The total sum is : " + sum);
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

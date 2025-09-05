package section_5_locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class SiblingsTraverseXpath {
	WebDriver driver;
	@Test
	public void execute() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		// parent to child -> sibling to sibling
		String text=driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
		System.out.println(text);
		// child to parent traverse
		String text1=driver.findElement(By.xpath("//button[@class='btn btn-primary']/parent::div/parent::header/a[2]")).getText();
		System.out.println(text1);
		driver.quit();
	}
}

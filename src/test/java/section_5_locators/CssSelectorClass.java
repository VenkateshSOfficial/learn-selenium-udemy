package section_5_locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class CssSelectorClass {
	WebDriver driver;
	@Test
	public void execute() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		System.out.println("The obtained title is : " + driver.getTitle());
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		Thread.sleep(2000);
		driver.findElement(By.name("inputPassword")).sendKeys("password");
		Thread.sleep(2000);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(2000);
		String errorMsg = driver.findElement(By.cssSelector(".error")).getText();
		System.out.println("error msg is : " + errorMsg);
		driver.quit();
	}
}

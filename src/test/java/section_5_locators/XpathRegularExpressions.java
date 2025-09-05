package section_5_locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class XpathRegularExpressions {
	WebDriver driver;

	public String getTextData(String data){
		String[] a = data.split("'");
		String password=a[1].split("'")[0].trim();
		System.out.println("The password is : " + password);
		return password;

	}
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
		Thread.sleep(2000);
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("rahul");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("rahulacademy@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("john@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("1234567");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		Thread.sleep(3000);
		String infoMsg = driver.findElement(By.cssSelector(".infoMsg")).getText();
		System.out.println(infoMsg);
		String pwd = getTextData(infoMsg);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(@class,'login')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[placeholder*='User']")).sendKeys("rahul");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@placeholder,'Pass')]")).sendKeys(pwd);
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".signInBtn")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='Log Out']")).click();
		Thread.sleep(3000);
		driver.quit();
	}
}

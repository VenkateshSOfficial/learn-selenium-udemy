package section_7_automate_techniques;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;


public class HandlingStaticDropDown {
	WebDriver driver;
	Select select;

	public String selectDropDownByIndex(WebElement ele,int index){
		select=new Select(ele);
		select.selectByIndex(index);
		return select.getFirstSelectedOption().getText();
	}
	public String selectDropDownByText(WebElement ele,String text){
		select=new Select(ele);
		select.selectByVisibleText(text);
		return select.getFirstSelectedOption().getText();
	}
	public String selectDropDownByValue(WebElement ele,String val){
		select=new Select(ele);
		select.selectByValue(val);
		return select.getFirstSelectedOption().getText();
	}
	@BeforeTest
	public void launchBrowser(){
		driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
	}
	@Test
	public void dropDown(){
		WebElement dropDown = driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));
		String selectedDropDownByIndex = selectDropDownByIndex(dropDown, 3);
		String selectedDropDownByText = selectDropDownByText(dropDown, "AED");
		String selectedDropDownByValue = selectDropDownByValue(dropDown, "INR");
		System.out.println("The selected dropdown by index  is : " + selectedDropDownByIndex);
		System.out.println("The selected dropdown by text is : " + selectedDropDownByText);
		System.out.println("The selected dropdown by value is : " + selectedDropDownByValue);
	}
	@AfterTest
	public void tearDown(){
		try{
			driver.quit();
		}catch(Exception ae){
			ae.printStackTrace();
		}
		finally {
			driver.quit();
		}
	}
}

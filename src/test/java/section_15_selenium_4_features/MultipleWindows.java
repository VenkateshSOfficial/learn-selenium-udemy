package section_15_selenium_4_features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class MultipleWindows {
    WebDriver driver;
    ChromeOptions options;
    @BeforeTest
    public void launchBrowser(){
        options=new ChromeOptions();
        options.addArguments("--start-maximized");
        driver=new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/angularpractice/");
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

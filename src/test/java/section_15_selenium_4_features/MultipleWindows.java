package section_15_selenium_4_features;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

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
    @Test
    public void execute(){
//        driver.switchTo().newWindow(WindowType.TAB);
        driver.switchTo().newWindow(WindowType.WINDOW);

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();
        String parent = iterator.next();
        String child = iterator.next();
        driver.switchTo().window(child);
        driver.get("https://www.youtube.com/");
        driver.switchTo().window(parent);

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

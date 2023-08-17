package SeleniumTestNGPackage;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class WindowHandler {
	
	WebDriver driver;
	String expectedURL;
	String actualURL;
	String parentWindowHandle;
	Set<String> childWindowHandle;
	
	@BeforeTest
	public void setUp() throws InterruptedException {
		
		//Launch chrome and open URL
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		
		Thread.sleep(2000);
				
	}
	

	@Test
	public void testCase1_openParentWindow() throws InterruptedException {
		
		//Click on alert windows tab and verify parent window handle
		expectedURL = "https://demoqa.com/alertsWindows";
		
		//scroll down on page till the tab is displayed
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		
		driver.findElement(By.xpath("//div[@class='card-body']/h5[contains(.,'Alerts, Frame & Windows')]")).click();
		//actualURL = driver.getCurrentUrl();
		//Assert.assertEquals(actualURL, expectedURL);
		
		parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window Handle = "+ parentWindowHandle);
		
		Thread.sleep(2000);
		
	}
	
	@Test
	public void testCase2_openChildWindow() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//div[@class='header-text'][contains(.,'Alerts, Frame & Windows')]")).click();
		driver.findElement(By.xpath("//li[@id='item-0']/span[contains(.,'Browser Windows')]")).click();
		
		//Click new window button THRICE and open new child window and verify child window handle
		
		for (int i=0; i<3; i++) {
		driver.findElement(By.xpath("//button[@id='windowButton']")).click();
		Thread.sleep(2000);
		}
		
		childWindowHandle = driver.getWindowHandles();
		System.out.println("Child window Handle = "+ childWindowHandle);
		
				
	}
	
	
	@AfterTest
	public void testCase_switchToChildWindow() throws InterruptedException {
		
		//Switch to child window handle and close one by one
		for (String winHandle : driver.getWindowHandles()) {
        driver.switchTo().window(winHandle);
        driver.close();
    }
		
				
	}
	
}


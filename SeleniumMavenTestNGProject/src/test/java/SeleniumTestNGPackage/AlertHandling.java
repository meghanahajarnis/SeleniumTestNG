package SeleniumTestNGPackage;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class AlertHandling {
	
	WebDriver driver;
	
	@BeforeTest
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");		
				
	}
	
	@Test
	public void testCase1_alert() {
		
		driver.findElement(By.xpath("//input[@title='Sign in']")).click();
		
		Alert alert=driver.switchTo().alert();
		
		String alertText = alert.getText();
		
		System.out.println(alertText);
		
		alert.accept();
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

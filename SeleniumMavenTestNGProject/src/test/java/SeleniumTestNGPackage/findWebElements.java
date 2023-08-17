package SeleniumTestNGPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;



@Test
public class findWebElements {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get("http://www.google.com");	
		
	}
	
	public void test1() {
		
		//find number of webelement = links
		List<WebElement> link = driver.findElements(By.tagName("a"));
		System.out.println("No of links on page = " + link.size());
				
		//print all links names
		for (WebElement l : link) {
			System.out.println(l.getText());
		}
		
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

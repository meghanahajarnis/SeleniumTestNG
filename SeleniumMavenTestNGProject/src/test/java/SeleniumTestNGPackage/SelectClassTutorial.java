package SeleniumTestNGPackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class SelectClassTutorial {
	
	WebDriver driver;

	@BeforeTest
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
	}
	
	
	@Test
	public void test1_selectCategory() throws InterruptedException {
		
		//find weebelement dropdown
		WebElement searchIn = driver.findElement(By.xpath("//select[@title='Search in']"));		
		Select category = new Select(searchIn);
		List<WebElement> options = category.getOptions();
					
		//find size of dopdown list = no of options
		System.out.println("Total number of options in dropdown list are = "+options.size());
		
		//print all options in dropdown list
		for (WebElement e:options) {
			
			System.out.println(e.getText());
		}
		
		//select 1 option by value
		category.selectByValue("search-alias=beauty");
		Thread.sleep(2000);
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}

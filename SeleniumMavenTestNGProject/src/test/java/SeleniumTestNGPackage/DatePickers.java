package SeleniumTestNGPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class DatePickers {
	
	WebDriver driver;
	String expectedURL, actualURL;
	
	@BeforeTest
	public void setUP() throws InterruptedException{
		
		//lauch chrome browser
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.expedia.co.in/");
		Thread.sleep(2000);
	
	}
	
	
	
	@Test	
	public void test_case1_fromDate() throws InterruptedException{
		
				
		driver.findElement(By.xpath("//button[@id='date_form_field-btn']")).click();
		Thread.sleep(2000);
		
		String monthyear = driver.findElement(By.xpath("//div[@class='uitk-layout-flex uitk-layout-flex-justify-content-space-between uitk-date-picker-menu-pagination-container']")).getText();
		System.out.println(monthyear);
		
		if (monthyear == "August 2023") {
			System.out.println("PASS");
		}else {
			System.out.println("FAIL");
		}

		
	}	
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	

}

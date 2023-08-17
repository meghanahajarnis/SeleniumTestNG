package SeleniumTestNGPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


public class LaunchBrowser {
	
	WebDriver driver;
	String ExpectedURL, expectedText;
	String ActualURL, actualText;
	
	
	@BeforeTest
	public void setUP(){
		
		//lauch chrome browser
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		//maximize browser window
		driver.manage().window().maximize();
		//open the url in browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//wt for 5 sec to page load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)) ;
		//wt till submit button is visible on page
		By button = By.xpath("//button[@type='submit']");
		wait.until(ExpectedConditions.visibilityOfElementLocated(button));
		
	
	}
	
	
	@Test	
	public void test_case1_verify_title() {
				
		//verify page title
		String ActualTitle = driver.getTitle();
		String ExpectedTitle = "OrangeHRM";
		Assert.assertEquals(ActualTitle, ExpectedTitle);
					
				
	}
	
	
	@Test	
	public void test_case2_verify_login() throws InterruptedException{
		
				
		ExpectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
				
		//login to the page
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//verify url after login
		ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpectedURL);
		
		//wt for 5 sec
		Thread.sleep(5000);
		
	}	
	
	@Test
	public void test_case3_verify_admin() throws InterruptedException {
		
		ExpectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers";
		
		//Click on Admin link from LHS tab
		driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][contains(.,'Admin')]")).click();
		//wt for 5 sec
		Thread.sleep(5000);
		
		//verify admin url
		ActualURL = driver.getCurrentUrl();
		Assert.assertEquals(ActualURL, ExpectedURL);
		Thread.sleep(5000);
		
	}
	
	@Test
	public void test_case4_verify_search_user() throws InterruptedException {
		
				
		//enter username
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")).sendKeys("Admin");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		
		expectedText = "Admin";
		//Verfiy Admin in search
		actualText = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div")).getText();
		Assert.assertEquals(actualText, expectedText);
		Thread.sleep(5000);
		
	}
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
		
	}

}

package SeleniumTestNGPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class FileUploadWindowScreenshot {

WebDriver driver;
	
	@BeforeTest
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://html.com/input-type-file/");		
				
	}
	
	@Test
	public void fileUploadWithSendKeys() {
		
		driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("C://Meghana//PrintJava.txt");
		
	}
	
	@Test
	public void screenShotFullPage() throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target=new File(".//screenshots//screenShotFullPage.png");
		
		FileUtils.copyFile(source, target);
		
	}
	
	@Test
	public void screenShotsection() throws IOException {
		
		WebElement section = driver.findElement(By.xpath("//input[@id='fileupload']"));
				
		File source = section.getScreenshotAs(OutputType.FILE);
		File target=new File(".//screenshots//screenShotsection.png");
		
		FileUtils.copyFile(source, target);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
}

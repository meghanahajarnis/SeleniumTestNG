
package SeleniumTestNGPackage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUpload2WindowScreenshot {
	
WebDriver driver;
	
	@BeforeTest
	public void SetUp() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");		
		Thread.sleep(2000);
		
		//login to the page
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(2000);
	}
		
	
	@Test (priority=1)
	public void test_case_MyInfo() throws InterruptedException, AWTException {
		
		
		//MyInfo
		driver.findElement(By.xpath("//span[normalize-space()='My Info']")).click();
			
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='oxd-file-button']")).click();
		Thread.sleep(2000);
		
		
		Robot rb = new Robot();
		rb.delay(2000);
		
		//Copy file path
		StringSelection ss = new StringSelection("C:\\Meghana\\PrintJava.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		//Paste file 
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.delay(2000);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		
		//Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	
		Thread.sleep(2000);
		String expectedText = "PrintJava.txt";
		String actualText = driver.findElement(By.xpath("//div[@class='oxd-file-input-div']")).getText();
		Assert.assertEquals(actualText, expectedText);
		
		
	}
	
		
	@Test (priority=2)
	public void screenShotFullPage() throws IOException {
		
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target=new File(".//screenshots//screenShotfileUploadWithRobotClass.png");
		
		FileUtils.copyFile(source, target);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
		
	}

}

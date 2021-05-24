package allurereport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testcase {
	WebDriver driver;
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}
	@Test(priority=1)
	public void logopresence()
	{
		boolean pic=driver.findElement(By.xpath("//img[@alt='Facebook']")).isDisplayed();
		Assert.assertEquals(pic, true);
	}
	@Test(priority=2)
	public void login() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("shivushivraj36@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='passContainer']")).sendKeys("shreeanjani");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[normalize-space()='Log In']")).clear();
		driver.findElement(By.xpath("//a[@aria-label='Marketplace']//span[@class='l9j0dhe7']//*[local-name()='svg']")).click();
		String title=driver.getTitle();
		Assert.assertEquals(title, "https://www.facebook.com/marketplace/?ref=app_tab");
	}	
	
	@Test(priority=3)
	public void register()
	{
		throw new SkipException("skipping this test");
	}
	
	@AfterClass
	public void quits()
	{
		driver.quit();
	}


}

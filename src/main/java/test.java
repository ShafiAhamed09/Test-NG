import java.time.Duration;

import org.checkerframework.dataflow.qual.AssertMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class test {

	WebDriver driver;
	
	
	@Test
	public void firstTest() throws InterruptedException {

		System.out.println("testMethod1");
		
		Thread.sleep(3000);
	}
	@Test
	public void secondTest() throws InterruptedException
	{
		System.out.println("Second test");

		WebElement searchField=driver.findElement(By.name("q"));
		searchField.sendKeys("Facebbook");
		Thread.sleep(2000);


	}

	@BeforeTest
	public void beforeTest()
	{
		System.out.println("before test");
		
	}
	
	@Parameters("URL")
	@BeforeMethod
	public void beforeTestMethod(String URL)
	{

		System.out.println("Beforemethod");
		driver.get(URL);

	}
	@Parameters("browser")
	@BeforeSuite
	public void beforesuite(String browser)
	{
		System.out.println(browser);

		switch(browser.toLowerCase())
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Invalid browser: " + browser);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


	}
	@BeforeClass
	public void beforeclass()
	{
		System.out.println("Before Class");

	}

	@org.testng.annotations.AfterClass
	public void AfterClass()
	{
		System.out.println("After Class");

	}

	@org.testng.annotations.AfterMethod
	public void AfterMethod()
	{
		System.out.println("AfterMethod");
		
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("afterSuite");
		driver.quit();
	}
	@AfterTest
	public void aftertest()
	{
		System.out.println("after Test");
	}





}

import java.time.Duration;

import org.checkerframework.dataflow.qual.AssertMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Test(singleThreaded = true)
public class test {

	 static WebDriver driver;

	@Test
	public void firstTest() throws InterruptedException {

		System.out.println("testMethod1");

		Thread.sleep(3000);
	}

	@Test(groups = { "smoke" })
	public void secondTest() throws InterruptedException {
		System.out.println("Second test");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));

		searchField.sendKeys("Facebook", Keys.ENTER);
		Thread.sleep(2000);
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");

	}

	@Parameters("URL")
	@BeforeMethod
	public void beforeTestMethod(String URL) {

		System.out.println("Beforemethod");
		driver.get(URL);

	}

	@Parameters("browser")
	@BeforeClass
	public void beforesuite(@Optional("edge") String browser) {
		System.out.println(browser);

		switch (browser.toLowerCase()) {
		case "chrome":
			
			driver = new ChromeDriver();
			break;
		case "edge":
			
			driver = new EdgeDriver();
			break;
		default:
			throw new IllegalArgumentException("Invalid browser: " + browser);
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	 @BeforeSuite
	public void beforeclass() {
		System.out.println("Before Class");

	}

	@org.testng.annotations.AfterClass
	public void AfterClass() {
		System.out.println("After Class");

	}

	@org.testng.annotations.AfterMethod
	public void AfterMethod() {
		System.out.println("AfterMethod");

	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite");
		driver.quit();
	}

	@AfterTest
	public void aftertest() {
		System.out.println("after Test");
	}

}

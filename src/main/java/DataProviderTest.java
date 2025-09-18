import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import org.testng.annotations.DataProvider;

public class DataProviderTest {
	WebDriver driver;
	String browser="chrome";
	
	@Test(dataProvider ="loginTestData")
	public void loginPage(String userName,String password) throws IOException
	{
		if(browser.equals("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		}
		else if (browser.equalsIgnoreCase("edge"))
		{
			EdgeOptions eopt = new EdgeOptions();
			eopt.addArguments("--inprivate");
			driver = new EdgeDriver(eopt);
		}
		else
		{
			System.out.println("driver is not initailized");
		}
		
		driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        WebElement user = driver.findElement(By.xpath("//input[@placeholder='Username']"));
        user.sendKeys(userName);
        WebElement pass = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        pass.sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        
        try {
            WebElement Title = driver.findElement(By.xpath("//span[text()='Products']"));
            String test = Title.getText();
            Assert.assertEquals(test, "Products");
            System.out.println("✅ Login Passed for: " + userName);
        } catch (Exception e) {
            System.out.println("❌ Login Failed for: " + userName);
            screenShot("LoginFailed_" + userName);
        } finally {
            // Always take a screenshot, pass or fail
            screenShot("LoginAttempt_" + userName);
        }
	}
	
	 @DataProvider(name = "loginTestData")
	    public Object[][] loginData() {
	        return new Object[][]{
	                {"standard_user", "secret_sauce"},
	                {"ssa", "secret_sauce"}
	        };
	 }
	 
	 public void screenShot(String fileName) throws IOException
	 {
		 TakesScreenshot ts = (TakesScreenshot) driver;
		 File src= ts.getScreenshotAs(OutputType.FILE);
		 String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
		 File dest = new File("./screenshot/"+fileName+"_"+timeStamp+".png");
		 FileUtils.copyFile(src, dest);
		 System.out.println("Screenshot saved " +dest.getAbsolutePath());
		 
	 }
	 
	 @AfterMethod()
	 public void tearDown(){
		 if(driver!=null)
		 {
			 driver.quit();
		 }
		 
	 }
	
	

}

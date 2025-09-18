package ScreenShot;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	
	public static WebDriver driver;
	@BeforeTest()
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@AfterTest()
	public void TearDown()
	{
		if(driver!=null)
		{
			driver.quit();
		}
		
	}
	public void captureScreenShot( String fileName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(0));
		File dest = new File("./screenshot/"+fileName+"_"+timestamp+".png");
		FileUtils.copyFile(src, dest);
		System.out.println("Screenshot saved " +dest.getAbsolutePath());
		
		
	}

}

package ScreenShot;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({ListnerClass.class})
public class TestScreenshot extends BaseClass{
	
	
	@Test(testName="test1")
	public void test1() throws InterruptedException{
		driver.get("https://www.google.com/");
		driver.findElement(By.name("q")).sendKeys("Shafi");
		
		Thread.sleep(3000);
	}
	
	@Test(testName="test2")
	public void test2() throws InterruptedException{
		driver.get("https://www.google.com/");
		driver.findElement(By.name("qsba")).sendKeys("Shafi");
		
		Thread.sleep(3000);
	}
	

}

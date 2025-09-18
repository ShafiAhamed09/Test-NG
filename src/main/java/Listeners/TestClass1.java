package Listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({ClassListeners.class})
public class TestClass1 {

	 @Test
	  public void testMethod1() {
		  System.out.println("class1 >> testMethod1 >>" +Thread.currentThread().getId());
	  }
	  @Test
	  public void testMethod2() {
		  System.out.println("class1 >> testMethod2 >>" +Thread.currentThread().getId());
		  Assert.assertTrue(false);
	  }
	  
	  @Test(timeOut=1000)
	  public void testMethod3() throws InterruptedException {
		  Thread.sleep(3000);
		  System.out.println("class1 >> testMethod3 >>" +Thread.currentThread().getId());
	  }
	  @Test
	  public void testMethod4() {
		  System.out.println("class1 >> testMethod4 >>" +Thread.currentThread().getId());
		  Assert.assertTrue(true);
	  }
}

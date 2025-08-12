import org.testng.annotations.Test;

public class priorty {
	
	
	@Test(priority=1)
	public void Signup(){
		System.out.println("singingup");
	}
	
	@Test(priority=2)
	public void login(){
		System.out.println("loginup");
	}

	@Test(priority=3)
	public void Search(){
		System.out.println("Search");
	}
	
	@Test(priority=4)
	public void Scroll(){
		System.out.println("Scroll");
	}
	
	@Test(priority=5)
	public void Screnshot(){
		System.out.println("Screenshot");
	}
	
	
	@Test(priority=6)
	public void Logout(){
		System.out.println("Logout");
	}

}

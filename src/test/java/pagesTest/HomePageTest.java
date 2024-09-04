package pagesTest;


import org.testng.annotations.Test;
import baseUtil.BaseClass;

public class HomePageTest extends BaseClass {
	
	@Test ()
	public void enrollNowTest() throws InterruptedException {
		//homePage.clickLogo();
		homePage.enrollNow();
	}
	@Test
	public void clickLNameTest() {
  homePage.clickLName();
		
	}
	
}


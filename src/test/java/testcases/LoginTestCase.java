package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import pages.loginPage;

public class LoginTestCase extends baseTest{
	loginPage obj;
	@BeforeTest
	public void loginTest() throws InterruptedException {
		obj=new loginPage(driver);
		System.out.println("Opening the browser");
		//System.out.println(info);
		obj.login("Admin", "XwFwrZ28@Y");
		 String url=driver.getCurrentUrl();
			String curl= "https://sanjay29-trials76.orangehrmlive.com/client/#/dashboard";
			Assert.assertEquals(curl,url, "passed");
			System.out.println("the end.validated");
	  
		
	}
}
	
//The purpose of this file is to test login with wrong credentials, not in use anymore
//	@DataProvider
//	public Object[][] testData() {
//		return new Object[][] { 
//			    { "Testing with invalid data","aadmin", "admin123" },
//				{ "Testing with invalid data","123 ", " 123" },
//				{ "Testing with valid data","Admin", "XwFwrZ28@Y" } };
//	}
	
	



package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import pages.LocationPage;
import pages.dashboardPage;

public class locationTestCase extends baseTest {
	LocationPage locationObj;
	dashboardPage dashboardObj;
	@Test(dataProvider="testData")
  public void location(String officeName, String cityName, String phoneNum, String zipCode, String Country,String State) throws InterruptedException {
	    test.log(Status.INFO, "Created location with "+ cityName+" , "+Country+" ");
		dashboardObj=new dashboardPage(driver);
		dashboardObj.searchAndClick();
		locationObj=new LocationPage(driver);
		try {
		super.verifyCurrentUrl(prop.getProperty("LocationUrl"));
		locationObj.Details(officeName,cityName,phoneNum,zipCode,Country,State);
		test.log(Status.PASS , "New Office: "+ officeName+ "added successfully. ");
		}catch(Exception e) {
			test.log(Status.FAIL , "Adding new office FAILED with error : " + e);
            Assert.fail("New office not added");
		}
		
		try {
		locationObj.verifyLocationTest(officeName, cityName, phoneNum, zipCode, Country);
		test.log(Status.PASS , "Location successfully verified");
		}catch(Exception e) {
			test.log(Status.FAIL , "Location verification failed");
			Assert.fail("Location not found");
		}
		
	}	
	@DataProvider
	public Object[][] testData() {
		return new Object[][] { 
			    { "New York4227","New York","8464876121","100001","United States","New Jersey"}
				 };
	}
}

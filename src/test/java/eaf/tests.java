package eaf;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import base.ReportLog;
import pages.Page;

public class tests extends BaseTest {
	//WebDriver driver=new InternetExplorerDriver();
	@Test
	public void sampleTest() throws Exception {
		ReportLog.LOG("Starting test");
		Page page=new Page(getDriver());
		page.performuserLoginwithValidDetails();
		System.out.println("Sample test");
		getDriver().findElement(null);
	}
	
	@Test
	public void sampleTest1() {
		ReportLog.LOG("Starting test");
	System.out.println("Sample test");
	Assert.assertTrue(false, "statement is not true");
	}

}

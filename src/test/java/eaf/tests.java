package eaf;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import base.ReportLog;

public class tests extends BaseTest {
	
	@Test
	public void sampleTest() {
		ReportLog.LOG("Starting test");
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

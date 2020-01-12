package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ReportLog {
	
	static ExtentTest extentTest;
	static ExtentReports extentReport;
	
	public static void initializeReport() {
		extentReport = new ExtentReports(System.getProperty("user.dir")+"\\reports\\ExtentReportResults.html");
	}

	public static void startTest() {
		extentTest = extentReport.startTest("ExtentDemo");

	}

}

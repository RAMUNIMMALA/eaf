package base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportLog {
	
	static ExtentTest extentTest;
	static ExtentReports extentReport;
	
	public static void initializeReport() {
		extentReport = new ExtentReports(System.getProperty("user.dir")+"\\reports\\ExtentReportResults.html");
	}

	public static void startTest() {
		extentTest = extentReport.startTest("ExtentDemo");
	}
	
	public static void LOG(String message) {
		extentTest.log(LogStatus.INFO, message);
	}

	public static void PASS(String stepName) {
		extentTest.log(LogStatus.PASS, stepName);
	}
	
	public static void FAIL(String stepName) {
		extentTest.log(LogStatus.FAIL, stepName);
	}
	
	public static void WARNING(String stepName) {
		extentTest.log(LogStatus.WARNING, stepName);
	}
}

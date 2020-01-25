package base;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest implements IEAFbase {

	WebDriver driver = null;

	Properties prop = null;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	@BeforeSuite
	public void doBeforeSuite() {
		ReportLog.initializeReport();
	}

	@AfterSuite
	public void doAfterSuite() {
		ReportLog.extentReport.flush();
	}

	@BeforeClass
	public void doBeforeClass() {
	}

	@AfterClass
	public void doAfterClass() {
	}

	@BeforeMethod
	public void doBeforeMethod(Method method) {
		ReportLog.startTest(method.getName());
		initializeDriver();
	}

	@AfterMethod
	public void doAfterMethod(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) { // Test passed with out any interruption
			ReportLog.PASS("Test Passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {// test failed due to exception
			ReportLog.FAIL("Test Failed");
			ReportLog.FAIL(result.getThrowable().getLocalizedMessage());
		} else if (result.getStatus() == ITestResult.SKIP) { // test skipped for any reason
			ReportLog.WARNING("Test Skipped");
			ReportLog.FAIL(result.getSkipCausedBy().toString());
		}		
		if (getDriver() != null) {
			ReportLog.PASS("Closing web driver");
			getDriver().close();
			getDriver().quit();
			ReportLog.PASS("Web driver is closed");
		}
		ReportLog.extentReport.endTest(ReportLog.extentTest);
		ReportLog.LOG("Test End");
	}

	@BeforeTest
	public void doBeforeTest() {
	}

	@AfterTest
	public void doAfterTest() {
	}

	public Properties loadProperties(String propertyFilePath) throws Exception {
		try {
			String file = "bundle.properties";
			InputStream input = getClass().getClassLoader().getResourceAsStream(file);
			prop = new Properties();
			prop.load(input);
			System.out.println(prop.getProperty("db.url"));
			System.out.println(prop.getProperty("db.user"));
			System.out.println(prop.getProperty("db.password"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}

	private void initializeDriver() {
		String browser = System.getProperty("browserName");
		ReportLog.LOG("Launching browser: " + browser);
		System.out.println("Launching driver: " + browser);
		if (browser.toUpperCase().equalsIgnoreCase("IE")) {
			ReportLog.LOG("Setting up Internet explorer options");
			InternetExplorerOptions capabilities = new InternetExplorerOptions();
			// capabilities.setCapability("browser.download.dir","c:\\downloads");
			capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
			setDriver(new InternetExplorerDriver(capabilities));
			ReportLog.LOG("IE Driver started");

		} else if (browser.equalsIgnoreCase("Chrome")) {
//			System.setProperty("webdriver.chrome.driver","S:\\Technology\\TTGACMX\\QA\\QA All\\Selenium and Eclipse Files\\IEDriverServer_Win32_3.4.0\\chromedriver.exe");
//			CommonVariables.driver = new ChromeDriver();
//			System.out.println("Chrome Driver started");
//			CommonVariables.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//			CommonVariables.driver.manage().window().maximize(); // maximize the
//			// window (just looks better and easier to
//			// follow)
//			// CommonVariables.driver.manage().window().setSize(new Dimension(500, 500));
//			// ;
//			// CommonVariables.driver.manage().window().setPosition(new Point(500, 600));
//			CommonVariables.setParentWindowID(CommonVariables.driver.getWindowHandle());

		} else if (browser.equalsIgnoreCase("Firefox")) {
//			System.setProperty("webdriver.chrome.driver",
//					"S:\\Technology\\TTGACMX\\QA\\QA All\\Selenium and Eclipse Files\\IEDriverServer_Win32_3.4.0\\geckodriver.exe");
//			CommonVariables.driver = new FirefoxDriver();
//			System.out.println("Firefox Driver started");
//			CommonVariables.driver.manage().window().maximize(); // maximize the window (just looks better and
//																	// easier to follow)
//			CommonVariables.setParentWindowID(CommonVariables.driver.getWindowHandle());

		} else if (browser.equalsIgnoreCase("Edge")) {
//			System.setProperty("webdriver.chrome.driver",
//					"S:\\Technology\\TTGACMX\\QA\\QA All\\Selenium and Eclipse Files\\IEDriverServer_Win32_3.4.0\\MicrosoftWebDriver.exe");
//			CommonVariables.driverEdge = new EdgeDriver();
//			System.out.println("Edge Driver started");
//			CommonVariables.driverEdge.manage().window().maximize(); // maximize the window (just looks better and
			// easier to follow)

		} else if (browser.equalsIgnoreCase("IE2")) {
//			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
//			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//			CommonVariables.driverIE2 = new InternetExplorerDriver(caps); // open IE
//			System.out.println("IE Driver started");
//
//			CommonVariables.driverIE2.manage().window().setSize(new Dimension(500, 500));
//			CommonVariables.driverIE2.manage().window().setPosition(new Point(0, 0));

		}
		getDriver().manage().timeouts().implicitlyWait(Long.valueOf(System.getProperty("implicitWait")),
				TimeUnit.SECONDS);
		getDriver().manage().window().maximize();
		ReportLog.LOG("Launching application: " + System.getProperty("appUrl"));
		getDriver().navigate().to(System.getProperty("appUrl"));
	}

	public void loadBackgroundData() {

	}

}

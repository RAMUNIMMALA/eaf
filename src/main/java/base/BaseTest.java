package base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest implements IEAFbase {
	
	WebDriver drivevr = null;
	
	Properties prop = null;
	
    //implementation method
    public void loadBackgroundData(){

    }
    
    public WebDriver getDrivevr() {
		return drivevr;
	}

	public void setDrivevr(WebDriver drivevr) {
		this.drivevr = drivevr;
	}
    
    @BeforeSuite
    public void doBeforeSuite() {
    	System.out.println("doBeforeSuite");
    	ReportLog.initializeReport();
    }
    
    @AfterSuite
    public void doAfterSuite() {
    	System.out.println("doAfterSuite");
    }
    
    @BeforeClass
    public void doBeforeClass() {
    	System.out.println("doBeforeClass");
    }
    
    @AfterClass
    public void doAfterClass() {
    	System.out.println("doAfterClass");
    }
    
    @BeforeMethod
    public void doBeforeMethod() {
    	System.out.println("doBeforeMethod");
    }
    
    @AfterMethod
    public void doAfterMethod() {
    	System.out.println("doAfterMethod");
    }
    
    @BeforeTest
    public void doBeforeTest() {
        System.out.println("doBeforeTest");
        ReportLog.startTest();
    }
    
    @AfterTest
    public void doAfterTest() {
        System.out.println("doAfterTest");
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
    	String browser = System.getProperty("browser");
    	if (browser.equalsIgnoreCase("IE")) {    		
    		InternetExplorerOptions capabilities = new InternetExplorerOptions();// DesiredCapabilities.internetExplorer();
    		capabilities.setCapability("browser.download.dir","c:\\downloads");
        	capabilities.setCapability("ignoreZoomSetting", true);
        	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        	//capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        	capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
        	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        	capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        	setDrivevr(new InternetExplorerDriver(capabilities)); // open IE
    		System.out.println("IE Driver started");

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
    }
    
    
}

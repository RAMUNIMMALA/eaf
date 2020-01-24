package base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
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
    
    public WebDriver getDriver() {
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
			System.setProperty("webdriver.chrome.driver","D:\\eclipse workspace\\eaf\\drivers\\chrome\\chromedriver.exe");
			
			DesiredCapabilities capabilities=new DesiredCapabilities();
		//capabilities.setCapability("browser.download.dir","c:\\downloads");
        	capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setCapability(CapabilityType.BROWSER_NAME,"chrome");
        	//capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        	capabilities.setCapability(ChromeOptions.CAPABILITY, false);
        	capabilities.setCapability(ChromeOptions.CAPABILITY, true);
        	capabilities.setCapability(ChromeOptions.CAPABILITY, true);
        	//setDrivevr(new ChromeDriver()); // open IE
			System.out.println("Chrome Driver started");			
	getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		getDriver().manage().window().maximize(); // maximize the
			// window (just looks better and easier to
			// follow)
			getDriver().manage().window().setSize(new Dimension(500, 500));

           getDriver().manage().window().setPosition(new Point(500, 600));
	//capabilities.setParentWindowID(getDriver().getWindowHandle());
	
	

		} else if (browser.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.firefox.driver",
					"D:\\eclipse workspace\\eaf\\drivers\\firefox\\geckodriver.exe");
			
			System.out.println("Firefox Driver started");
			 DesiredCapabilities capabilities = new DesiredCapabilities();
			    FirefoxOptions options = new FirefoxOptions();
			    options.setHeadless(true);
			    capabilities.merge(options);
			    //setDrivevr(new FirefoxDriver()); 
			    getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				getDriver().manage().window().maximize(); // maximize the
					// window (just looks better and easier to
					// follow)
					getDriver().manage().window().setSize(new Dimension(500, 500));

		           getDriver().manage().window().setPosition(new Point(500, 600));
		
			//getDriver().setParentWindowID(getDriver().getWindowHandle());

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
    	
    	//getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 
    	//getDriver().manage().window().maximize(); 
    	//getDriver().navigate().to(System.getProperty("browser"));
    	getDriver().navigate().to("https://www.google.com/?gws_rd=ssl");
    }
    
    
}

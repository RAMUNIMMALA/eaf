package base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
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
    	
    }
    
    
}

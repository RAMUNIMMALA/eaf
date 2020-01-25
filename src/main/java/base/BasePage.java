package base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public abstract class BasePage implements IEAFbase {

	WebDriver driver = null;	
	Properties prop = null;
	
	public BasePage() {
		
	}
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
   public WebDriver getDriver() {
		return driver;
	}

	public void setDrivevr(WebDriver driver) {
		this.driver = driver;
	}
	
	//abstract methods
    public abstract void verifyPageLoad();
}

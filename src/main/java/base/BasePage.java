package base;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage implements IEAFbase {

	WebDriver driver = null;	
	Properties prop = null;
	WebDriverWait wait = null;

	//getters and setter
	//getting explicit wait from pom.xml
	public int getExplicitWait() {
		return Integer.valueOf(System.getProperty("explicitWait"));
	}

	//get webdriver wait object
	public WebDriverWait getWait() {
		return new WebDriverWait(driver, 10);
	}
	Boolean explicitWait = null;

	
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

	//actions
	protected WebElement getElement(By by, String controlName) throws Exception {
		ReportLog.LOG("finding element: " + controlName);
		wait = getWait();
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		WebElement element = getDriver().findElement(by);
		ReportLog.LOG(controlName + " : element is found");
		return element;
	}
}

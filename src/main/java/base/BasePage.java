package base;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage implements IEAFbase {

	WebDriver driver = null;	
	Properties prop = null;
	WebDriverWait wait = null;
	Boolean explicitWait = null;

	public BasePage() {
	}
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	//abstract methods
	public abstract void verifyPageLoad();

	//getters and setter
	public int getExplicitWait() {
		return Integer.valueOf(System.getProperty("explicitWait"));
	}

	public WebDriverWait getWait() {
		return new WebDriverWait(driver, getExplicitWait());
	}

    public WebDriver getDriver() {
		return driver;
	}

	public void setDrivevr(WebDriver driver) {
		this.driver = driver;
	}

	//to get an element
	protected WebElement getElement(By by, String controlName) {
		ReportLog.LOG("Finding element: " + controlName);
		getWait().until( ExpectedConditions.visibilityOfElementLocated(by));
		WebElement element = getDriver().findElement(by);
		JavascriptExecutor js=(JavascriptExecutor)getDriver();
		String script = ("arguments[0].setAttribute('style','background:"+(System.getProperty("higlightcolor"))+";border:2px solid red:');");
		js.executeScript(script,element);
		ReportLog.LOG(controlName + " element is found");
		return element;
	}

	public void click(WebElement element, String controlName) {
		ReportLog.LOG("clicking on element: " + controlName);
		getWait().until( ExpectedConditions.elementToBeClickable(element));
		element.click();
		ReportLog.LOG( controlName + " is clicked");
	}

	public void setText(WebElement element, String testData) {
		ReportLog.LOG("Enter test data as: " + testData);
		element.isEnabled();
		element.sendKeys(testData);
		ReportLog.LOG( testData + " is Entered");
	}

	public void selectText(Select element, String option) {
		ReportLog.LOG("Select text as: " + option);
		element.selectByVisibleText(option);
		ReportLog.LOG( option + " is Selected");
	}
}

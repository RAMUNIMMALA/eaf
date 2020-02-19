package base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public abstract class BasePage implements IEAFbase {

	private static final Object WebElement = null;
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
    public abstract void verifyPageLoad();{
}
    
   By byusername=By.id("txtFullName");
    By byclick=By.id("create");
    
   public WebElement getUsername() {
   	return getElement(byusername,"textbox");
   	 }
   public WebElement getHighLight(By by) {
	 //driver.findElement(byusername).sendKeys(System.getProperty("colour"));
	 return  getElementHighLight(byusername);
			  }
    public WebElement btnClick() {
    	return click(byclick);
    
    }

	public   BasePage performuserLoginwithValidDetails() throws Exception
	{
	String content="pradeep";
	System.out.println("set text");
	Thread.sleep(3000);
	//WaitVisibilityOfElement(getDriver(), byusername);
		getUsername();
		getHighLight(byusername);
		setText(byusername, content, "textbox");
		btnClick();
		return this;
	
	}

public WebElement getElement(By by,String controlName) {
	ReportLog.LOG("finding element:"+controlName);
	getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	WebElement element=getDriver().findElement(by);
	ReportLog.LOG(controlName +"element is found");
	return element;
}
public WebElement getElementHighLight(By locator) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript(System.getProperty("colour"));
	//driver.findElement(byusername).sendKeys(System.getProperty("colour"));
	return null;
	

}
public void setText(By by,String content,String controlname) {
	ReportLog.LOG("enter data"+controlname);
	WebElement element=getDriver().findElement(by);
	element.sendKeys(content);
	ReportLog.LOG("enter data into"+controlname+"as"+content );

}

public WebElement click(By by) {
	ReportLog.LOG("element");
	WebElement ele=getDriver().findElement(byclick);
	ele.click();
	ReportLog.LOG("clicked");
	return ele;
}
public void WaitForElementTobeVisible(WebDriver driver, By by) {
    WaitVisibilityOfElement(driver, by);
  }
public void WaitVisibilityOfElement(WebDriver driver, By by) {
ReportLog.LOG("element found");
WebDriverWait Wait = new WebDriverWait(driver, 30);
Wait.until(ExpectedConditions.visibilityOfElementLocated(byusername));
  }

}








package wrapperSelenium;

import org.openqa.selenium.WebDriver;

public class BrowserActions {
	
    private  WebDriver driver;

    
	public BrowserActions(WebDriver driver) {
    	this.driver = driver;
        }
    
    public void closeBrowser() {
        if (driver != null) 
        {
        	driver.quit();
        }
    }
    
	public BrowserActions navigate( String url) {
		driver.navigate().to(url);
		return this;
	}
	
	public BrowserActions fullscreen() {
		driver.manage().window().fullscreen();
		return this;
	}
	
	public BrowserActions maximize() {
		driver.manage().window().maximize();
		return this;
	}
	
}

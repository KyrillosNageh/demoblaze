package wrapperSelenium;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.reader.PropertiesReader;

public class ElementActions {

    private  WebDriver driver;
    private WebDriverWait wait;
    private PropertiesReader properties;
    
	public ElementActions(WebDriver driver) {
		this.driver =  driver;
    	properties = new PropertiesReader("src\\main\\resources\\properties\\WebConfig.properties");
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(properties.getProperty("elementTimeout"))));
	}
	
	public ElementActions click(By locator) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		driver.findElement(locator).click();
		return this;
	}
	
	public ElementActions acceptAlert(){
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		return this;
	}
	
	public String getTextAlert(){
		wait.until(ExpectedConditions.alertIsPresent());
		return driver.switchTo().alert().getText();
	}
	
	public ElementActions type(By locator,String text) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
		return this;
	}
	
	public String getText(By locator) {
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		driver.findElement(locator).getText();
		return this.driver.findElement(locator).getText();
	}
	
	public boolean isElementDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
}

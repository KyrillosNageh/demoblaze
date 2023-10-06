package home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import commonWebComponents.CommonWebComponents;
import product.Product;
import wrapperSelenium.ElementActions;

public class ProductsList extends CommonWebComponents{
	
	/****************************************************************************
	*  >>	Variables
	*****************************************************************************/
	private ElementActions ElementAction;
	private WebDriver driver;	
	
	/****************************************************************************
	*  >>	Constructor
	*****************************************************************************/
	public ProductsList(WebDriver drive) {
		super(drive);
		this.driver = drive;
		this.ElementAction = new ElementActions(this.driver);
	}
	
	/****************************************************************************
	*  >>	Locators
	*****************************************************************************/
    public final static By productByName(String name) {
    return By.xpath("//*[@class='card-title'] //*[contains(text(),'"+ name +"')]");
    }
    
    public final static By productByIndex(int index) {
    return By.xpath("(//*[@class='card-title'])["+ index +"]");
    }
    
    /****************************************************************************
	*  >>	Keywords
	*****************************************************************************/
    public Product clickOnProduct(int index) {
    	ElementAction.click(productByIndex(index));
    	return new Product(driver);
    }
    
    public String getProductName(int index) {
    	return ElementAction.getText(productByIndex(index));
    }
        
}

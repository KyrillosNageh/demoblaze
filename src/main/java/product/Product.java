package product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import commonWebComponents.CommonWebComponents;
import wrapperSelenium.ElementActions;

public class Product extends CommonWebComponents{
	/****************************************************************************
	*  >>	Variables
	*****************************************************************************/
	private ElementActions ElementAction;
	private WebDriver driver;	
	public static double price;
	
	/****************************************************************************
	*  >>	Constructor
	*****************************************************************************/
	public Product(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.ElementAction = new ElementActions(driver);
	}
	
	/****************************************************************************
	*  >>	Locators
	*****************************************************************************/
	private final static By addToCart_Btn = By.xpath("//*[contains(@class,'btn-success')]");
	private final static By productName_txt = By.className("name");
		
	/****************************************************************************
	*  >>	Keywords
	*****************************************************************************/
    public Product addProduct() {
    	ElementAction.click(addToCart_Btn);
    	return this;
    }
     
    public Product acceptAlert() {
    	ElementAction.acceptAlert();
    	return this;
    }
    
    public String getAlertText() {
    	return ElementAction.getTextAlert();
    }
    
    public String getProductNameText() {
    	return ElementAction.getText(productName_txt);
    }     
}

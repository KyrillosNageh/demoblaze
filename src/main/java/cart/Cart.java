package cart;


import static org.testng.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import commonWebComponents.CommonWebComponents;
import placeOrder.PlaceOrder;
import wrapperSelenium.ElementActions;

public class Cart extends CommonWebComponents{
	/****************************************************************************
	*  >>	Variables
	*****************************************************************************/
	private ElementActions ElementAction;
	private WebDriver driver;	
	
	/****************************************************************************
	*  >>	Constructor
	*****************************************************************************/
	public Cart(WebDriver driver) {
		super(driver);
		this.driver =driver;
		this.ElementAction = new ElementActions(driver);
	}
	
	/****************************************************************************
	*  >>	Locators
	*****************************************************************************/
	private static By getProductTitle_Txt(int productIndex){
		return By.xpath("(//*[@class='success'])["+ productIndex +"] /td[2]");
	}
	
	private static By getProductPrice_Txt(int productIndex){
		return By.xpath("(//*[@class='success'])["+ productIndex +"] /td[3]");
	}
	
	private final static By placeOrder_Btn =By.xpath("//*[contains(text(),'Place Order')]");
	
	/****************************************************************************
	*  >>	Keywords
	*****************************************************************************/
	public String getProductTitle(int productIndex) {
		return ElementAction.getText(getProductTitle_Txt(productIndex));
	}
	
	public String getProductPrice(int productIndex) {
		return ElementAction.getText(getProductPrice_Txt(productIndex));
	}
	
	public PlaceOrder clickOnPlaceOrder() {
		 ElementAction.click(placeOrder_Btn);
		 return new PlaceOrder(driver);
	}
	
	public Cart verifyProductPrice(int index, double expectedPrice) {
		double actualPrice = Double.parseDouble(getProductPrice(index));
		assertEquals(actualPrice, expectedPrice);
		return this;
	}
}

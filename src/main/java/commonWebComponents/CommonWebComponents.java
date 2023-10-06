package commonWebComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import cart.Cart;
import wrapperSelenium.ElementActions;

public class CommonWebComponents implements IHeader,IFooter  {
	/****************************************************************************
	*  >>	Variables
	*****************************************************************************/
	private ElementActions ElementAction;
	private WebDriver driver;	

	/****************************************************************************
	*  >>	Constructor
	*****************************************************************************/
	public CommonWebComponents(WebDriver driver) {
		this.driver= driver;
		this.ElementAction = new ElementActions(driver);
	}
	
	/****************************************************************************
	*  >>	Locators
	*****************************************************************************/
	private By cart_Btn = By.id("cartur");
	
	public Cart clickOnCart() {
		ElementAction.click(cart_Btn);
		return new Cart(driver);
	}
	
}

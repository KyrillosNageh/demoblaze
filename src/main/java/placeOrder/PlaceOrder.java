package placeOrder;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import commonWebComponents.CommonWebComponents;
import home.ProductsList;
import wrapperSelenium.ElementActions;

public class PlaceOrder extends CommonWebComponents{
	/****************************************************************************
	*  >>	Variables
	*****************************************************************************/
	private ElementActions ElementAction;
	private WebDriver driver;	
	
	/****************************************************************************
	*  >>	Constructor
	*****************************************************************************/
	public PlaceOrder(WebDriver driver) {
		super(driver);
		this.driver =driver;
		this.ElementAction = new ElementActions(driver);
	}
	
	/****************************************************************************
	*  >>	Locators
	*****************************************************************************/
	private final static By name_InTxt = By.id("name");
	private final static By country_InTxt = By.id("country");
	private final static By city_InTxt = By.id("city");
	private final static By card_InTxt = By.id("card");
	private final static By month_InTxt = By.id("month");
	private final static By year_InTxt = By.id("year");
	private final static By purchase_Btn =By.xpath("//*[contains(text(),'Purchase')]");
	
	private final static By successMsg_Txt = By.xpath("//h2[contains(text(),'Thank you for your purchase')]");
	private final static By oK_Btn = By.xpath("//*[@class='confirm btn btn-lg btn-primary' and text()='OK']");
	
	/****************************************************************************
	*  >>	Keywords
	*****************************************************************************/
	public PlaceOrder fillPurchaseOrder(String name, String Country, String city, String card,
			String month,String year) {
		ElementAction.type(name_InTxt, name)
		.type(country_InTxt, Country)
		.type(city_InTxt, city)
		.type(card_InTxt, card)
		.type(month_InTxt, month)
		.type(year_InTxt, year)
		.click(purchase_Btn);
		
		return this;
	}
		
	public PlaceOrder verifyOrderCreatedSuccessfully( ) {
		assertEquals(ElementAction.isElementDisplayed(successMsg_Txt), true);
		return this;
	}
	
	public ProductsList clickOnOK( ) {
		ElementAction.click(oK_Btn);
		return new ProductsList(driver);
	}
}

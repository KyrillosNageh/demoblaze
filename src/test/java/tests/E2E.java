package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import home.ProductsList;
import utilities.reader.JsonReader;
import utilities.reader.PropertiesReader;
import wrapperSelenium.BrowserActions;
import wrapperSelenium.WrapperDriver;

public class E2E {
	WrapperDriver driver;
	BrowserActions browser;
	PropertiesReader properties;
	JsonReader jsonReader;

	@Test
	public void  verifyE2E_PurchaseOrder() {
		new ProductsList(driver.getDriver())
		.clickOnProduct(1)
		.addProduct()
		.acceptAlert()
		.clickOnCart()
		.verifyProductPrice(1, 360)
		.clickOnPlaceOrder()
		.fillPurchaseOrder(jsonReader.readJsonData("Name"),
				jsonReader.readJsonData("Country"), 
				jsonReader.readJsonData("City"),
				jsonReader.readJsonData("CreditCard"),
				jsonReader.readJsonData("Month"),
				jsonReader.readJsonData("Year"))
		.verifyOrderCreatedSuccessfully()
		.clickOnOK();
	}
	
	@BeforeTest
	public void beforeTest() {
    	properties = new PropertiesReader("src\\main\\resources\\properties\\WebConfig.properties");
    	jsonReader = new JsonReader("src\\test\\resources\\testData\\PlaceOrder.json");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver =new WrapperDriver();
		new BrowserActions(driver.getDriver())
		.maximize()
		.navigate(properties.getProperty("baseUrl"));
		
	}
	
	@AfterMethod
	public void afterMethod() {
		new BrowserActions(driver.getDriver())
		.closeBrowser();	
	}
}

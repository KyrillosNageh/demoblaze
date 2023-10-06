package wrapperSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.reader.PropertiesReader;

public class WrapperDriver  {
    private  WebDriver driver;
    private PropertiesReader properties;

    public WrapperDriver() {
    	
    	properties = new PropertiesReader("src\\main\\resources\\properties\\WebConfig.properties");
    	
        String browser = properties.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {        	
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("remot")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
    

    public  WebDriver getDriver() {
        return driver;
    }

}

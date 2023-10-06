package utilities.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {

	   private Properties properties;
	   private File propertiesFile;
	   
	    public PropertiesReader(String filePath) {
	        this.properties = new Properties();
	        this.propertiesFile = new File(filePath);
	        try (FileInputStream input = new FileInputStream(this.propertiesFile.getAbsolutePath())) {
	            this.properties.load(input);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public String getProperty(String key) {
	        return this.properties.getProperty(key);
	    }
}

package utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractPrice {

	private double price;
	private String input;
	
	   public ExtractPrice(String input) {
	        this.input = input;
	    }
	
    public ExtractPrice extractPrice() {
        // Define a regular expression pattern to match prices in the format "$X.XX" or "$XX.XX"
        String regex = "\\$([0-9]+\\.[0-9]{2}|[0-9]+)";
        
        // Compile the regex pattern
        Pattern pattern = Pattern.compile(regex);
        
        // Create a matcher to find the price in the input string
        Matcher matcher = pattern.matcher(input);
        
        // Check if a match is found
        if (matcher.find()) {
            // Extract and parse the matched price
            String matchedPrice = matcher.group(1);
            price = Double.parseDouble(matchedPrice);
            return this;
        }
        
        // Return a default value or handle the case when no match is found
        return this;

    }
    
    public double getPrice() {
    	return price;
    }
}

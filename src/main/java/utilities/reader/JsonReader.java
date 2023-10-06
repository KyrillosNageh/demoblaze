package utilities.reader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonReader {
	private JSONObject jsonData;

    public JsonReader(String filepath) {
    	File file = new File(filepath);
        try (FileReader reader = new FileReader(file.getAbsolutePath())) {
            JSONTokener tokener = new JSONTokener(reader);
            jsonData = new JSONObject(tokener);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readJsonData(String key) {
        if (jsonData != null && jsonData.has(key)) {
             return jsonData.getString(key); 
        } else {
            return null; 
        }
    }
}

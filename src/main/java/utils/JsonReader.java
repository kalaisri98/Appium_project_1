package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class JsonReader {
    public static JSONObject getData(String filePath) throws Exception {
        FileReader reader = new FileReader(filePath);
        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(reader);
    }
}

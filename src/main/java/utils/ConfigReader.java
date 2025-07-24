package utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop = new Properties();

    static {
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}

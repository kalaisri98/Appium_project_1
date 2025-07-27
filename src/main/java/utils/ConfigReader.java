package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Logger logger = LogManager.getLogger(ConfigReader.class);
    private static Properties prop = new Properties();

    static {
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {
            prop.load(input);
            logger.info("Configuration file loaded successfully.");
        } catch (Exception e) {
            logger.error("Failed to load config.properties", e);
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        String value = prop.getProperty(key);
        logger.debug("Reading config key: " + key + ", value: " + value);
        return value;
    }
}

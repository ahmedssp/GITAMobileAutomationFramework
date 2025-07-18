package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            String env = System.getProperty("env", "qa"); // Default to 'qa'
            String path = System.getProperty("user.dir") + "/src/main/java/configurations/config." + env + ".properties";
            FileInputStream fis = new FileInputStream(path);
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            System.err.println("Failed to load config file for environment: " + System.getProperty("env", "qa"));
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        if (properties == null) {
            throw new IllegalStateException("Properties file not loaded.");
        }
        return properties.getProperty(key);
    }


    public class TestDataReader {
        private static JsonNode testData;

        static {
            try {
                String path = System.getProperty("user.dir") + "/src/test/resources/testdata.json";
                ObjectMapper mapper = new ObjectMapper();
                testData = mapper.readTree(new File(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Get string value (for normal test data)
        public static String get(String... keys) {
            JsonNode node = testData;
            for (String key : keys) {
                node = node.get(key);
                if (node == null) return null;
            }
            return node.asText();
        }

        // Get a JsonNode (for swipes, tap, etc.)
        public static JsonNode getNode(String... keys) {
            JsonNode node = testData;
            for (String key : keys) {
                node = node.get(key);
                if (node == null) return null;
            }
            return node;
        }
    }
}
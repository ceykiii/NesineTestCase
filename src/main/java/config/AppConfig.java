package config;
import java.io.InputStream;
import java.util.Properties;

/**
 * AppConfig class for loading and providing access to configuration properties.
 * This class is developed by Cem AÇAR.
 * Last updated on 12.11.23
 */
public class AppConfig {
    private static Properties properties = new Properties();

    static {
        loadConfig();
    }

    /**
     * Loads configuration properties from the "app.config" file.
     * If the file is not found, a message is printed to the console.
     */
    private static void loadConfig() {
        try (InputStream input = AppConfig.class.getClassLoader().getResourceAsStream("app.config")) {
            if (input == null) {
                System.out.println("Sorry, unable to find app.config");
                return;
            }
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves the value associated with the specified key from the configuration properties.
     *
     * @param key The key for which to retrieve the value.
     * @return The value associated with the specified key, or null if the key is not found.
     */
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}

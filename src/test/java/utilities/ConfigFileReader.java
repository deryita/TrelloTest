package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private final Properties properties;


    public ConfigFileReader() {
        BufferedReader reader;
        String propertyFilePath = "src/test/resources/config.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getUserName() {
        String username = properties.getProperty("username");
        if (username != null) return username;
        else throw new RuntimeException("Username not specified in the Configuration.properties file.");
    }

    public String getPassword() {
        String password = properties.getProperty("password");
        try {
            return GeneralUtilities.decode(password);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Password not specified in the Configuration.properties file.");
        }
    }

    public String getApiUrl() {
        String apiurl = properties.getProperty("apiurl");
        if (apiurl != null) return apiurl;
        else throw new RuntimeException("apiurl not specified in the Configuration.properties file.");
    }

    public String getToken() {
        String token = properties.getProperty("token");
        if (token != null) return token;
        else throw new RuntimeException("token not specified in the Configuration.properties file.");
    }

    public String getApiKey() {
        String apikey = properties.getProperty("apikey");
        if (apikey != null) return apikey;
        else throw new RuntimeException("apikey not specified in the Configuration.properties file.");
    }

}

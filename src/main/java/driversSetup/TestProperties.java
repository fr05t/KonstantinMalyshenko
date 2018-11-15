package driversSetup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    Properties property = new Properties();

    public Properties getCurrentProperties() {

        FileInputStream fis;

        try {
            fis = new FileInputStream("src\\test\\resources\\mobile\\hw2.properties");
            property.load(fis);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return property;
    }

    public String getProp(String propKey) {
        if (!propKey.contains(propKey)) {
            property = getCurrentProperties();
        }
        return property.getProperty(propKey, null);
    }
}

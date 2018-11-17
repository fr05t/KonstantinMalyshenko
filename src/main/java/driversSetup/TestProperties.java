package driversSetup;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static enums.mobile.SelectProperties.ANDROID_WEB;

public class TestProperties {

    Properties property = new Properties();

    public TestProperties() {
        getCurrentProperties();
    }

    public Properties getCurrentProperties() {

        FileInputStream fis;

        try {
            //fis = new FileInputStream("src\\test\\resources\\mobile\\hw2.properties");
            fis = new FileInputStream(ANDROID_WEB.getProFile());
            property.load(fis);
            fis.close();

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

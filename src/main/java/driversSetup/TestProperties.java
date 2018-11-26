package driversSetup;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static enums.mobile.SelectProperties.ANDROID_NATIVE;
import static enums.mobile.SelectProperties.ANDROID_WEB;

public class TestProperties {

    static Properties property = new Properties();
    private static String path;

    public TestProperties(String path) {
        this.path = path;
        getCurrentProperties();
    }

    public static Properties getCurrentProperties() {

        FileInputStream fis;

        try {
            //fis = new FileInputStream("src\\test\\resources\\mobile\\hw2.properties");
            fis = new FileInputStream(path);
            property.load(fis);
            fis.close();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return property;
    }

    public static String getProp(String propKey) {
        if (!propKey.contains(propKey)) {
            property = getCurrentProperties();
        }
        return property.getProperty(propKey, null);
    }
}

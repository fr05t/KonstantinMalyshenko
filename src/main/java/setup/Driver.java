package setup;

import driversSetup.TestProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import static driversSetup.TestProperties.getProp;
import static enums.mobile.Capability.EMULATOR_5554;
import static enums.mobile.MobileProperties.*;

public class Driver {

    protected AppiumDriver driverSingle = null;
    protected static DesiredCapabilities capabilities;
    protected static WebDriverWait waitSingle;


    protected String AUT;
    protected String SUT;
    protected String TEST_PLATFORM;
    protected String DRIVER;

    //Initialize parameters from property file
    protected Driver() {

    }

    protected void prepareConfig(String propFile) {
        TestProperties testProperties = new TestProperties(propFile);
        AUT = getProp(aut.toString());
        String t_sut = getProp(sut.toString());
        SUT = t_sut == null ? null : "http://" + t_sut;
        TEST_PLATFORM = getProp(platform.toString());
        DRIVER = getProp("driver");
    }

    protected void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;

        //Select platform Android or IOS, and drivers
        switch (TEST_PLATFORM) {
            case "Android":
                File mdr = new File("src\\main\\resources\\mobdrv\\chromedriver.exe");
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, EMULATOR_5554.getDevice());
                capabilities.setCapability("chromedriverExecutable", mdr.getAbsolutePath());
                // capabilities.setCapability("chromedriverExecutable", "c:\\src\\chromedriver.exe");
                browserName = "Chrome";
                break;
            case "IOS":
                browserName = "Safari";
                break;
            default:
                throw new Exception("Unknown platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);


        //Set type of application
        if (AUT != null && SUT == null) {                   //Native
            File app = new File(AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

        } else if (SUT != null && AUT == null) {           // Web
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);

        } else {
            throw new Exception("Unclear type of mobile app");
        }

        if (driverSingle == null) {
            driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);
        }

        if (waitSingle == null) {
            waitSingle = new WebDriverWait(driver(), 10);
        }

    }

    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) prepareDriver();
        return driverSingle;
    }

    protected WebDriverWait driverWait() {
        return waitSingle;
    }
}




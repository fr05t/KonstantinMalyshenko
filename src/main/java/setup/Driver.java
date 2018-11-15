package setup;

import driversSetup.TestProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static enums.mobile.Capability.EMULATOR_5554;
import static enums.mobile.MobileProperties.*;

public class Driver extends TestProperties {
    protected AppiumDriver driverSingle = null;
    protected static DesiredCapabilities capabilities;
    protected static WebDriverWait waitSingle;

    protected String AUT;
    protected String SUT;
    protected String TEST_PLATFORM;
    protected String DRIVER;

    protected Driver() throws IOException {
        AUT = getProp(aut.toString());
        String t_sut = getProp(sut.toString());
        SUT = t_sut == null ? null : "http://" + t_sut;
        TEST_PLATFORM = getProp(platform.toString());
        DRIVER = getProp("drive");
    }

    public void prepareDriver() throws Exception {
        capabilities = new DesiredCapabilities();
        String browserName;

        switch (TEST_PLATFORM) {
            case "Android":
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, EMULATOR_5554.getDevice());
                browserName = "Chrome";
                break;
            case "IOS":
                browserName = "Safari";
                break;
            default:
                throw new Exception("Unknown platform");
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        if (AUT != null && SUT == null) {
            File app = new File(AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else if (SUT != null && AUT == null) {
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception("Undefined type of mobile app");
        }
        if (driverSingle == null) {
            driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);
        }
        if (waitSingle == null) {
            waitSingle = new WebDriverWait(driverSingle, 10);
        }

    }

    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) prepareDriver();
        return driverSingle;
    }

    protected WebDriverWait driverWait() {
        return waitSingle;
    }

    public void prepareAndroidNative() throws MalformedURLException { // exception required by java.net.URL


        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("deviceName","621HECQD25GJS");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");

        // path to app
        // Copy the application (.apk), which will become AUT, to the specified location,
// e.g. "resources" folder of the project
        File appDir = new File("src\\test\\resources\\mobile\\");
        File app = new File(appDir, "ContactManager.apk");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());

// Init driverSingle for local Appium server with capabilities have been set
        driverSingle = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    protected void prepareAndroidWeb() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("deviceName", "emulator-5554");
        //capabilities.setCapability("deviceName","621HECQD25GJS");
        capabilities.setCapability("platformName", "Android");

        // specific webTests capabilities
        capabilities.setCapability("browserName", "Chrome");
        //capabilities.setCapability("browserName", "Browser");

        // Init driverSingle for local Appium server with capabilities have been set
        driverSingle = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities);

    }
}




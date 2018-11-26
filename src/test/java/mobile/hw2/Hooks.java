package mobile.hw2;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import setup.Driver;

import java.io.IOException;

import static enums.mobile.SelectProperties.ANDROID_NATIVE;
import static enums.mobile.SelectProperties.ANDROID_WEB;
import static java.lang.System.setProperty;

public class Hooks extends Driver {

    protected Hooks()  {

    }

    @BeforeSuite(description = "Set property", groups = {"web", "native"})
    public void beforeSuite() {
        setProperty("webdriver.chrome.driverSingle", "src\\main\\resources\\mobdrv\\mchromedriver.exe");
    }

    @BeforeClass(groups = {"web", "native"})
    public void setUp() throws Exception {
        prepareConfig(ANDROID_WEB.getProFile());
        prepareDriver();
    }

    @AfterClass(groups = {"native","web"})
    public void tearDown() throws Exception {
        driverSingle.quit();
    }
}

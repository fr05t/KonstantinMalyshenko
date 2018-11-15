package base;


import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public class TestBaseWebObjects {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        setProperty("webdriver.chrome.driverSingle", "src\\main\\resources\\chromedriver.exe");
    }
}

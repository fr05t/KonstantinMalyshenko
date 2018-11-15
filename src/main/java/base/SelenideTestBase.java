package base;


import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Configuration.startMaximized;
import static java.lang.System.setProperty;

public class SelenideTestBase {

    @BeforeSuite
    public void beforeSuite() {

        setProperty("webdriver.chrome.driverSingle", "src/main/resources/chromedriver.exe");
        browser = "chrome";
        startMaximized = true;
    }
}

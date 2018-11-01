package base;


import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Configuration.*;
import static java.lang.System.setProperty;

public class SelenideTestBase {

    @BeforeSuite
    public void beforeSuite() {

        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        browser = "chrome";
        startMaximized = true;
    }
}

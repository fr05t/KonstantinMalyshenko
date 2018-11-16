package mobile.hw2;


import mobile.appObjects.AddContactPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.Driver;

import static java.lang.System.setProperty;

public class MobileWebTest extends Driver {

    private AddContactPage addContactPage;

    protected MobileWebTest() throws Exception {
        super();
    }

    @BeforeSuite(description = "Set property")
    public void beforeSuite() {
        setProperty("webdriver.chrome.driverSingle", "src\\main\\resources\\mobdrv\\mchromedriver.exe");
    }

    @BeforeClass
    public void setUp() throws Exception {
        prepareDriver();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driverSingle.quit();
    }

    @Test(description = "Simple native tests", groups = "native")
    public void SimplestTest() {

        driverSingle.get(SUT);
        waitSingle.until(ExpectedConditions.urlToBe(SUT+"/"));

    }
}

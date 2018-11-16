package mobile.hw2.webTests;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.Driver;

import static enums.mobile.FieldTitles.IANA_HOMEPAGE_TITLE;
import static java.lang.System.setProperty;

public class MobileWebTest extends Driver {

    protected MobileWebTest() throws Exception {
        super();
    }

    @BeforeSuite(description = "Set property")
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\mobdrv\\mchromedriver.exe");
    }

    @BeforeClass
    public void setUp() throws Exception {
        prepareDriver();
    }

    @AfterClass
    public void tearDown() throws Exception {
        driverSingle.quit();
    }

    @Test(description = "Simple web tests", groups = "web")
    public void SimplestTest() {

        //=================MobileWebElements=================
        By introText = By.id("intro");



        //=================Methods===========================
        driverSingle.get(SUT);
        waitSingle.until(ExpectedConditions.urlToBe(SUT + "/"));

        //=================Asserts============================
        Assert.assertEquals(IANA_HOMEPAGE_TITLE.getTitle(), driverSingle.getTitle()); // Assert page Title
        Assert.assertTrue(driverSingle.findElement(introText).isDisplayed());  // Assert intro text is displayed

    }
}

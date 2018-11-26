package mobile.hw2.webTests;


import mobile.hw2.Hooks;
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

public class MobileWebTest extends Hooks {


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

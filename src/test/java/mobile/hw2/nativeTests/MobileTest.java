package mobile.hw2.nativeTests;


import mobile.hw2.Hooks;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.Driver;

import static enums.mobile.FieldTitles.CONTACT_NAME;
import static enums.mobile.FieldTitles.CONTACT_PHONE;
import static java.lang.System.setProperty;

public class MobileTest extends Hooks {


    @Test(description = "Simple native tests", groups = "native")
    public void SimplestTest() {

        String app_package_name = "com.example.android.contactmanager:id/";

        //=============================Elements========================
        By add_btn = By.id(app_package_name + "addContactButton");

        By contactNameTitle = By.id("Contact Name");
        By contactName = By.xpath("//android.widget.TextView[@content-desc=\"Contact Name\"]\n");

        By contactPhoneTitle = By.id("Contact Phone");
        By contactPhone = By.xpath("//android.widget.TextView[@content-desc=\"Contact Phone\"]\n");

        //============================Methods==========================
        driverSingle.findElement(add_btn).click();


        //========================Asserts===============================
        Assert.assertTrue(driverSingle.findElement(contactName).isDisplayed());
        Assert.assertEquals(driverSingle.findElement(contactNameTitle).getText(), CONTACT_NAME.getTitle());
        Assert.assertTrue(driverSingle.findElement(contactPhone).isDisplayed());
        Assert.assertEquals(driverSingle.findElement(contactPhoneTitle).getText(), CONTACT_PHONE.getTitle());

        // Check keyboard is displayed
        try {
            driverSingle.hideKeyboard();
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }
}

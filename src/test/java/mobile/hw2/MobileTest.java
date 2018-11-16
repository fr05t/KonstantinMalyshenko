package mobile.hw2;


import mobile.appObjects.AddContactPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.Driver;

import static java.lang.System.setProperty;

public class MobileTest extends Driver {

    private AddContactPage addContactPage;

    protected MobileTest() throws Exception {
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

        String app_package_name = "com.example.android.contactmanager:id/";

        //=============================Elements========================
        By add_btn = By.id(app_package_name + "addContactButton");
        By contactName = By.xpath("//android.widget.TextView[@content-desc=\"Contact Name\"]\n");
        By contactPhone = By.xpath("//android.widget.TextView[@content-desc=\"Contact Phone\"]\n");

        //============================Methods==========================
        driverSingle.findElement(add_btn).click();


        //========================Asserts===============================
        Assert.assertTrue(driverSingle.findElement(contactName).isDisplayed());
        Assert.assertTrue(driverSingle.findElement(contactPhone).isDisplayed());

        try {
            driverSingle.hideKeyboard();
        } catch (Exception e) {
            Assert.assertTrue(false);
        }
    }
}

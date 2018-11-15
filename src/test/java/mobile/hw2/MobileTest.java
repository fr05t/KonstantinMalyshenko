package mobile.hw2;


import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import setup.Driver;

import java.io.IOException;

import static java.lang.System.setProperty;

public class MobileTest extends Driver {
    protected MobileTest() throws IOException {
    }

    @BeforeSuite
    public void beforeSuite() {
        setProperty("webdriver.chrome.driverSingle", "src\\main\\resources\\mobdrv\\mchromedriver.exe");
    }

    @BeforeClass
    public void setUp() throws Exception {
        prepareAndroidNative();
    }



    @Test
    public void SimplestTest() {
        String app_package_name = "/hierarchy/android.widget.FrameLayout\n";
        By add_btn = By.xpath("//android.widget.Button");
        //By add_btn = By.id(app_package_name + "addContactButton");
        driverSingle.findElement(add_btn).click();
        System.out.println("Simplest Appium test done");

    }

    @AfterClass
    public void tearDown() throws Exception {
        driverSingle.quit();
    }


}

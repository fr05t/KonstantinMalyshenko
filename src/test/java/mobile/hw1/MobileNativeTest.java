package mobile.hw1;


import driversSetup.DriverSetup;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MobileNativeTest extends DriverSetup {
    @BeforeClass
    /**
     * Prepare driver to run test(s)
     */
    public void setUp() throws Exception {
        prepareAndroidNative();
    }

    @Test
    /**
     * This simple test just click on button 'Add contact'
     */
    public void SimplestTest() {
        // String app_package_name = "com.example.android.contactmanager:id/";
        String app_package_name = "/hierarchy/android.widget.FrameLayout\n";
        By add_btn = By.xpath("//android.widget.Button");
        //By add_btn = By.id(app_package_name + "addContactButton");
        driver.findElement(add_btn).click();
        System.out.println("Simplest Appium test done");

    }

    @AfterClass
    /**
     * Close driver on all tests completion
     */
    public void tearDown() throws Exception {
        driver.quit();
    }


}

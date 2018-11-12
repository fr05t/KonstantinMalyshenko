package mobile.hw1;

import driversSetup.DriverSetup;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MobileWebTest extends DriverSetup {
    @BeforeClass
    /**
     * Prepare driver to run test(s)
     */
    public void setUp() throws Exception {
        prepareAndroidWeb();
    }

    @Test
    /**
     * This simple test just click on button 'Add contact'
     */
    public void SimplestTest(){
        driver.get("http:\\ya.ru");
    }

    @AfterClass
    /**
     * Close driver on all tests completion
     */
    public void tearDown() throws Exception {
        driver.quit();
    }
}

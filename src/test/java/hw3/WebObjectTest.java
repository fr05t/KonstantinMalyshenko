package hw3;

import base.HWTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import pageObjects.HWHomePage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.System.setOut;
import static java.lang.System.setProperty;

public class WebObjectTest extends HWTestBase {

    private WebDriver driver;
    private HWHomePage hwHomePage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        driver = new ChromeDriver();
        hwHomePage = PageFactory.initElements(driver, HWHomePage.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void homePageTests() {

        //1. Open test site by URL
        hwHomePage.open(driver, "https://epam.github.io/JDI/index.html");
        //2. Assert Browser title
        hwHomePage.checkTitle(this.driver);

        //3. Perform login
        hwHomePage.login("epam", "1234");

        //4. Assert User Name
        hwHomePage.checkUserName("PITER CHAILOVSKII");

        //5. Asset Assert Browser title
        hwHomePage.checkTitle(this.driver);

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        hwHomePage.checkHeaderSectionItems();

        //7. Assert that there are 4 icons(images) on the Index Page and they are displayed
        hwHomePage.checkIcons();

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        hwHomePage.checkIconsTexts();

        //9. Assert a text of the main header
        hwHomePage.checkMainHeader("EPAM FRAMEWORK WISHES…");

        //10. The iframe exists
        hwHomePage.checkIframe();

        //11. The logo exists
        hwHomePage.checkLogo(driver);

        //12. Driver has focus on the original window
        hwHomePage.switchFrame(driver);

        //13. Assert a text of the sub header
        hwHomePage.checkSubHeader("JDI GITHUB");

        //14. Assert that JDI GITHUB is a link and has a proper URL
        hwHomePage.checkSubHeaderLink();

        //15. Assert that there is Left Section
        hwHomePage.checkLeftSection();

        //16. Assert that there is Footer
        hwHomePage.checkFooter();

        //17. Close Browser
        hwHomePage.driverClose(driver);

    }
}

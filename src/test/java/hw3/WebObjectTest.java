package hw3;

import base.TestBaseWebObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePageObjects;

import java.util.concurrent.TimeUnit;

public class WebObjectTest extends TestBaseWebObjects {

    private WebDriver driver;
    private HomePageObjects homePageObjects;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        driver = new ChromeDriver();
        homePageObjects = PageFactory.initElements(driver, HomePageObjects.class);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test
    public void homePageTests() {

        //1. Open test site by URL
        homePageObjects.open(driver, "https://epam.github.io/JDI/index.html");
        //2. Assert Browser title
        homePageObjects.checkTitle(this.driver);

        //3. Perform login
        homePageObjects.login("epam", "1234");

        //4. Assert User Name
        homePageObjects.checkUserName("PITER CHAILOVSKII");

        //5. Asset Assert Browser title
        homePageObjects.checkTitle(this.driver);

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        homePageObjects.checkHeaderSectionItems();

        //7. Assert that there are 4 icons(images) on the Index Page and they are displayed
        homePageObjects.checkIcons();

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePageObjects.checkIconsTexts();

        //9. Assert a text of the main header
        homePageObjects.checkMainHeader("EPAM FRAMEWORK WISHES…");

        //10. The iframe exists
        homePageObjects.checkIframe();

        //11. The logo exists
        homePageObjects.checkLogo(driver);

        //12. Driver has focus on the original window
        homePageObjects.switchFrame(driver);

        //13. Assert a text of the sub header
        homePageObjects.checkSubHeader("JDI GITHUB");

        //14. Assert that JDI GITHUB is a link and has a proper URL
        homePageObjects.checkSubHeaderLink();

        //15. Assert that there is Left Section
        homePageObjects.checkLeftSection();

        //16. Assert that there is Footer
        homePageObjects.checkFooter();

        //17. Close Browser
        homePageObjects.driverClose(driver);

    }
}

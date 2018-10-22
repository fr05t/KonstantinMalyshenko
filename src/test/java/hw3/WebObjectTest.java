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
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI/index.html");

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
        List<WebElement> iconElemets = driver.findElements(By.xpath("//span[contains(@class, 'icons-benefit')]"));
        Assert.assertEquals(iconElemets.size(), 4);
        for (WebElement elm : iconElemets) {
            Assert.assertTrue(elm.isDisplayed());
        }

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> iconElemnts = driver.findElements(By.className("benefit-txt"));
        Assert.assertEquals(iconElemets.size(), 4);
        List<String> expectedText = new ArrayList<String>();

        expectedText.add("To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        expectedText.add("To be flexible and\n" +
                "customizable");
        expectedText.add("To be multiplatform");
        expectedText.add("Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        for (WebElement elm : iconElemnts) {
            Assert.assertTrue(elm.isDisplayed());
            Assert.assertTrue(expectedText.contains(elm.getText()));
        }


        //9. Assert a text of the main header
        Assert.assertEquals(driver.findElement(By.cssSelector("[name = 'main-title']")).getText(), "EPAM FRAMEWORK WISHES…");

        //10. The iframe exists
        Assert.assertTrue(driver.findElement(By.tagName("iframe")).isDisplayed());

        //11. The logo exists
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        Assert.assertTrue(driver.findElement(By.cssSelector("[id = 'epam_logo']")).isDisplayed());

        //12. Driver has focus on the original window
        driver.switchTo().defaultContent();

        //13. Assert a text of the sub header
        Assert.assertEquals(driver.findElement(By.cssSelector("[target = '_blank']")).getText(), "JDI GITHUB");

        //14. Assert that JDI GITHUB is a link and has a proper URL
        Assert.assertEquals(driver.findElement(By.linkText("JDI GITHUB")).getAttribute("href"), "https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        Assert.assertTrue(driver.findElement(By.cssSelector("[name = 'navigation-sidebar']")).isDisplayed());

        //16. Assert that there is Footer
        Assert.assertTrue(driver.findElement(By.cssSelector("[class = 'footer-content overflow']")).isDisplayed());

        //17. Close Browser
        driver.close();

    }
}

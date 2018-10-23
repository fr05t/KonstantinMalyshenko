package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.setProperty;

public class SoftAssertTest {

    @Test
    public void homePageTests() {

        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

        SoftAssert softAssert = new SoftAssert();

        //Create driver
        WebDriver webDriver = new ChromeDriver();
        //Maximize window
        webDriver.manage().window().maximize();
        //1. Open test site by URL
        webDriver.navigate().to("https://epam.github.io/JDI/index.html");

        //2. Assert Browser title
        softAssert.assertEquals(webDriver.getTitle(), "Home Page");

        //3. Perform login
        webDriver.findElement(By.cssSelector(".profile-photo")).click();
        webDriver.findElement(By.cssSelector("[id = 'Name']")).sendKeys("epam");
        webDriver.findElement(By.cssSelector("[id = 'Password']")).sendKeys("1234");
        webDriver.findElement(By.cssSelector(".login [ type = 'submit']")).click();

        //4. Assert User name in the left-top side of screen that user is loggined
        WebElement element = webDriver.findElement(By.cssSelector(".profile-photo [ui = 'label']"));
        softAssert.assertEquals(element.getText(), "PITER CHAILOVSKII");

        //5. Asset Assert Browser title
        softAssert.assertEquals(webDriver.getTitle(), "Home Page");

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<String> expectedMenuButtons = new ArrayList<String>();
        expectedMenuButtons.add("CONTACT FORM");
        expectedMenuButtons.add("HOME");
        expectedMenuButtons.add("SERVICE");
        expectedMenuButtons.add("METALS & COLORS");

        WebElement mainMenu = webDriver.findElement(By.cssSelector("[class = 'uui-navigation nav navbar-nav m-l8']"));
        List<WebElement> elements = mainMenu.findElements(By.xpath("//*[@class = 'uui-navigation nav navbar-nav m-l8']/li"));
        softAssert.assertEquals(elements.size(), 4);

        for (WebElement elm : elements) {
            softAssert.assertTrue(expectedMenuButtons.contains(elm.getText()));
        }

        //7. Assert that there are 4 icons(images) on the Index Page and they are displayed
        List<WebElement> iconElemets = webDriver.findElements(By.xpath(".//span[contains(@class, 'icons-benefit')]"));
        softAssert.assertEquals(iconElemets.size(), 4);
        for (WebElement elm : iconElemets) {
            softAssert.assertTrue(elm.isDisplayed());
        }

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> iconElemnts = webDriver.findElements(By.className("benefit-txt"));
        List<String> expectedText = new ArrayList<String>();
        softAssert.assertEquals(iconElemets.size(), 4);

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
            softAssert.assertTrue(elm.isDisplayed());
            softAssert.assertTrue(expectedText.contains(elm.getText()));
        }

        //9. Assert a text of the main header
        softAssert.assertEquals(webDriver.findElement(By.cssSelector("[name = 'main-title']")).getText(), "EPAM FRAMEWORK WISHES…");

        //10. Assertthat there is the iframe in the center of page
        softAssert.assertTrue(webDriver.findElement(By.tagName("iframe")).isDisplayed());

        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        webDriver.switchTo().frame(webDriver.findElement(By.tagName("iframe")));
        softAssert.assertTrue(webDriver.findElement(By.cssSelector("[id = 'epam_logo']")).isDisplayed());

        //12. Driver has focus on the original window
        webDriver.switchTo().defaultContent();

        //13. Assert a text of the sub header
        softAssert.assertEquals(webDriver.findElement(By.cssSelector("[target = '_blank']")).getText(), "JDI GITHUB");

        //14. Assert that JDI GITHUB is a link and has a proper URL
        softAssert.assertEquals(webDriver.findElement(By.linkText("JDI GITHUB")).getAttribute("href"), "https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        softAssert.assertTrue(webDriver.findElement(By.cssSelector("[name = 'navigation-sidebar']")).isDisplayed());

        //16. Assert that there is Footer
        softAssert.assertTrue(webDriver.findElement(By.cssSelector("[class = 'footer-content overflow']")).isDisplayed());
        softAssert.assertAll();
        //17. Close Browser
        webDriver.close();
    }
}

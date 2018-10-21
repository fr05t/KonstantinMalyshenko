package hw2.ex2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;

public class SmokeTestGroup {

    @Test(groups = "Smoke")
    public void Test1() {

        SoftAssert softAssert = new SoftAssert();

        //Initialize chrome driver
        WebDriver webDriver = new ChromeDriver();

        //Maximize windows
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

        //4. Assert User Name
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

        for(WebElement elm : elements) {
            softAssert.assertTrue(expectedMenuButtons.contains(elm.getText()));
        }

        softAssert.assertEquals(elements.size(), 4);

        //7. Assert that there are 4 icons(images) on the Index Page and they are displayed

        List<WebElement> iconElemets = webDriver.findElements(By.xpath(".//span[contains(@class, 'icons-benefit')]"));
        for(WebElement elm : iconElemets) {
            softAssert.assertTrue(elm.isDisplayed());
        }
        softAssert.assertEquals(iconElemets.size(), 4);

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> iconElemnts = webDriver.findElements(By.className("benefit-txt"));
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

        for(WebElement elm : iconElemnts) {
            softAssert.assertTrue(elm.isDisplayed());
            softAssert.assertTrue(expectedText.contains(elm.getText()));
        }

        softAssert.assertEquals(iconElemets.size(), 4);

        //9. Assert a text of the main header
        softAssert.assertTrue(webDriver.findElement(By.cssSelector("[name = 'main-title']")).isDisplayed());
        softAssert.assertEquals(webDriver.findElement(By.cssSelector("[name = 'main-title']")).getText(), "EPAM FRAMEWORK WISHES…");


        //10. The iframe exists
        softAssert.assertTrue(webDriver.findElement(By.tagName("iframe")).isDisplayed());

        //11. The logo exists
        webDriver.switchTo().frame(webDriver.findElement(By.tagName("iframe")));
        softAssert.assertTrue(webDriver.findElement(By.cssSelector("[id = 'epam_logo']")).isDisplayed());

        //12. Driver has focus on the original window
        webDriver.switchTo().defaultContent();

        //13. Assert a text of the sub header
        softAssert.assertTrue(webDriver.findElement(By.cssSelector("[target = '_blank']")).isDisplayed());
        softAssert.assertEquals(webDriver.findElement(By.cssSelector("[target = '_blank']")).getText(), "JDI GITHUB");

        //14. Assert that JDI GITHUB is a link and has a proper URL
        softAssert.assertTrue(webDriver.findElement(By.linkText("JDI GITHUB")).isDisplayed());
        softAssert.assertEquals(webDriver.findElement(By.linkText("JDI GITHUB")).getAttribute("href"), "https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        softAssert.assertTrue(webDriver.findElement(By.cssSelector("[name = 'navigation-sidebar']")).isDisplayed());

        //16. Assert that there is Footer
        softAssert.assertTrue(webDriver.findElement(By.cssSelector("[class = 'footer-content overflow']")).isDisplayed());
        softAssert.assertAll();
        //17. Close Browser
        webDriver.close();

        softAssert.assertAll();
    }

    @Test(groups = "Smoke")
    public void Test2() {

        SoftAssert softAssert = new SoftAssert();

        //Initialize chrome driver
        WebDriver webDriver = new ChromeDriver();

        //Maximize windows
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

        //4. Assert User Name
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

        for(WebElement elm : elements) {
            softAssert.assertTrue(expectedMenuButtons.contains(elm.getText()));
        }

        softAssert.assertEquals(elements.size(), 4);

        //7. Assert that there are 4 icons(images) on the Index Page and they are displayed

        List<WebElement> iconElemets = webDriver.findElements(By.xpath(".//span[contains(@class, 'icons-benefit')]"));
        for(WebElement elm : iconElemets) {
            softAssert.assertTrue(elm.isDisplayed());
        }
        softAssert.assertEquals(iconElemets.size(), 4);

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> iconElemnts = webDriver.findElements(By.className("benefit-txt"));
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

        for(WebElement elm : iconElemnts) {
            softAssert.assertTrue(elm.isDisplayed());
            softAssert.assertTrue(expectedText.contains(elm.getText()));
        }

        softAssert.assertEquals(iconElemets.size(), 4);

        //9. Assert a text of the main header
        softAssert.assertTrue(webDriver.findElement(By.cssSelector("[name = 'main-title']")).isDisplayed());
        softAssert.assertEquals(webDriver.findElement(By.cssSelector("[name = 'main-title']")).getText(), "EPAM FRAMEWORK WISHES…");


        //10. The iframe exists
        softAssert.assertTrue(webDriver.findElement(By.tagName("iframe")).isDisplayed());

        //11. The logo exists
        webDriver.switchTo().frame(webDriver.findElement(By.tagName("iframe")));
        softAssert.assertTrue(webDriver.findElement(By.cssSelector("[id = 'epam_logo']")).isDisplayed());

        //12. Driver has focus on the original window
        webDriver.switchTo().defaultContent();

        //13. Assert a text of the sub header
        softAssert.assertTrue(webDriver.findElement(By.cssSelector("[target = '_blank']")).isDisplayed());
        softAssert.assertEquals(webDriver.findElement(By.cssSelector("[target = '_blank']")).getText(), "JDI GITHUB");

        //14. Assert that JDI GITHUB is a link and has a proper URL
        softAssert.assertTrue(webDriver.findElement(By.linkText("JDI GITHUB")).isDisplayed());
        softAssert.assertEquals(webDriver.findElement(By.linkText("JDI GITHUB")).getAttribute("href"), "https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        softAssert.assertTrue(webDriver.findElement(By.cssSelector("[name = 'navigation-sidebar']")).isDisplayed());

        //16. Assert that there is Footer
        softAssert.assertTrue(webDriver.findElement(By.cssSelector("[class = 'footer-content overflow']")).isDisplayed());
        softAssert.assertAll();
        //17. Close Browser
        webDriver.close();

        softAssert.assertAll();
    }

    @Test(groups = "Smoke")
    public void Test3() {

        SoftAssert softAssert = new SoftAssert();

        //Initialize chrome driver
        WebDriver webDriver = new ChromeDriver();

        //Maximize windows
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

        //4. Assert User Name
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

        for(WebElement elm : elements) {
            softAssert.assertTrue(expectedMenuButtons.contains(elm.getText()));
        }

        softAssert.assertEquals(elements.size(), 4);

        //7. Assert that there are 4 icons(images) on the Index Page and they are displayed

        List<WebElement> iconElemets = webDriver.findElements(By.xpath(".//span[contains(@class, 'icons-benefit')]"));
        for(WebElement elm : iconElemets) {
            softAssert.assertTrue(elm.isDisplayed());
        }
        softAssert.assertEquals(iconElemets.size(), 4);

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> iconElemnts = webDriver.findElements(By.className("benefit-txt"));
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

        for(WebElement elm : iconElemnts) {
            softAssert.assertTrue(elm.isDisplayed());
            softAssert.assertTrue(expectedText.contains(elm.getText()));
        }

        softAssert.assertEquals(iconElemets.size(), 4);

        //9. Assert a text of the main header
        softAssert.assertTrue(webDriver.findElement(By.cssSelector("[name = 'main-title']")).isDisplayed());
        softAssert.assertEquals(webDriver.findElement(By.cssSelector("[name = 'main-title']")).getText(), "EPAM FRAMEWORK WISHES…");


        //10. The iframe exists
        softAssert.assertTrue(webDriver.findElement(By.tagName("iframe")).isDisplayed());

        //11. The logo exists
        webDriver.switchTo().frame(webDriver.findElement(By.tagName("iframe")));
        softAssert.assertTrue(webDriver.findElement(By.cssSelector("[id = 'epam_logo']")).isDisplayed());

        //12. Driver has focus on the original window
        webDriver.switchTo().defaultContent();

        //13. Assert a text of the sub header
        softAssert.assertTrue(webDriver.findElement(By.cssSelector("[target = '_blank']")).isDisplayed());
        softAssert.assertEquals(webDriver.findElement(By.cssSelector("[target = '_blank']")).getText(), "JDI GITHUB");

        //14. Assert that JDI GITHUB is a link and has a proper URL
        softAssert.assertTrue(webDriver.findElement(By.linkText("JDI GITHUB")).isDisplayed());
        softAssert.assertEquals(webDriver.findElement(By.linkText("JDI GITHUB")).getAttribute("href"), "https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        softAssert.assertTrue(webDriver.findElement(By.cssSelector("[name = 'navigation-sidebar']")).isDisplayed());

        //16. Assert that there is Footer
        softAssert.assertTrue(webDriver.findElement(By.cssSelector("[class = 'footer-content overflow']")).isDisplayed());
        softAssert.assertAll();
        //17. Close Browser
        webDriver.close();

        softAssert.assertAll();
    }
}

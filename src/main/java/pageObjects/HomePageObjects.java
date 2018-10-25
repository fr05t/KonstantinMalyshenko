package pageObjects;

import com.codeborne.selenide.impl.WebElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.nio.file.WatchEvent;
import java.util.ArrayList;
import java.util.List;

public class HomePageObjects {

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "#Name")
    private WebElement login;

    @FindBy(css = "#Password")
    private WebElement password;

    @FindBy(css = ".login [ type = 'submit'")
    private WebElement submit;

    @FindBy(css = ".profile-photo [ui = 'label']")
    private WebElement userName;

    @FindBy(css = ".uui-navigation.nav.navbar-nav.m-l8 > li")
    private List<WebElement> navigationItems;

    @FindBy(xpath = "//span[contains(@class, 'icons-benefit')]")
    private List<WebElement> icons;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> iconTexts;

    @FindBy(css = "[name = 'main-title']")
    private WebElement mainHeader;

    @FindBy(css = "iframe")
    private WebElement iframe;

    @FindBy(css = "#epam_logo")
    private WebElement epamLogo;

    @FindBy(css = "[target = '_blank']")
    private WebElement subHeader;

    @FindBy(css = "[name = 'navigation-sidebar']")
    private WebElement leftSection;

    @FindBy(css = ".footer-content")
    private WebElement footer;

    @FindBy(xpath = "//h3[@class='text-center']/a")
    private WebElement subHeaderLink;

    //================================methods===================================

    //1. Open url
    public void open(WebDriver driver, String url) {
        driver.navigate().to(url);
    }

    //3. Perform login
    public void login(String name, String password) {
        profileButton.click();
        login.sendKeys(name);
        this.password.sendKeys(password);
        submit.click();
    }

    //12. Switch to original window back
    public void switchFrame(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    //close browser
    public void driverClose(WebDriver driver) {
        driver.close();
    }


    //================================Asserts===================================

    //2, 5 Assert Browser title
    public void checkTitle(WebDriver driver) {
        Assert.assertEquals(driver.getTitle(), "Home Page");
    }

    //4. Assert Browser title
    public void checkUserName(String userName) {
        Assert.assertEquals(this.userName.getText(), userName);
    }

    //6. Assert that there are 4 items on the header section are displayed and they have proper texts
    public void checkHeaderSectionItems() {

        List<String> expectedMenuButtons = new ArrayList<String>();
        expectedMenuButtons.add("CONTACT FORM");
        expectedMenuButtons.add("HOME");
        expectedMenuButtons.add("SERVICE");
        expectedMenuButtons.add("METALS & COLORS");

        for (WebElement elm : navigationItems) {
            Assert.assertTrue(expectedMenuButtons.contains(elm.getText()));
        }

        Assert.assertEquals(navigationItems.size(), 4);
    }

    //7. Assert that there are 4 images on the Index Page and they are displayed
    public void checkIcons() {

        Assert.assertEquals(icons.size(), 4);

        for (WebElement icon : icons) {
            Assert.assertTrue(icon.isDisplayed());
        }
    }

    //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
    public void checkIconsTexts() {

        Assert.assertEquals(iconTexts.size(), 4);

        List<String> expectedTexts = new ArrayList<String>();
        expectedTexts.add("To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        expectedTexts.add("To be flexible and\n" +
                "customizable");
        expectedTexts.add("To be multiplatform");
        expectedTexts.add("Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        for (WebElement iconText : iconTexts) {
            Assert.assertTrue(expectedTexts.contains(iconText.getText()));
        }
    }

    //9. Assert a text of the main header
    public void checkMainHeader(String expectedHeaher) {
        Assert.assertEquals(mainHeader.getText(), expectedHeaher);
    }

    //10. Assertthat there is the iframe in the center of page
    public void checkIframe() {
        Assert.assertTrue(iframe.isDisplayed());
    }

    //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
    public void checkLogo(WebDriver driver) {
        driver.switchTo().frame(iframe);
        Assert.assertTrue(epamLogo.isDisplayed());

    }

    //13. Assert a text of the sub header
    public void checkSubHeader(String subHeaderText) {
        Assert.assertEquals(subHeader.getText(), subHeaderText);
    }

    //14. Assert that JDI GITHUB is a link and has a proper URL
    public void checkSubHeaderLink() {
        Assert.assertEquals(subHeaderLink.getAttribute("href"), "https://github.com/epam/JDI");
    }

    //15. Assert that there is Left Section
    public void checkLeftSection() {
        Assert.assertTrue(leftSection.isDisplayed());
    }

    //16. Assert that there is Footer
    public void checkFooter() {
        Assert.assertTrue(footer.isDisplayed());
    }


}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    public void open(WebDriver driver, String url) {
        driver.navigate().to(url);
    }

    public void login(String name, String password) {
        profileButton.click();
        login.sendKeys(name);
        this.password.sendKeys(password);
        submit.click();
    }

    public void switchFrame(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void driverClose(WebDriver driver) {
        driver.close();
    }


    //================================Asserts===================================

    public void checkTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), "Home Page");
    }

    public void checkUserName(String userName) {
        assertEquals(this.userName.getText(), userName);
    }

    public void checkHeaderSectionItems() {

        List<String> expectedMenuButtons = new ArrayList<String>();
        expectedMenuButtons.add("CONTACT FORM");
        expectedMenuButtons.add("HOME");
        expectedMenuButtons.add("SERVICE");
        expectedMenuButtons.add("METALS & COLORS");

        for (WebElement elm : navigationItems) {
            assertTrue(expectedMenuButtons.contains(elm.getText()));
        }

        assertEquals(navigationItems.size(), 4);
    }

    public void checkIcons() {

        assertEquals(icons.size(), 4);

        for (WebElement icon : icons) {
            assertTrue(icon.isDisplayed());
        }
    }

    public void checkIconsTexts() {

        assertEquals(iconTexts.size(), 4);

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
            assertTrue(expectedTexts.contains(iconText.getText()));
        }
    }

    public void checkMainHeader(String expectedHeaher) {
        assertEquals(mainHeader.getText(), expectedHeaher);
    }

    public void checkIframe() {
        assertTrue(iframe.isDisplayed());
    }

    public void checkLogo(WebDriver driver) {
        driver.switchTo().frame(iframe);
        assertTrue(epamLogo.isDisplayed());

    }

    public void checkSubHeader(String subHeaderText) {
        assertEquals(subHeader.getText(), subHeaderText);
    }

    public void checkSubHeaderLink() {
        assertEquals(subHeaderLink.getAttribute("href"), "https://github.com/epam/JDI");
    }

    public void checkLeftSection() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkFooter() {
        assertTrue(footer.isDisplayed());
    }

}

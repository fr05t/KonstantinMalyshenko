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

public class HWHomePage {

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private WebElement login;

    @FindBy(css = "[id = 'Password']")
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

    @FindBy(css = "[id = 'epam_logo']")
    private WebElement epamLogo;

    @FindBy(css = "[target = '_blank']")
    private WebElement subHeader;

    @FindBy(css = "[name = 'navigation-sidebar']")
    private WebElement leftSection;

    @FindBy(css = "[class = 'footer-content overflow")
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
        Assert.assertEquals(driver.getTitle(), "Home Page");
    }

    public void checkUserName(String userName) {
        Assert.assertEquals(this.userName.getText(), userName);
    }

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

    public void checkIcons() {

        Assert.assertEquals(icons.size(), 4);

        for (WebElement icon : icons) {
            Assert.assertTrue(icon.isDisplayed());
        }
    }

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

        for(WebElement iconText : iconTexts) {
            Assert.assertTrue(expectedTexts.contains(iconText.getText()));
        }
    }

    public void checkMainHeader(String expectedHeaher) {
        Assert.assertEquals(mainHeader.getText(), expectedHeaher);
    }

    public void checkIframe() {
        Assert.assertTrue(iframe.isDisplayed());
    }

    public void checkLogo(WebDriver driver) {
        driver.switchTo().frame(iframe);
        Assert.assertTrue(epamLogo.isDisplayed());

    }

    public void checkSubHeader(String subHeaderText) {
        Assert.assertEquals(subHeader.getText(), subHeaderText);
    }

    public void checkLeftSection() {
        Assert.assertTrue(leftSection.isDisplayed());
    }

    public void checkFooter() {
        Assert.assertTrue(footer.isDisplayed());
    }

    public void checkSubHeaderLink() {
        Assert.assertEquals(subHeaderLink.getAttribute("href"), "https://github.com/epam/JDI");
    }
}

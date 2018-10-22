package pageObjects;

import com.codeborne.selenide.impl.WebElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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

    //================================methods===================================

    private void open(WebDriver driver) {
        driver.get("");
    }

    public void login(String name, String password) {
        profileButton.click();
        login.sendKeys(name);
        this.password.sendKeys(password);
        submit.click();
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

}

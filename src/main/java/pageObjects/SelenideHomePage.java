package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideHomePage {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = "[type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = "span[ui = 'label']")
    private SelenideElement userName;

    @FindBy(xpath = "//a[@class = 'dropdown-toggle'][contains(.,'Service')]")
    private SelenideElement serviceDropdownMenu;

    @FindBy(css = ".dropdown-menu > li")
    private ElementsCollection serviceDropdownMenuItems;

    @FindBy(css = ".menu-title[index = '3']")
    private SelenideElement serviceLeftMenu;

    @FindBy(css = ".menu-title[index = '3'] .sub > li")
    private ElementsCollection leftServiceMenuItems;





    //================================methods===================================

    @Step("Login perform")
    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();
    }

    public void serviceDropDownListClick() {
        serviceDropdownMenu.click();
    }

    public void setServiceLeftMenuClick() {
        serviceLeftMenu.click();
    }

    //Open through the header menu Service -> Different Elements Page
    public void openDifferenElementsPage() {
        for (SelenideElement elm : serviceDropdownMenuItems) {
            if(elm.getText().equals("DIFFERENT ELEMENTS")) {
                elm.click();
                break;
            }
        }
    }

    //==========================Asserts==========================================

    //4. Assert User name in the left-top side of screen that user is loggined
    public void checkUserName() {
        $(userName.should(text("PITER CHAILOVSKI")));
    }

    public void checkServiceDropdownMenuSubcategory() {
        List<String> serviceDropdownMenuItems = new ArrayList();
        serviceDropdownMenuItems.add("SUPPORT");
        serviceDropdownMenuItems.add("DATES");
        serviceDropdownMenuItems.add("COMPLEX TABLE");
        serviceDropdownMenuItems.add("SIMPLE TABLE");
        serviceDropdownMenuItems.add("USER TABLE");
        serviceDropdownMenuItems.add("TABLE WITH PAGES");
        serviceDropdownMenuItems.add("DIFFERENT ELEMENTS");
        serviceDropdownMenuItems.add("PERFORMANCE");

        for(SelenideElement elm : this.serviceDropdownMenuItems) {
            Assert.assertTrue(serviceDropdownMenuItems.contains(elm.getText()));
        }
    }
    //6. Click on Service subcategory in the left section and check that drop down contains options
    public void checkLeftServiceMenuItems() {
        List<String> serviceDropdownMenuItems = new ArrayList();
        serviceDropdownMenuItems.add("Support");
        serviceDropdownMenuItems.add("Dates");
        serviceDropdownMenuItems.add("Complex Table");
        serviceDropdownMenuItems.add("Simple Table");
        serviceDropdownMenuItems.add("User Table");
        serviceDropdownMenuItems.add("Table with pages");
        serviceDropdownMenuItems.add("Different elements");
        serviceDropdownMenuItems.add("Performance");

        for(SelenideElement elm : leftServiceMenuItems) {
            Assert.assertTrue(serviceDropdownMenuItems.contains(elm.getText()));
        }
    }



}

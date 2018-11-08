package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.PageTitles;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.base.CommonBaseElements;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static enums.PageTitles.*;

public class SelenideHomePage extends CommonBaseElements {


    @FindBy(css = "span[ui = 'label']")
    private SelenideElement userName;

    @FindBy(xpath = "//a[@class = 'dropdown-toggle'][contains(.,'Service')]")
    private SelenideElement serviceDropdownMenu;

    @FindBy(xpath = "//a[@class = 'dropdown-toggle'][contains(.,'Dates')]")
    private SelenideElement datesDropdownMenu;

    @FindBy(css = ".dropdown-menu > li")
    private ElementsCollection serviceDropdownMenuItems;

    @FindBy(css = ".menu-title[index = '3']")
    private SelenideElement serviceLeftMenu;

    @FindBy(css = ".menu-title[index = '3'] .sub > li")
    private ElementsCollection leftServiceMenuItems;


    //================================methods===================================


    @Step("Click on Service dropdown Menu")
    public void serviceDropDownListClick() {
        serviceDropdownMenu.click();
    }

    @Step("Click ")
    public void setServiceLeftMenuClick() {
        serviceLeftMenu.click();
    }

    //Open through the header menu Service -> Different Elements Page
    public void openDifferenElementsPage() {
        serviceDropdownMenuItems.find(Condition.text(DIFFERENT_ELEMENTS.getTitle())).click();
    }

    public void openDatesPage() {
            serviceDropdownMenuItems.find(Condition.text(DATES.getTitle())).click();
    }

    //==========================Asserts==========================================


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

        this.serviceDropdownMenuItems.texts().containsAll(serviceDropdownMenuItems);
    }

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

        for (SelenideElement elm : leftServiceMenuItems) {
            Assert.assertTrue(serviceDropdownMenuItems.contains(elm.getText()));
        }
    }

}

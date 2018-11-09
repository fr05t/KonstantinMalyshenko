package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.SubMenuItems;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import pageObjects.base.CommonBaseElements;

import static enums.PageTitles.DATES;
import static enums.PageTitles.DIFFERENT_ELEMENTS;
import static enums.Users.PITER_CHALOVSKII;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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
        assertEquals(userName.getText(), PITER_CHALOVSKII.getUsername());
    }

    public void checkServiceDropdownMenuSubcategory() {
        assertTrue(this.serviceDropdownMenuItems.texts().containsAll(SubMenuItems.getUpperCaseMenuItems()));
    }

    public void checkLeftServiceMenuItems() {
        assertTrue(leftServiceMenuItems.texts().containsAll(SubMenuItems.getLowerCaseMenuItems()));
    }

}

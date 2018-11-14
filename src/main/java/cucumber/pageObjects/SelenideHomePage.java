package cucumber.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.PageTitles;
import enums.URLs;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.PageTitles.DATES;
import static enums.PageTitles.DIFFERENT_ELEMENTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SelenideHomePage {

    public SelenideHomePage() {
        page(this);
    }

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

    @FindBy(xpath = "//a[@class = 'dropdown-toggle'][contains(.,'Dates')]")
    private SelenideElement datesDropdownMenu;

    @FindBy(css = ".dropdown-menu > li")
    private ElementsCollection serviceDropdownMenuItems;

    @FindBy(css = ".menu-title[index = '3']")
    private SelenideElement serviceLeftMenu;

    @FindBy(css = ".menu-title[index = '3'] .sub > li")
    private ElementsCollection leftServiceMenuItems;

    @FindBy(css = ".main-title")
    private SelenideElement headLine;

    @FindBy(css = ".main-txt.text-center")
    private SelenideElement descriprion;

    @FindBy(css = ".icons-benefit")
    private ElementsCollection pictures;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection picturTexts;


    //================================methods===================================

    @Step
    @When("I'm on the Home Page!")
    public void openPage() {
        open(URLs.HOME_PAGE_URL.getUrl());
    }


    @Step
    @Then("^The browser title is '(.*)'$")
    public void checkPageTitle(String pageTitles) {
        assertEquals(getWebDriver().getTitle(), PageTitles.HOME_PAGE.getTitle());
    }

    @Step
    @When("I login as user (.+) with password (.+)")
    public void login(String user, String passwd) {
        profileButton.click();
        login.sendKeys(user);
        password.sendKeys(passwd);
        submit.click();
    }

    @Then("I click on the Service in the header")
    @Step("Click on Service dropdown Menu")
    public void serviceDropDownListClick() {
        serviceDropdownMenu.click();
    }

    @Then("I click on the Service in the leftMenu")
    @Step("Click ")
    public void setServiceLeftMenuClick() {
        serviceLeftMenu.click();
    }

    @And("I open menu '(.*)'")
    @Step("Open through the header menu Service -> Different Elements Page")
    public void openDifferenElementsPage(String differentElements) {
        serviceDropdownMenuItems.find(Condition.text(differentElements)).click();
    }

    @Step("Open data page")
    public void openDatesPage() {
        serviceDropdownMenuItems.find(Condition.text(DATES.getTitle())).click();
    }

    //==========================Asserts==========================================

    @Step("Check username")
    @Then("The '(.*)' is displayed on the header")
    public void checkUserName(String user) {
        assertEquals(userName.getText(), user);
    }

    @When("Menu contains elements:")
    @Step("Check category from service dropdown menu")
    public void checkServiceDropdownMenuSubcategory(List<String> subMenuItems) {
        assertTrue(this.serviceDropdownMenuItems.texts().containsAll(subMenuItems));
    }

    @Then("Menu left menu contains elements:")
    @Step("Check left Service menu Items")
    public void checkLeftServiceMenuItems(List<String> leftMenuItems) {
        assertTrue(leftServiceMenuItems.texts().containsAll(leftMenuItems));
    }

    @And("Page contains all elements:")
    public void checkElements(Map<String, Integer> dataTable) {
        headLine.shouldBe(Condition.visible);
        descriprion.shouldBe(Condition.visible);

        pictures.shouldHaveSize(dataTable.get("pictures"));
        picturTexts.shouldHaveSize(dataTable.get("picturesTexts"));
    }

    @Then("'(.*)' is opened")
    @Step("Open page Different elements")
    public void chechDifferentElementPage(String title) {
        assertEquals(getWebDriver().getTitle(), title);
    }

}

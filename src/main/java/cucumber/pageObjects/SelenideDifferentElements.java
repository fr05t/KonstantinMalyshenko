package cucumber.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.PageTitles;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.LogItems.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SelenideDifferentElements {

    public SelenideDifferentElements() {
        page(this);
    }


    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkBoxItems;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioElements;

    @FindBy(css = "select.uui-form-element")
    private SelenideElement dropDownButton;

    @FindBy(css = "select.uui-form-element > option")
    private ElementsCollection dropDownList;

    @FindBy(css = ".main-content-hg .uui-button")
    private ElementsCollection buttons;

    @FindBy(css = ".uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar")
    private SelenideElement leftSection;

    @FindBy(css = ".uui-side-bar.right-fix-panel.mCustomScrollbar._mCS_2.mCS_no_scrollbar")
    private SelenideElement rightSection;

    @FindBy(css = ".panel-body-list.logs > li")
    private ElementsCollection logElements;


    //=================================methods===========================================

    @When("I check conditions:")
    @Step("Select checkboxes")
    public void selectCheckboxes(List<String> checkBoxItems) {

        for (String elm : checkBoxItems) {
            if (this.checkBoxItems.texts().contains(elm)) {
                this.checkBoxItems.find(Condition.text(elm)).click();
            }
        }
    }

    @When("I Select '(.*)'")
    @Step("Select radio element")
    public void selectRadioElement(String element) {
        for (SelenideElement elm : radioElements) {
            if (elm.getText().equals(element)) {
                elm.click();
            }
        }
    }

    @When("I Select from dropdown '(.*)'")
    @Step("Select dropdown element from list")
    public void selectDropdownElement(String color) {
        dropDownButton.click();
        for (SelenideElement elm : dropDownList) {
            if (elm.getText().equals(color)) {
                elm.click();
            }
        }
    }

    @Step("Get last event for metal")
    public String getButtonLog() {

        Pattern pattern = Pattern.compile(".+(metal).+(to )(.+)");
        Matcher matcher;

        for (int i = logElements.size() - 1; i >= 0; i--) {
            if (logElements.get(i).getText().contains(METAL.getValue())) {
                matcher = pattern.matcher(logElements.get(i).getText());
                matcher.find();
                return matcher.group(3);
            }
        }
        return "";
    }

    @Step("Get color log")
    public String getColorsLog() {
        String color = "";
        Pattern pattern = Pattern.compile("((\\d+:?)+)\\s(Colors).+to\\s(\\w+)");
        Matcher matcher;

        for (int i = 0; i < logElements.size(); i++) {
            if (logElements.get(i).getText().contains(COLORS.getValue())) {
                matcher = pattern.matcher(logElements.get(i).getText());
                matcher.find();
                color = matcher.group(4);
                return color;
            }
        }
        return color;
    }

    @Step("Get checkbox log")
    public List<String> getCheckboxLog(List<String> checkboxItems) {
        List checkboxLog = new ArrayList();
        for (int i = 0; i < checkboxItems.size(); i++) {
            checkboxLog.add(logElements.get(i).getText());
        }
        return checkboxLog;
    }

    //=================================Asserts==========================================

    @Then("Page contain this elements:")
    @Step("Check checkbox item")
    public void checkCheckBoxItems(Map<String, Integer> dataTable) {

        checkBoxItems.shouldHaveSize(dataTable.get("checkbox"));
        radioElements.shouldHaveSize(dataTable.get("radiobutton"));
        dropDownButton.shouldBe(visible);
        buttons.shouldHaveSize(dataTable.get("button"));
    }

    @And("Right section is displayed")
    @Step("Check right section")
    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    @And("Left section is displayed")
    @Step("Check left section")
    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Then("Selected metal is '(.*)'")
    @Step("Check radiobutton")
    public void checkRadioButton(String radioButtonItems) {
        assertEquals(radioButtonItems, getButtonLog());
    }

    @Then("Checked conditions are displayed:")
    @Step("Assert checked elements in log")
    public void checkCheckboxesLogTrue(List<String> checkboxItems) {

        boolean state = false;

        for (String elm : checkboxItems) {
            for (String elm2 : getCheckboxLog(checkboxItems)) {
                if (elm2.contains(elm) || elm2.contains(TRUE.getValue())) {
                    state = true;
                } else {
                    state = false;
                }
            }
        }
        assertTrue(state);
    }

    @When("Unchecked conditions are displayed:")
    @Step("Assert checked elements in log")
    public void checkCheckboxesLogFalse(List<String> checkboxItems) {

        boolean state = false;

        for (String elm : checkboxItems) {
            for (String elm2 : getCheckboxLog(checkboxItems)) {
                if (elm2.contains(elm) || elm2.contains(FALSE.getValue())) {
                    state = true;
                } else {
                    state = false;
                }
            }
        }
        assertTrue(state);
    }

    @Then("Selected color is '(.*)'")
    @Step("Check color log")
    public void checkColorLog(String dropDownMenuItems) {
        assertEquals(dropDownMenuItems, getColorsLog());
    }

    @Step("Check page is open")
    public void checkTitle(PageTitles pageTitle) {
        assertEquals(getWebDriver().getTitle(), pageTitle.getTitle());
    }

}

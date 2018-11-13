package cucumber.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.CheckboxItems;
import enums.DropDownMenuItems;
import enums.PageTitles;
import enums.RadioButtonItems;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
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


    @Step("Select checkboxes")
    public void selectCheckboxes(CheckboxItems... checkBoxItems) {

        for (CheckboxItems elm : checkBoxItems) {
            if (this.checkBoxItems.texts().contains(elm.getCheckboxItemName())) {
                this.checkBoxItems.find(Condition.text(elm.getCheckboxItemName())).click();
            }
        }
    }

    @Step("Select radio element")
    public void selectRadioElement(RadioButtonItems radioButtonItems) {
        for (SelenideElement elm : radioElements) {
            if (elm.getText().equals(radioButtonItems.getElement())) {
                elm.click();
            }
        }
    }

    @Step("Select dropdown element from list")
    public void selectDropdownElement(DropDownMenuItems color) {
        dropDownButton.click();
        for (SelenideElement elm : dropDownList) {
            if (elm.getText().equals(color.getColor())) {
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
    public List<String> getCheckboxLog(CheckboxItems... checkboxItems) {
        List checkboxLog = new ArrayList();
        for (int i = 0; i < checkboxItems.length; i++) {
            checkboxLog.add(logElements.get(i).getText());
        }
        return checkboxLog;
    }

    //=================================Asserts==========================================
    @Step("Check checkbox item")
    public void checkCheckBoxItems() {
        checkBoxItems.shouldHaveSize(4);
    }

    @Step("Check radio elements")
    public void checkRadioElements() {
        radioElements.shouldHaveSize(4);
    }

    @Step("Check dropdown button")
    public void checkDropdownButton() {
        dropDownButton.shouldBe(visible);
    }

    @Step("Check button quantity")
    public void checkButtons() {
        buttons.shouldHaveSize(2);
    }

    @Step("Check right section")
    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    @Step("Check left section")
    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Step("Check radiobutton")
    public void checkRadioButton(RadioButtonItems radioButtonItems) {
        assertEquals(radioButtonItems.getElement(), getButtonLog());
    }

    @Step("Assert checked elemnts in log")
    public void checkCheckboxesLogTrue(CheckboxItems... checkboxItems) {

        boolean state = false;
        for (CheckboxItems elm : checkboxItems) {
            for (String elm2 : getCheckboxLog(checkboxItems)) {
                if (elm2.contains(elm.getCheckboxItemName()) || elm2.contains(TRUE.getValue())) {
                    state = true;
                } else {
                    state = false;
                }
            }
        }
        assertTrue(state);
    }

    @Step("Assert checked elemnts in log")
    public void checkCheckboxesLogFalse(CheckboxItems... checkboxItems) {

        boolean state = false;
        for (CheckboxItems elm : checkboxItems) {
            for (String elm2 : getCheckboxLog(checkboxItems)) {
                if (elm2.contains(elm.getCheckboxItemName()) || elm2.contains(FALSE.getValue())) {
                    state = true;
                } else {
                    state = false;
                }
            }
        }
        assertTrue(state);
    }

    @Step("Check color log")
    public void checkColorLog(DropDownMenuItems dropDownMenuItems) {
        assertEquals(dropDownMenuItems.getColor(), getColorsLog());
    }

    @Step("Check page is open")
    public void checkTitle(PageTitles pageTitle) {
        assertEquals(getWebDriver().getTitle(), pageTitle.getTitle());
    }

}

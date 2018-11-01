package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.CheckboxItems;
import enums.DropDownMenuItems;
import enums.RadioButtonItems;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.checked;
import static com.codeborne.selenide.Condition.visible;
import static enums.DropDownMenuItems.Yellow;
import static org.testng.Assert.assertEquals;

public class SelenideDifferentElements {


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
            if (elm.getText().equals(radioButtonItems.toString())) {
                elm.click();
            }
        }
    }

    @Step("Select dropdown element from list")
    public void selectDropdownElement() {
        dropDownButton.click();
        for (SelenideElement elm : dropDownList) {
            if (elm.getText().equals(Yellow.toString())) {
                elm.click();
            }
        }
    }

    @Step("Get last event for metal")
    public String getButtonLog() {

        Pattern pattern = Pattern.compile(".+(metal).+(to )(.+)");
        Matcher matcher;

        for (int i = logElements.size() - 1; i >= 0; i--) {
            if (logElements.get(i).getText().contains("metal")) {
                matcher = pattern.matcher(logElements.get(i).getText());
                matcher.find();
                return matcher.group(3);
            }
        }
        return "";
    }

    public List<String> getMetalLog() {
        List<String> metalLog = new ArrayList<>();

        return metalLog;
    }

    public String getColorsLog() {
        String color = "";
        Pattern pattern = Pattern.compile("((\\d+:?)+)\\s(Colors).+to\\s(\\w+)");
        Matcher matcher;


        for (int i = 0; i < logElements.size(); i++) {
            if (logElements.get(i).getText().contains("Colors")) {
                matcher = pattern.matcher(logElements.get(i).getText());
                matcher.find();
                color = matcher.group(4);
                return color;
            }
        }
        return color;
    }

/*    public List<String> getConditionLog() {
        List<String> conditionLog = new ArrayList<>();



        Pattern pattern = Pattern.compile(" d");

        for(int i = logElements.size()-1; i >=0; i--) {
            if(logElements.)
        }


        return conditionLog;
    }*/


    //=================================Asserts==========================================

    public void checkCheckBoxItems() {
        checkBoxItems.shouldHaveSize(4);
    }

    public void checkRadioElements() {
        radioElements.shouldHaveSize(4);
    }

    public void checkDropdownButton() {
        dropDownButton.shouldBe(visible);
    }

    public void checkButtons() {
        buttons.shouldHaveSize(2);
    }

    public void checkRightSection() {
        rightSection.shouldBe(visible);
    }

    public void checkLeftSection() {
        leftSection.shouldBe(visible);
    }

    public void checkLogRows() {

    }

    public void checkRadioButton(RadioButtonItems radioButtonItems) {
        assertEquals(radioButtonItems.toString(), getButtonLog());
    }

    public void checkCheckboxesState(CheckboxItems... checkboxItems) {
        System.out.println(checkboxItems);
        for (CheckboxItems elm : checkboxItems) {
            if (this.checkBoxItems.texts().contains(elm.getCheckboxItemName())) {
                this.checkBoxItems.find(Condition.text(elm.getCheckboxItemName())).shouldBe(checked);
            }
        }
    }

    public void checkColorLog(DropDownMenuItems dropDownMenuItems) {
        assertEquals(dropDownMenuItems.getColor(), getColorsLog());
    }


}

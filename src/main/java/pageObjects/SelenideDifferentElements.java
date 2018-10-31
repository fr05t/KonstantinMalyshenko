package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.DropDownMenuItems;
import enums.RadioButtonItems;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static enums.DropDownMenuItems.*;
import static enums.RadioButtonItems.*;

public class SelenideDifferentElements {


    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkBoxItems;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioElemens;

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



    //=================================methods===========================================

    public void selecCheckboxes() {
        for(SelenideElement elm : checkBoxItems) {
            if(elm.getText().equals("Water") || elm.getText().equals("Wind")) {
                elm.click();
            }
        }
    }



    public void selectRadioElement() {
        for(SelenideElement elm : radioElemens) {
            if(elm.getText().equals(Selen)) {
                elm.click();
                elm.is(Condition.checked);
            }
        }
    }

    public void selectDropdownElement() {
        dropDownButton.click();
        for (SelenideElement elm : dropDownList) {
            if(elm.getText().equals(Yellow)) {
                elm.click();
            }
        }
    }

    public List<String> getButtonLog() {
        List<String> buttonLog = new ArrayList<>();
        return buttonLog;
    }

    public List<String> getMetalLog() {
        List<String> metalLog = new ArrayList<>();
        return metalLog;
    }

    public List<String> getColorsLog() {
        List<String> colorsLog = new ArrayList<>();
        return colorsLog;
    }

    public List<String> getConditionLog() {
        List<String> conditionLog = new ArrayList<>();
        return conditionLog;
    }


    //=================================Asserts==========================================

    public void checkCheckBoxItems() {
        checkBoxItems.shouldHaveSize(4);
    }

    public void checkRadioElements() {
        radioElemens.shouldHaveSize(4);
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

    public void checkRadioButton() {
        //Assert.assertEquals();
    }
}

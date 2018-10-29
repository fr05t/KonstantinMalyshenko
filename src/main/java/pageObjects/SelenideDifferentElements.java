package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.DropDownMenuItems;
import enums.RadioButtonItems;
import org.openqa.selenium.support.FindBy;


import static com.codeborne.selenide.Condition.*;

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



    public void seleRadioElement() {
        for(SelenideElement elm : radioElemens) {
            if(elm.getText().equals(RadioButtonItems.Selen)) {
                elm.click();
                elm.is(Condition.checked);
            }
        }
    }

    public void selectDropdownElement() {
        dropDownButton.click();
        for (SelenideElement elm : dropDownList) {
            if(elm.getText().equals(DropDownMenuItems.Yellow)) {
                elm.click();
            }
        }
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

}

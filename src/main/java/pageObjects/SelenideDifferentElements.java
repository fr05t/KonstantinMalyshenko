package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class SelenideDifferentElements {


    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkBoxItems;

    @FindBy(css = ".label-radio")
    private ElementsCollection radioElemens;

    @FindBy(css = "select.uui-form-element")
    private SelenideElement dropDownButton;

    @FindBy(css = ".main-content-hg .uui-button")
    private ElementsCollection buttons;

    //=================================methods===========================================



    //=================================Asserts==========================================

    public void checkCheckBoxItems() {
        checkBoxItems.shouldHaveSize(4);
    }

    public void checkRadioElements() {
        radioElemens.shouldHaveSize(4);
    }

    public void checkDropdownButton() {
        dropDownButton.shouldBe(Condition.visible);
    }

    public void checkButtons() {
        buttons.shouldHaveSize(2);
    }


}

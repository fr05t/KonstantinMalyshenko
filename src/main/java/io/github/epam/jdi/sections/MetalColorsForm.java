package io.github.epam.jdi.sections;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.core.interfaces.complex.IDropList;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.CheckBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropList;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import io.github.epam.jdi.enums.Colors;
import io.github.epam.jdi.enums.Elements;
import io.github.epam.jdi.enums.Metals;
import io.github.epam.jdi.enums.Vegetables;
import io.github.epam.jdi.jsonobjects.TestDataSet;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;


public class MetalColorsForm extends Form<TestDataSet> {

    //=============================Elemnts========================================
    @FindBy(css = "#calculate-button")
    private Button calculateButton;

    @FindBy(css = "#submit-button")
    private Button submitButton;


    @JFindBy(css = ".vertical-group > p")
    private List<CheckBox> chk;

    public ICheckList checkList = new CheckList();


    @JDropList(
            jroot = @JFindBy(xpath = ".salad"),
            jlist = @JFindBy(tagName = "li")
    )
    public IDropList<Vegetables> vegetablesList;

    @JFindBy(id = "salad-dropdown")
    public IButton button;

    @JDropdown(
            jroot = @JFindBy(css = ".colors"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".filter-option")
    )
    public IDropDown<Colors> color;

    @JDropdown(
            jroot = @JFindBy(css = ".salad.dropdown"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".caret"))
    private IDropDown<Vegetables> vegetables;

    // @FindBy(css = "input[type=text] + select > option")
    @JDropdown(
            jroot = @JFindBy(css = ".open .dropdown-menu.open .dropdown-menu.inner.selectpicker"),
            jlist = @JFindBy(css = "li"),
            jvalue = @JFindBy(css = ".filter-option.pull-left"))
    private IDropDown<Metals> metals;

    @JFindBy(css = ".form-group.metals .btn .caret")
    private IButton metalListButton;

    @FindBy(css = "#odds-selector > p")
    private RadioButtons oddsRadioButtob;

    @FindBy(css = "#even-selector > p")
    private RadioButtons evenRadioButtob;

    @JFindBy(css = ".info-panel-section .checkbox")
    private ICheckList<Elements> elements;

    //==================================Methods==============================================
    @Step
    // TODO Where is the FORM ? It should be HERE, In this class !!
    // TODO Site consist of the pages, pages consist of the elements and FORMS, FORMS consist of elements ...
    public void fillForm(TestDataSet testData) {

        selectColor(testData.getColor());
        selectVegetables(testData.getVegetables());

        selectOddsElement(testData.getSummary().get(0));
        selectEvenElement(testData.getSummary().get(1));


        clickCalculateButton();
        selectMetal(testData.getMetals());
        selectElementCheckbox(testData.getElements());

    }


    public void selectColor(String color) {
        this.color.select(color);
    }

    public void clickCalculateButton() {
        calculateButton.click();
    }

    @Step
    public void clickSubmitButton() {
        submitButton.click();
    }

    public void selectOddsElement(String odd) {
        oddsRadioButtob.select(odd);

    }

    public void selectEvenElement(String even) {
        evenRadioButtob.select(even);
    }

    public void selectElementCheckbox(ArrayList<String> elements) {
        for (String elm : elements) {
            this.elements.check(elm);
        }

    }


    public void selectMetal(String metal) {

        metalListButton.click();
        metals.select(metal);
    }


    public void selectVegetables(ArrayList<String> salad) {
        button.click();
        //Uncheck default calue
        vegetables.select(Vegetables.Vegetables);

        //Ckeck values from dataset
        for (String elm : salad) {
            vegetables.select(elm);
        }
    }
}

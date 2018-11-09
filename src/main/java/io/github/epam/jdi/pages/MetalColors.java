package io.github.epam.jdi.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.complex.ICheckList;
import com.epam.jdi.uitests.core.interfaces.complex.IDropDown;
import com.epam.jdi.uitests.core.interfaces.complex.IDropList;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.CheckBox;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropList;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import io.github.epam.jdi.enums.Colors;
import io.github.epam.jdi.enums.Elements;
import io.github.epam.jdi.enums.Metals;
import io.github.epam.jdi.enums.Vegetables;
import io.github.epam.jdi.jsonobjects.PageParameters;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static io.github.epam.jdi.JDIExampleSite.metalColors;

@JPage(url = "/metal-colors.html", title = "Metal and Colors")
public class MetalColors extends WebPage {

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
    public IDropList vegetablesList;

    @JFindBy(id = "salad-dropdown")
    public IButton button;

    @JDropdown(
            jroot = @JFindBy(css = ".colors"),
            jlist = @JFindBy(tagName = "li"),
            jvalue = @JFindBy(css = ".filter-option")
    )
    public IDropDown<Colors> colors;

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
    private IDropDown<Metals> metalsList;

    @JFindBy(css = ".form-group.metals .btn .caret")
    private IButton metalListButton;

    @FindBy(css = "#odds-selector > p")
    private RadioButtons oddsRadioButtob;

    @FindBy(css = "#even-selector > p")
    private RadioButtons evenRadioButtob;

    @JFindBy(css = ".info-panel-section .checkbox")
    private ICheckList<Elements> elementCheckbox;


    //===================================Methods==========================================

    public void selectColor(String color) {
        colors.select(color);
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
            elementCheckbox.check(elm);
        }

    }


    public void selectMetal(String metal) {

        metalListButton.click();
        metalsList.select(metal);
    }

    @Step
    public void fillForm(PageParameters pageParameters) {

        metalColors.selectColor(pageParameters.getColor());
        metalColors.selectVegetables(pageParameters.getVegetables());

        metalColors.selectOddsElement(pageParameters.getSummary().get(0));
        metalColors.selectEvenElement(pageParameters.getSummary().get(1));


        metalColors.clickCalculateButton();
        metalColors.selectMetal(pageParameters.getMetals());
        metalColors.selectElementCheckbox(pageParameters.getElements());

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

    //==================================Asserts===============================================
}

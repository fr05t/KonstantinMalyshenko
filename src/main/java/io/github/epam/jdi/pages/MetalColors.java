package io.github.epam.jdi.pages;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import io.github.epam.jdi.jsonobjects.MetalsColorsDataSet;
import ru.yandex.qatools.allure.annotations.Step;

import static io.github.epam.jdi.JDIExampleSite.mainContentForm;

@JPage(url = "/metal-colors.html", title = "Metal and Colors")
public class MetalColors extends WebPage {


    //==================================Methods==============================================
    @Step
    public void fillForm(MetalsColorsDataSet metalsColorsDataSet) {

        mainContentForm.selectColor(metalsColorsDataSet.getColor());
        mainContentForm.selectVegetables(metalsColorsDataSet.getVegetables());

        mainContentForm.selectOddsElement(metalsColorsDataSet.getSummary().get(0));
        mainContentForm.selectEvenElement(metalsColorsDataSet.getSummary().get(1));


        mainContentForm.clickCalculateButton();
        mainContentForm.selectMetal(metalsColorsDataSet.getMetals());
        mainContentForm.selectElementCheckbox(metalsColorsDataSet.getElements());

    }
}

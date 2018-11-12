package io.github.epam.jdi.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import io.github.epam.jdi.jsonobjects.TestDataSet;
import io.github.epam.jdi.pages.MetalColors;
import io.github.epam.jdi.utils.InitResults;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

public class Result extends MetalColors {

    // TODO you should not mix up PO and data classes together...

    @FindBy(css = ".results > li")
    private TextList resultText;

    // TODO '*get' method should return smth...

    //=====================Asserts=============================

    @Step
    public void checkResult(TestDataSet testData) {
        InitResults init = new InitResults();
        init.initResultSet(resultText);

        Assert.assertEquals(init.elements, testData.getElements());
        Assert.assertEquals(init.salad, testData.getVegetables());
        Assert.assertEquals(init.color, testData.getColor());
        Assert.assertEquals(init.metal, testData.getMetals());

    }

}

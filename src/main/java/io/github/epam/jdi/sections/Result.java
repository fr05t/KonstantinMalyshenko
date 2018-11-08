package io.github.epam.jdi.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import io.github.epam.jdi.jsonobjects.JsonSet;
import io.github.epam.jdi.pages.MetalColors;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.github.epam.jdi.JDIExampleSite.result;

public class Result extends MetalColors {

    private String summary;
    private List<String> elements;
    private String color;
    private String metal;
    private List<String> salad;

    @FindBy(css = ".results > li")
    private TextList resultText;

    public void getResult() {

        for (Object elm : resultText.getLabels()) {
            if (elm.toString().contains("Summary")) {
                summary = elm.toString().split(": ")[1];
            }
            if (elm.toString().contains("Elements")) {
                elements = Arrays.asList(elm.toString().substring("Elements: ".length()).split(", "));
            }
            if (elm.toString().contains("Color")) {
                color = elm.toString().split(": ")[1];
            }
            if (elm.toString().contains("Metal")) {
                metal = elm.toString().split(": ")[1];
            }
            if (elm.toString().contains("Vegetables")) {
                salad = Arrays.asList(elm.toString().substring("Vegetables: ".length()).split(", "));
            }
        }
    }

    public String returnSummary(ArrayList<String> elms) {
        return (Integer.parseInt(elms.get(0)) + Integer.parseInt(elms.get(1))) + "";
    }

    //=====================Asserts=============================

    @Step
    public void checkResult(JsonSet jsonSet) {
        result.getResult();

        System.out.println(jsonSet.getSummary());
        System.out.println();

        Assert.assertEquals(elements, jsonSet.getElements());
        Assert.assertEquals(salad, jsonSet.getVegetables());
        Assert.assertEquals(color, jsonSet.getColor());
        Assert.assertEquals(metal, jsonSet.getMetals());

    }

}

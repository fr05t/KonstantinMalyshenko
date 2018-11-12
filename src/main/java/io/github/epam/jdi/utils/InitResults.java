package io.github.epam.jdi.utils;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;

import java.util.Arrays;
import java.util.List;

import static io.github.epam.jdi.enums.ResultElements.*;

public class InitResults {

    public String summary;
    public List<String> elements;
    public String color;
    public String metal;
    public List<String> salad;

    public void initResultSet(TextList resultText) {

        for (Object elm : resultText.getLabels()) {
            if (elm.toString().contains(SUMMARY.getValue())) {
                summary = elm.toString().split(": ")[1];
            }
            if (elm.toString().contains(ELEMNTS.getValue())) {
                elements = Arrays.asList(elm.toString().substring("Elements: ".length()).split(", "));
            }
            if (elm.toString().contains(COLOR.getValue())) {
                color = elm.toString().split(": ")[1];
            }
            if (elm.toString().contains(METAL.getValue())) {
                metal = elm.toString().split(": ")[1];
            }
            if (elm.toString().contains(VEGETABLES.getValue())) {
                salad = Arrays.asList(elm.toString().substring("Vegetables: ".length()).split(", "));
            }
        }
    }

}

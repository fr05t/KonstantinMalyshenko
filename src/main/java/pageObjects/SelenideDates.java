package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.LogItems.FROM;
import static enums.LogItems.TO;
import static org.testng.Assert.assertEquals;

public class SelenideDates {

    //Page Objects Elements
    @FindBy(css = ".uui-slider")
    private SelenideElement slider;

    @FindBy(css = ".ui-slider-handle.ui-state-default.ui-corner-all span")
    private static ElementsCollection selenideElements;

    @FindBy(css = ".panel-body-list.logs > li")
    private static ElementsCollection logElements;

    //================================methods===================================

    @Step("Move Sliders")
    public void moveSliders(int leftPosition, int rightPosition) {
        int currentRightPosition = Integer.parseInt(selenideElements.get(1).getText());

        if (leftPosition >= currentRightPosition) {
            rightSliderSet(rightPosition);
            leftSliderSet(leftPosition);
        } else {
            leftSliderSet(leftPosition);
            rightSliderSet(rightPosition);
        }
    }

    @Step("Move the left slider")
    public void leftSliderSet(int leftPoint) {

        Actions actions = new Actions(getWebDriver());

        double len = (double) slider.getSize().width / 99;
        int leftPos = (int) Math.floor((leftPoint - Integer.parseInt(selenideElements.get(0).getText())) * len);

        actions.dragAndDropBy(selenideElements.get(0), leftPos, 0).release().build().perform();
    }

    @Step("Move the right slider")
    public void rightSliderSet(int rightPoint) {

        Actions actions = new Actions(getWebDriver());

        double len = (double) slider.getSize().width / 99;
        int rightPos = (int) Math.floor((-rightPoint + Integer.parseInt(selenideElements.get(1).getText())) * len);

        actions.dragAndDropBy(selenideElements.get(1), -rightPos, 0).release().build().perform();
    }

    @Step("Get last events from log")
    public List<String> getLastLogEvents() {

        List<String> lastEvents = new ArrayList<>();
        for (int i = 0; i < logElements.size(); i++) {
            if (logElements.get(i).getText().contains(FROM.getValue())) {
                lastEvents.add(logElements.get(i).getText());
                break;
            }
        }
        for (int i = 0; i < logElements.size(); i++) {
            if (logElements.get(i).getText().contains(TO.getValue())) {
                lastEvents.add(logElements.get(i).getText());
                break;
            }
        }
        return lastEvents;
    }

    //==========================Asserts==========================================

    @Step("Check log value")
    public void checkSliderLogValues(int expectedLeftValue, int expectedRightValue) {

        List<String> lastEvents = getLastLogEvents();

        String regExp = ".+(To|From).+:(\\d+).+";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(lastEvents.get(0));
        matcher.find();
        assertEquals(matcher.group(2), expectedLeftValue + "");

        matcher.reset();
        matcher = pattern.matcher(lastEvents.get(1));

        matcher.find();
        assertEquals(matcher.group(2), expectedRightValue + "");
    }
}

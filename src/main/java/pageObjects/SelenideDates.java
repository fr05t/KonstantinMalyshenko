package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.it.Ma;
import enums.DatesInputValues;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static enums.DatesInputValues.*;

public class SelenideDates {

    @FindBy(css = ".uui-slider")
    private SelenideElement slider;

    @FindBy(css = ".ui-slider-handle.ui-state-default.ui-corner-all span")
    private ElementsCollection sliderEliments;

    @FindBy(css = ".panel-body-list.logs > li")
    private ElementsCollection logElements;

    //================================methods===================================

    public void leftSilderSet(WebDriver driver, int leftPoint) throws InterruptedException {

        Actions actions = new Actions(driver);

        double len = (double)slider.getSize().width/99;
        int leftPos =  (int)Math.floor((leftPoint-Integer.parseInt(sliderEliments.get(0).getText()))*len);

        actions.dragAndDropBy(sliderEliments.get(0),  leftPos, 0).release().build().perform();
        System.out.println("right value " + Integer.parseInt(sliderEliments.get(0).getText())*len);
    }

    public void rightSliderSet(WebDriver driver, int rightPoint) {

        Actions actions = new Actions(driver);

        double len = (double)slider.getSize().width/99;
        int rightPos = (int)Math.floor((-rightPoint+Integer.parseInt(sliderEliments.get(1).getText()))*len);

        actions.dragAndDropBy(sliderEliments.get(1),  -rightPos, 0).release().build().perform();
        System.out.println("right value " + Integer.parseInt(sliderEliments.get(1).getText())*len);
    }

    public List<String> getLastLogEvents() {
        List<String> lastEvents = new ArrayList<>();
        for(int i = logElements.size()-1; i >=0; i--) {
            if (logElements.get(i).getText().contains("From")) {
                lastEvents.add(logElements.get(i).getText());
                break;
            }

        }
        for(int i = logElements.size()-1; i >=0; i--) {
            if (logElements.get(i).getText().contains("To")) {
                lastEvents.add(logElements.get(i).getText());
                break;
            }
        }
        return lastEvents;
    }



    //==========================Asserts==========================================

    public void checkLeftSliderValue(String value) {
        Assert.assertEquals(sliderEliments.get(0).getText(),value);
//        $(sliderEliments.get(0).getText()).shouldBe(Condition.text(value));
    }

    public void checkRightSliderValue(String value) {
        Assert.assertEquals(sliderEliments.get(1).getText(), value);
    }

    public void checkSliderLogValues(List<String> lastEvents) {
        String regExp= ".+(To|From).+:(\\d+).+";
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(lastEvents.get(0));
        matcher.find();
        Assert.assertEquals(STEP6_LEFT_SLIDER_VALUE.getStringValue(), matcher.group(2));

        matcher.reset();
        matcher = pattern.matcher(lastEvents.get(1));

        matcher.find();
        Assert.assertEquals(STEP6_RIGHT_SLIDER_VALUE.getStringValue(), matcher.group(2));
    }




}

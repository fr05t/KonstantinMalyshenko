package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class SelenideDates {

    @FindBy(css = ".uui-slider")
    private SelenideElement slider;


    //================================methods===================================

    public void setSliderValues(WebDriver driver) {
        Actions move = new Actions(driver);

        Action action = (Action)move.dragAndDropBy(slider.getWrappedElement(),30, 0).build();
        ((org.openqa.selenium.interactions.Action) action).perform();




    }


    //==========================Asserts==========================================
}

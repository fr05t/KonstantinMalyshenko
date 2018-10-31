package hw4;

import base.SelenideTestBase;
import enums.DatesInputValues;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.SelenideDates;
import pageObjects.SelenideDifferentElements;
import pageObjects.SelenideHomePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.DatesInputValues.*;
import static enums.Users.PITER_CHALOVSKII;
import static org.testng.Assert.assertEquals;

public class SelenideDatesPageTest extends SelenideTestBase {

    private SelenideHomePage selenideHomePage;
    private SelenideDifferentElements selenideDifferentElements;
    private SelenideDates selenideDates;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        selenideHomePage = page(SelenideHomePage.class);
        selenideDifferentElements = page(SelenideDifferentElements.class);
        selenideDates = page(SelenideDates.class);

    }

    @Test
    public void Test() throws InterruptedException {

        //1. Open URL
        open("https://epam.github.io/JDI/");

        //2.  Assert Browser title
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //3. Perform login
        selenideHomePage.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

        //4. Assert User name in the left-top side of screen that user is loggined
        selenideHomePage.checkUserName();

        //5. Open through the header menu Service -> Dates Page
        selenideHomePage.serviceDropDownListClick();
        selenideHomePage.openDatesPage();

        //6. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        selenideDates.leftSilderSet(getWebDriver(), STEP6_LEFT_SLIDER_VALUE.getValue());
        selenideDates.checkLeftSliderValue(STEP6_LEFT_SLIDER_VALUE.getStringValue());
        selenideDates.rightSliderSet(getWebDriver(), STEP6_RIGHT_SLIDER_VALUE.getValue());
        selenideDates.checkRightSliderValue(STEP6_RIGHT_SLIDER_VALUE.getStringValue());


        //7. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        selenideDates.checkSliderLogValues(selenideDates.getLastLogEvents());

        //8. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        selenideDates.leftSilderSet(getWebDriver(), STEP8_LEFT_SLIDER_VALUE.getValue());
        selenideDates.checkLeftSliderValue(STEP8_LEFT_SLIDER_VALUE.getStringValue());
        selenideDates.rightSliderSet(getWebDriver(), STEP8_RIGHT_SLIDER_VALUE.getValue());
        selenideDates.checkRightSliderValue(STEP8_RIGHT_SLIDER_VALUE.getStringValue());


        //9. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        selenideDates.checkSliderLogValues(selenideDates.getLastLogEvents());

        //10. Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        selenideDates.rightSliderSet(getWebDriver(), STEP10_RIGHT_SLIDER_VALUE.getValue());
        selenideDates.checkRightSliderValue(STEP10_RIGHT_SLIDER_VALUE.getStringValue());
        selenideDates.leftSilderSet(getWebDriver(), STEP10_LEFT_SLIDER_VALUE.getValue());
        selenideDates.checkLeftSliderValue(STEP10_LEFT_SLIDER_VALUE.getStringValue());

        //11. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        selenideDates.checkSliderLogValues(selenideDates.getLastLogEvents());

        //12. Using drag-and-drop set Range sliders.
        selenideDates.leftSilderSet(getWebDriver(), STEP12_LEFT_SLIDER_VALUE.getValue());
        selenideDates.checkLeftSliderValue(STEP12_LEFT_SLIDER_VALUE.getStringValue());
        selenideDates.rightSliderSet(getWebDriver(), STEP12_RIGHT_SLIDER_VALUE.getValue());
        selenideDates.checkRightSliderValue(STEP12_RIGHT_SLIDER_VALUE.getStringValue());

        //13.
        selenideDates.checkSliderLogValues(selenideDates.getLastLogEvents());

        Thread.sleep(2000);
    }
}

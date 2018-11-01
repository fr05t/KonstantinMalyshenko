package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.SelenideDates;
import pageObjects.SelenideDifferentElements;
import pageObjects.SelenideHomePage;

import static com.codeborne.selenide.Selenide.page;
import static enums.DatesInputValues.*;
import static enums.PageTitles.HOME_PAGE;
import static enums.Users.PITER_CHALOVSKII;

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
        selenideHomePage.openPage();

        //2.  Assert Browser title
        selenideHomePage.checkPageTitle(HOME_PAGE);

        //3. Perform login
        selenideHomePage.login(PITER_CHALOVSKII);

        //4. Assert User name in the left-top side of screen that user is loggined
        selenideHomePage.checkUserName();

        //5. Open through the header menu Service -> Dates Page
        selenideHomePage.serviceDropDownListClick();
        selenideHomePage.openDatesPage();

        //6. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        selenideDates.leftSilderSet(STEP6_LEFT_SLIDER_VALUE.getValue());
        selenideDates.rightSliderSet(STEP6_RIGHT_SLIDER_VALUE.getValue());
        selenideDates.moveSliders(0, 100);

        //  selenideDates.checkLeftSliderValue(STEP6_LEFT_SLIDER_VALUE.getStringValue());
        //  selenideDates.checkRightSliderValue(STEP6_RIGHT_SLIDER_VALUE.getStringValue());

        Thread.sleep(2000);
        //7. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        selenideDates.checkSliderLogValues(selenideDates.getLastLogEvents());
        Thread.sleep(2000);
        //8. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        /*selenideDates.leftSilderSet( STEP8_LEFT_SLIDER_VALUE.getValue());
        selenideDates.rightSliderSet( STEP8_RIGHT_SLIDER_VALUE.getValue());*/
        selenideDates.moveSliders(0, 0);
        Thread.sleep(2000);
        selenideDates.checkLeftSliderValue(STEP8_LEFT_SLIDER_VALUE.getStringValue());
        selenideDates.checkRightSliderValue(STEP8_RIGHT_SLIDER_VALUE.getStringValue());
        Thread.sleep(2000);
        //9. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        selenideDates.checkSliderLogValues(selenideDates.getLastLogEvents());
        Thread.sleep(2000);
        //10. Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        /*selenideDates.rightSliderSet( STEP10_RIGHT_SLIDER_VALUE.getValue());
        selenideDates.leftSilderSet( STEP10_LEFT_SLIDER_VALUE.getValue());*/
        selenideDates.moveSliders(100, 100);
        selenideDates.checkRightSliderValue(STEP10_RIGHT_SLIDER_VALUE.getStringValue());
        selenideDates.checkLeftSliderValue(STEP10_LEFT_SLIDER_VALUE.getStringValue());
        //11. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        Thread.sleep(2000);
        selenideDates.checkSliderLogValues(selenideDates.getLastLogEvents());

        //12. Using drag-and-drop set Range sliders.
/*
        selenideDates.leftSilderSet(STEP12_LEFT_SLIDER_VALUE.getValue());
        selenideDates.rightSliderSet( STEP12_RIGHT_SLIDER_VALUE.getValue());
*/
        Thread.sleep(2000);
        selenideDates.moveSliders(30, 70);
        selenideDates.checkLeftSliderValue(STEP12_LEFT_SLIDER_VALUE.getStringValue());
        selenideDates.checkRightSliderValue(STEP12_RIGHT_SLIDER_VALUE.getStringValue());

        //13.
        selenideDates.checkSliderLogValues(selenideDates.getLastLogEvents());

        Thread.sleep(10000);
    }
}

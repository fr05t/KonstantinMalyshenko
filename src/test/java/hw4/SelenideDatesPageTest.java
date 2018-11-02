package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.SelenideDates;
import pageObjects.SelenideHomePage;

import static com.codeborne.selenide.Selenide.page;
import static enums.DatesInputValues.*;
import static enums.PageTitles.HOME_PAGE;
import static enums.Users.PITER_CHALOVSKII;

public class SelenideDatesPageTest extends SelenideTestBase {

    private SelenideHomePage selenideHomePage;
    private SelenideDates selenideDates;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        selenideHomePage = page(SelenideHomePage.class);
        selenideDates = page(SelenideDates.class);
    }

    @Test
    public void Test() {

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
        selenideDates.moveSliders(0, 100);

        //7. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        selenideDates.checkSliderLogValues(STEP6_SET);

        //8. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        selenideDates.moveSliders(0, 0);

        //9. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        selenideDates.checkSliderLogValues(STEP8_SET);

        //10. Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        selenideDates.moveSliders(100, 100);

        //11. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        selenideDates.checkSliderLogValues(STEP10_SET);

        //12. Using drag-and-drop set Range sliders.
        selenideDates.moveSliders(30, 70);

        //13. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        selenideDates.checkSliderLogValues(STEP12_SET);
    }
}

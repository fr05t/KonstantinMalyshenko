package hw4;

import base.SelenideTestBase;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.SelenideDates;
import pageObjects.SelenideHomePage;

import static com.codeborne.selenide.Selenide.page;
import static enums.PageTitles.DATES;
import static enums.PageTitles.HOME_PAGE;
import static enums.Users.PITER_CHALOVSKII;

@Feature("Smoke tests")
@Story("Dates Page testing")
@Listeners(AllureAttachmentListener.class)
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

        //4. Assert UserCredentials name in the left-top side of screen that user is logged in
        selenideHomePage.checkUserName();

        //5. Open through the header menu Service -> Dates Page
        selenideHomePage.serviceDropDownListClick();
        selenideHomePage.openDatesPage();
        selenideHomePage.checkPageTitle(DATES);

        //6. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most right position
        selenideDates.moveSliders(0, 100);

        //7. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        selenideDates.checkSliderLogValues(0, 100);

        //8. Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        selenideDates.moveSliders(0, 0);

        //9. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        selenideDates.checkSliderLogValues(0, 0);

        //10. Using drag-and-drop set Range sliders. left sliders - the most right position, right slider - the most right position.
        selenideDates.moveSliders(100, 100);

        //11. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        selenideDates.checkSliderLogValues(100, 100);

        //12. Using drag-and-drop set Range sliders.
        selenideDates.moveSliders(30, 70);

        //13. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        selenideDates.checkSliderLogValues(30, 70);
    }
}

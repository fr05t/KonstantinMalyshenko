package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.SelenideDates;
import pageObjects.SelenideDifferentElements;
import pageObjects.SelenideHomePage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
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
    public void Test() {

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
        selenideDates.setSliderValues(getWebDriver());
    }
}

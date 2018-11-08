package hw4;

import base.SelenideTestBase;
import enums.PageTitles;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.SelenideDifferentElements;
import pageObjects.SelenideHomePage;

import static com.codeborne.selenide.Selenide.page;
import static enums.CheckboxItems.WATER;
import static enums.CheckboxItems.WIND;
import static enums.DropDownMenuItems.YELLOW;
import static enums.PageTitles.*;
import static enums.PageTitles.DIFFERENT_ELEMENTS;
import static enums.RadioButtonItems.SELEN;
import static enums.Users.PITER_CHALOVSKII;

public class SelenideServicePageTest extends SelenideTestBase {

    private SelenideHomePage selenideHomePage;
    private SelenideDifferentElements selenideDifferentElements;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        selenideHomePage = page(SelenideHomePage.class);
        selenideDifferentElements = page(SelenideDifferentElements.class);

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

        //5. Click on "Service" subcategory in the header and check that drop down contains options
        selenideHomePage.serviceDropDownListClick();
        selenideHomePage.checkServiceDropdownMenuSubcategory();


        //6. Click on Service subcategory in the left section and check that drop down contains options
        selenideHomePage.setServiceLeftMenuClick();
        selenideHomePage.checkLeftServiceMenuItems();

        //7. Open through the header menu Service -> Different Elements Page
        selenideHomePage.serviceDropDownListClick();
        selenideHomePage.openDifferenElementsPage();
        selenideDifferentElements.checkTitle(DIFFERENT_ELEMENTS);


        //8. Check interface on Different elements page, it contains all needed elements
        selenideDifferentElements.checkCheckBoxItems();
        selenideDifferentElements.checkDropdownButton();
        selenideDifferentElements.checkButtons();
        selenideDifferentElements.checkRadioElements();

        //9. Assert that there is Right Section
        selenideDifferentElements.checkRightSection();

        //10. Assert that there is Left Section
        selenideDifferentElements.checkLeftSection();

        //11. Select checkboxes
        selenideDifferentElements.selectCheckboxes(WATER, WIND);

        //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        selenideDifferentElements.checkCheckboxesLogTrue(WATER, WIND);

        //13. Select radio
        selenideDifferentElements.selectRadioElement(SELEN);

        //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        selenideDifferentElements.checkRadioButton(SELEN);

        //15. Select in dropdown
        selenideDifferentElements.selectDropdownElement();

        //16. Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        selenideDifferentElements.checkColorLog(YELLOW);

        //17. Unselect and assert checkboxes
        selenideDifferentElements.selectCheckboxes(WATER, WIND);

        //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
        selenideDifferentElements.checkCheckboxesLogFalse(WATER, WIND);

    }
}

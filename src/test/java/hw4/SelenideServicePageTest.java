package hw4;

import base.SelenideTestBase;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.SelenideDifferentElements;
import pageObjects.SelenideHomePage;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Users.PITER_CHALOVSKII;
import static org.testng.Assert.assertEquals;

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
        open("https://epam.github.io/JDI/");

        //2.  Assert Browser title
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //3. Perform login
        selenideHomePage.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);

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
        selenideDifferentElements.selecCheckboxes();

        //12. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 

        //13. Select radio
        selenideDifferentElements.seleRadioElement();

        //14. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 


        //15. Select in dropdown
        selenideDifferentElements.selectDropdownElement();

        //16. Assert that for dropdown there is a log row and value is corresponded to the selected value. 

        //17. Unselect and assert checkboxes
        selenideDifferentElements.selecCheckboxes();

        //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 

    }
}

package io.github.epam.jdi;

import io.github.epam.jdi.dataproviders.DataProviders;
import io.github.epam.jdi.jsonobjects.MetalsColorsDataSet;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static io.github.epam.jdi.JDIExampleSite.*;
import static io.github.epam.jdi.enums.Users.PITER_CHAILOVSKII;

public class MetalsColorsTests extends MetalsColorsTestsInit {

    @AfterMethod
    public void afterMethod() {
        metalColors.clearCache();
        metalColors.reload();
    }

    @Test(dataProvider = "jsonParser", dataProviderClass = DataProviders.class)
    public void loginTest(String i, MetalsColorsDataSet jsonSets) {

        //0. Open Home Page
        homePage.open();
        homePage.checkOpened();

        //1. Login on JDI site as User
        login(PITER_CHAILOVSKII);
        // Check Login
        checkUsername(PITER_CHAILOVSKII);

        //2. Open Metals & Colors page by Header menu
        headerMenu.openMetalColors();

        //3. Fill form Metals & Colors by data below:
        metalColors.fillForm(jsonSets);

        //4. Submit form Metals & Colors
        mainContentForm.clickSubmitButton();

        //5. Assert result section
        result.checkResult(jsonSets);

    }
}

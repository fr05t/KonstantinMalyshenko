package io.github.epam.jdi;

import enums.Users;
import io.github.epam.jdi.dataproviders.DataProviders;
import io.github.epam.jdi.entities.User;
import io.github.epam.jdi.jsonobjects.JsonSet;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import static io.github.epam.jdi.enums.Users.PITER_CHAILOVSKII;
import static io.github.epam.jdi.JDIExampleSite.*;

public class MetalsColorsTests extends MetalsColorsTestsInit {

    @AfterMethod
    public void afterMethod() {
        metalColors.clearCache();
        metalColors.reload();
    }

    @Test(dataProvider = "jsonParser", dataProviderClass = DataProviders.class)
    public void loginTest(Object i, JsonSet jsonSets) {

        //0. Open Home Page
        homePage.open();
        homePage.checkOpened();

        //1. Login on JDI site as User
        login();
        // Check Login
        checkUsername(PITER_CHAILOVSKII);

        //2. Open Metals & Colors page by Header menu
        headerMenu.openMetalColors();

        //3. Fill form Metals & Colors by data below:
        metalColors.fillForm(jsonSets);

        //4. Submit form Metals & Colors
        metalColors.clickSubmitButton();

        //5. Assert result section
        result.checkResult(jsonSets);

    }
}

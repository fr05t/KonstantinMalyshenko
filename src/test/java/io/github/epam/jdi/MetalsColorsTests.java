// TODO Quite weird package name, but nevermind...
package io.github.epam.jdi;

import io.github.epam.jdi.dataproviders.DataProviders;
import io.github.epam.jdi.jsonobjects.JsonSet;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

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

        // TODO Both of this methods should be parametrised by exactly the same instance...
        //1. Login on JDI site as User
        login();
        // Check Login
        checkUsername();
        // !TODO

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

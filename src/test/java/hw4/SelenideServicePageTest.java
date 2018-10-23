package hw4;

import base.SelenideTestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.SelenideHomePage;


import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.Users.PITER_CHALOVSKII;
import static org.testng.Assert.assertEquals;

public class SelenideServicePageTest extends SelenideTestBase {

    private SelenideHomePage selenideHomePage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        selenideHomePage = page(SelenideHomePage.class);
    }

    @Test
    public void Test() {

        //1. Open URL
        open("https://epam.github.io/JDI/");

        //2.  Assert Browser title
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //3. Perform login
        selenideHomePage.login(PITER_CHALOVSKII.login, PITER_CHALOVSKII.password);



    }
}

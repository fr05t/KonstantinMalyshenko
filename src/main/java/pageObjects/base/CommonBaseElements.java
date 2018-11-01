package pageObjects.base;

import com.codeborne.selenide.SelenideElement;
import enums.PageTitles;
import enums.URLs;
import enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public abstract class CommonBaseElements {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = "[type = 'submit']")
    private SelenideElement submit;


    //Methods
    @Step("Open page")
    public void openPage() {
        open(URLs.HOME_PAGE_URL.getUrl());
    }

    @Step("Check page title")
    public void checkPageTitle(PageTitles pageTitles) {
        assertEquals(getWebDriver().getTitle(), pageTitles.getTitle());
    }

    @Step("Perform login")
    public void login(Users user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }

}

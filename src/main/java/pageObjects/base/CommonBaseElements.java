package pageObjects.base;

import com.codeborne.selenide.SelenideElement;
import enums.PageTitles;
import enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static enums.URLs.HOME_PAGE_URL;
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
    @Step
    public void openPage() {
        open(HOME_PAGE_URL.getUrl());
    }

    @Step
    public void checkPageTitle(PageTitles pageTitles) {
        assertEquals(getWebDriver().getTitle(), pageTitles.getTitle());
    }

    @Step
    public void login(Users user) {
        profileButton.click();
        login.sendKeys(user.login);
        password.sendKeys(user.password);
        submit.click();
    }

}

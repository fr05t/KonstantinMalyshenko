package io.github.epam.jdi;

import com.epam.jdi.uitests.core.interfaces.base.IClickable;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import io.github.epam.jdi.entities.UserCredentials;
import io.github.epam.jdi.enums.Users;
import io.github.epam.jdi.pages.HomePage;
import io.github.epam.jdi.pages.MetalColors;
import io.github.epam.jdi.sections.HeaderMenu;
import io.github.epam.jdi.sections.LoginForm;
import io.github.epam.jdi.sections.MetalColorsForm;
import io.github.epam.jdi.sections.Result;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static org.testng.Assert.assertEquals;

@JSite("https://epam.github.io/JDI/")
public class JDIExampleSite extends WebSite {
    public static HomePage homePage;
    public static HeaderMenu headerMenu;
    public static MetalColors metalColors;
    public static Result result;
    public static MetalColorsForm metalColorsForm;

    public static LoginForm loginForm;

    @FindBy(css = ".profile-photo")
    public static IClickable profilePhoto;

    @Step
    public static void login(Users user) {
        profilePhoto.click();
        loginForm.loginAs(new UserCredentials(user.getLogin(), user.getPassword()));
    }

    @Step
    public static void checkUsername(Users user) {
        assertEquals(headerMenu.username.getText(), user.getUsername());
    }
}

package io.github.epam.jdi.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.simple.Css;
import io.github.epam.jdi.pages.HomePage;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static io.github.epam.jdi.enums.HeaderMenu.METALS_COLORS;

public class HeaderMenu extends HomePage {

    @Css(".m-l8")
    public Menu headerMenu;

    @Css(".profile-photo [ui='label']")
    public Text username;

    @FindBy(css = ".uui-navigation a[href = 'metals-color.html']")
    private Link metalsColors;

    @Step
    public void openMetalColors() {
        headerMenu.clickOn(METALS_COLORS.getValue());
        checkOpened();
    }

}

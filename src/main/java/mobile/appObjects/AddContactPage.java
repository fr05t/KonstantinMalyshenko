package mobile.appObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddContactPage {

    @AndroidFindBy(xpath = "//android.widget.Button")
    private MobileElement addContactButton;

    public void clickAddContactButton(AppiumDriver driver) {
            addContactButton.click();
    }
}

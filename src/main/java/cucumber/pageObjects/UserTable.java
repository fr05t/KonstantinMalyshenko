package cucumber.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import cucumber.api.java.en.And;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.page;

public class UserTable {

    public UserTable() {
        page(this);
    }

    @FindBy(css = "#user-table  select")
    private ElementsCollection dropdowns;

    @FindBy(css = "#user-table  a")
    private ElementsCollection userNames;

    @FindBy(css = "#user-table  img")
    private ElementsCollection images;

    @FindBy(css = "#user-table  span")
    private ElementsCollection descriptionTexts;

    @FindBy(css = "#user-table  input")
    private ElementsCollection checkboxes;


    //=========================Methods================================================
    @And("(\\d+) NumberType Dropdowns are displayed on Users Table on User Table Page")
    public void checkDropdowns(Integer num) {
        dropdowns.shouldHaveSize(num);
    }

    @And("(\\d+) User names are displayed on Users Table on User Table Page")
    public void checkUserNames(Integer num) {
        userNames.shouldHaveSize(num);
    }

    @And("(\\d+) Description images are displayed on Users Table on User Table Page")
    public void checkImages(Integer num) {
        images.shouldHaveSize(num);
    }

    @And("(\\d+) Description texts under images are displayed on Users Table on User Table Page")
    public void checkDescriptionText(Integer num) {
        descriptionTexts.shouldHaveSize(num);
    }

    @And("(\\d+) checkboxes are displayed on Users Table on User Table Page")
    public void checkCheckboxes(Integer num) {
        checkboxes.shouldHaveSize(num);
    }

}

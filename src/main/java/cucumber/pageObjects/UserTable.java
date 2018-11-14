package cucumber.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import cucumber.CustomObjects;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.page;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

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

    @FindBy(css = "#user-table")
    private ElementsCollection table;

    @FindBy(css = ".logs > li")
    private ElementsCollection logRows;


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

    @And("User table contains following values:")
    public void checkTableState(List<CustomObjects> users) {
        List<String> userTable = new ArrayList<>();
        String tableValue;
        for (int i = 0; i < userNames.size(); i++) {
            tableValue = userNames.get(i).getText() + " " + descriptionTexts.get(i).getText().replace("\n", " ");
            //        Assert.assertTrue(users.get(i).toString().equals(tableValue));
        }
    }

    @When("I select 'vip' checkbox for \"(.*)\"")
    public void checkVipStatus(String username) {
        checkboxes.get(userNames.texts().indexOf(username)).click();
    }

    @Then("(\\d+) log row has \"(.*)\" text in log section")
    public void checkLogRow(int row, String conditionRow) {
        List<String> list = new ArrayList<>();
        for (String elm : logRows.texts()) {
            list.add(elm.replaceAll("(\\d+:?)\\s?", ""));
        }
        assertTrue(list.contains(conditionRow));
        assertEquals(row, logRows.size());
    }

    @When("I click on dropdown in column Type for user (.*)")
    public void checkDropdownList(String username) {
        dropdowns.get(userNames.texts().indexOf(username)).click();
    }

    @Then("droplist contains values:")
    public void checkDropdownValues(List<String> values) {
        List<String> list = values.subList(1, values.size());
        assertTrue(dropdowns.get(0).findAll("option").texts().containsAll(list));
    }

}

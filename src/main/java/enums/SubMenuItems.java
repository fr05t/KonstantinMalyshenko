package enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum SubMenuItems {

    SUPPORT("SUPPORT", "Support"), DATES("DATES", "Dates"), COMPLEX_TABLE("COMPLEX TABLE", "Complex Table"), SIMPLE_TABLE("SIMPLE TABLE", "Simple Table"), USER_TABLE("USER TABLE", "UserCredentials Table"),
    TABLE_WITH_PAGES("TABLE WITH PAGES", "Table with pages"), DIFFERENT_ELEMENTS("DIFFERENT ELEMENTS", "Different elements"), PERFORMANCE("PERFORMANCE", "Performance");

    private String upperCaseValue;
    private String lowerCaseValue;

    SubMenuItems(String upperValue, String lowerValue) {
        this.upperCaseValue = upperValue;
        this.lowerCaseValue = lowerValue;
    }

    public String getUpperCaseValue() {
        return this.upperCaseValue;
    }

    public String getLowerCaseValue() {
        return this.lowerCaseValue;
    }

    public static List<String> getUpperCaseMenuItems() {
        List<SubMenuItems> menuItems = Arrays.asList(SubMenuItems.values());
        List<String> menuItemsValues = new ArrayList<>();

        for (SubMenuItems elm : menuItems) {
            menuItemsValues.add(elm.getUpperCaseValue());
        }
        return menuItemsValues;
    }

    public static List<String> getLowerCaseMenuItems() {
        List<SubMenuItems> menuItems = Arrays.asList(SubMenuItems.values());
        List<String> menuItemsValues = new ArrayList<>();

        for (SubMenuItems elm : menuItems) {
            menuItemsValues.add(elm.getLowerCaseValue());
        }
        return menuItemsValues;
    }

}

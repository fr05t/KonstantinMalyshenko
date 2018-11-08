package enums;

public enum CheckboxItems {
    WATER("Water"), EARTH("Earth"), WIND("Wind"), FIRE("Fire"), TRUE("true"), FALSE("false");

    private String checkboxItemName;

    CheckboxItems(String checkboxItemName) {
        this.checkboxItemName = checkboxItemName;
    }

    public String getCheckboxItemName() {
        return this.checkboxItemName;
    }
}

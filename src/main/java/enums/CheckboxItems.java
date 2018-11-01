package enums;

public enum CheckboxItems {
    Water("Water"), Earth("Earth"), Wind("Wind"), Fire("Fire");

    private String checkboxItemName;
    
    CheckboxItems (String checkboxItemName) {
        this.checkboxItemName = checkboxItemName;
    }

    public String getCheckboxItemName() {
        return this.checkboxItemName;
    }
}

package io.github.epam.jdi.enums;

public enum HeaderMenu {
    HOME("Home"), CONTACT_FORM("Contact form"), SERVICE("Service"), METALS_COLORS("Metals & Colors");

    private String value;

    HeaderMenu(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

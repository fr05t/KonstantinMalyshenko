package io.github.epam.jdi.enums;

public enum ResultElements {
    SUMMARY("Summary"), ELEMNTS("Elements"), COLOR("Color"), METAL("Metal"), VEGETABLES("Vegetables");

    private String value;

    ResultElements(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
